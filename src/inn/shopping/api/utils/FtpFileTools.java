package inn.shopping.api.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import inn.shopping.api.InnApiConfig;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;

/**
 * ftp上传文件
 * 
 * @author Administrator 2016-7-29 上午08:43:40
 */
public class FtpFileTools {
	static String ip = InnApiConfig.INN_API.getValue("ftp_ip");
	static int port = Integer.parseInt(InnApiConfig.INN_API.getValue("ftp_port"));
	static String userName = InnApiConfig.INN_API.getValue("ftp_username");
	static String passWord = InnApiConfig.INN_API.getValue("ftp_password");

	public static boolean uploadFile(String[] paths, String filename, InputStream input) throws IOException {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(ip, port);
			ftp.login(userName, passWord);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				boolean bool1 = success;
				return bool1;
			}
			String[] arrayOfString = paths;
			int j = paths.length;
			for (int i = 0; i < j; i++) {
				String path = arrayOfString[i];
				ftp.makeDirectory(path);
				ftp.changeWorkingDirectory(path);
			}
			ftp.setFileType(2);
			ftp.storeFile(filename, input);
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
			if (ftp != null) {
				ftp.logout();
			}
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		}
		return success;
	}

	public static String downloadFile(HttpServletRequest request, String url, String filename) throws IOException {
		FTPClient ftp = new FTPClient();
		FileOutputStream fos = null;
		String xturl = null;
		try {
			ftp.connect(ip, port);
			ftp.login(userName, passWord);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			ftp.changeWorkingDirectory(url);
			String remoteFileName = filename;
			String webRoot = System.getProperty("wxconsole.root");
			xturl = webRoot + "ftpimgtemp" + File.separator + filename;
			fos = new FileOutputStream(xturl);
			ftp.setFileType(2);
			ftp.retrieveFile(remoteFileName, fos);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		}
		return xturl;
	}

	public static InputStream getFtpInputStream(String remotePath, String fileName) throws IOException {
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(ip, port);
			ftp.login(userName, passWord);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			ftp.changeWorkingDirectory(remotePath);
			ftp.setFileType(2);
			return ftp.retrieveFileStream(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		}
		return null;
	}

	/**
	 * 删除文件
	 */
	public static boolean deleteFile(String filePath) {
		boolean flag = false;
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(ip, port);
			ftp.login(userName, passWord);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			flag = ftp.deleteFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 保存文件，并返回多个文件路径
	 * @param savePath
	 *            保存的路径
	 * @param multipartRequest
	 * @return 并返回多个文件路径,逗号隔开
	 * @throws IOException
	 * @throws ApiException
	 */
	public static String saveFileAndGetUrl(String[] savePath, MultipartHttpServletRequest multipartRequest)
			throws IOException, ApiException {
		Map<String, MultipartFile> map = multipartRequest.getFileMap();
		Iterator<String> it = map.keySet().iterator();
		if (! it.hasNext())
		    return "";
		StringBuffer sb = new StringBuffer();
		for (;;) {
		    String key = it.next();
			MultipartFile file = map.get(key);
			String filename = file.getOriginalFilename();
			String saveFileName = String.valueOf(System.currentTimeMillis())
					+ filename.substring(filename.lastIndexOf("."));
			// 上传到ftp
			boolean bool = uploadFile(savePath, saveFileName, file.getInputStream());
			if (bool) {
				throw new ApiException(APICode.SYS_PICTURE_UPLOAD_ERROR);
			}
			sb.append(File.separator);
			sb.append(savePath[0]);
			sb.append(File.separator);
			sb.append(savePath[1]);
			sb.append(File.separator);
			sb.append(savePath[2]);
			sb.append(File.separator);
			sb.append(saveFileName);
			if (! it.hasNext())
				return sb.toString();
			sb.append(",");
		}
	}
}