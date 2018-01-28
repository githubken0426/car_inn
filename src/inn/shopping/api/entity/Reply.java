package inn.shopping.api.entity;

import java.sql.Date;

import inn.shopping.api.InnApiConfig;
/**
 * 回复
 * @ClassName: Reply 
 * @Description: 
 * @author ken 
 * @date 2018年1月27日 下午4:19:06
 */
public class Reply {
	private String id;
	private String userId;
	private String commentId;
	private String toUserId;
	private String content;
	private Date createTime;
	
	private String nickname;
	private String toNickname;
	private String avatarUrl;
	private String toAvatarUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getToNickname() {
		return toNickname;
	}
	public void setToNickname(String toNickname) {
		this.toNickname = toNickname;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl =InnApiConfig.INN_API.getValue("http_ftp_ip")+  avatarUrl;
	}
	public String getToAvatarUrl() {
		return toAvatarUrl;
	}
	public void setToAvatarUrl(String toAvatarUrl) {
		this.toAvatarUrl = InnApiConfig.INN_API.getValue("http_ftp_ip")+ toAvatarUrl;
	}
}
