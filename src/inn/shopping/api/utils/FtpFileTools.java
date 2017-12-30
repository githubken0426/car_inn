package inn.shopping.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import inn.shopping.api.InnApiConfig;

/**
 * ftp上传文件
 * 
 * @author Administrator
 *
 *         2016-7-29 上午08:43:40
 */
public class FtpFileTools {

	static String ip = InnApiConfig.INN_API.getValue("ftp_ip");

	static int port = Integer.parseInt(InnApiConfig.INN_API.getValue("ftp_port"));

	static String userName = InnApiConfig.INN_API.getValue("ftp_username");

	static String passWord = InnApiConfig.INN_API.getValue("ftp_password");

	public static boolean uploadFile(String[] paths, String filename, InputStream input) {
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
			if (input != null) {
				try {
					input.close();
				} catch (IOException ioe) {
					e.printStackTrace();
				}
			}
			if (ftp != null) {
				try {
					ftp.logout();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (ftp.isConnected())
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ftp != null) {
				try {
					ftp.logout();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return success;
	}

	public static String downloadFile(HttpServletRequest request, String url, String filename) {
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

			if (ftp.isConnected())
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
					throw new RuntimeException("关闭FTP连接发生异常！", ioe);
				}
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
					throw new RuntimeException("关闭FTP连接发生异常！", ioe);
				}
			}
		}

		return xturl;
	}

	public static InputStream getFtpInputStream(String remotePath, String fileName) {
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
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
					throw new RuntimeException("关闭FTP连接发生异常！", ioe);
				}
			}
			return null;
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
					throw new RuntimeException("关闭FTP连接发生异常！", ioe);
				}
			}
		}
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
			// TODO 异常处理块
			e.printStackTrace();
		}
		return flag;

	}

	public static void main(String[] args) {
		String newName = System.currentTimeMillis() + ".gif";
		try {
			File file2 = new File("C:\\Users\\Administrator\\Desktop\\表情图\\１.gif");
			FileInputStream in = new FileInputStream(file2);
			boolean flag = uploadFile(new String[] { "2016", "04", "20" }, newName, in);
			System.out.println(flag);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}