package inn.shopping.api.entity;

import inn.shopping.api.InnApiConfig;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
/**
 * 评论
 * @author ken
 *
 */
public class Comment {
	private String id;
	private String orderId;
	private String goodsId;
	private String userId;
	private String tagIds;
	private String anonymous;//是否匿名评论：Y是，N否
	private String status;//评价状态：G好评，M中评，B差评
	private Integer describeStatus;
	private Integer serviceAttitude;
	private Integer serviceLogistics;
	private String content;
	private String isPicture;//是否有图：Y是，N否
	private String isAppend;//是否追加评价：Y是，N否
	private String picture;
	private Date createTime;
	
	private Integer commend;//点赞数量
	private String diffDays;//追评相隔天数
	private String nickname;
	private String avatarUrl;
	private String specItemIds;
	private List<Map<String,String>> specItemList;
	private List<String> pictureList;
	private CommentAppend commentAppend;
	
	public String getTagIds() {
		return tagIds;
	}
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getCommend() {
		return commend;
	}
	public void setCommend(Integer commend) {
		this.commend = commend;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getDescribeStatus() {
		return describeStatus;
	}
	public void setDescribeStatus(Integer describeStatus) {
		this.describeStatus = describeStatus;
	}
	public Integer getServiceAttitude() {
		return serviceAttitude;
	}
	public void setServiceAttitude(Integer serviceAttitude) {
		this.serviceAttitude = serviceAttitude;
	}
	public Integer getServiceLogistics() {
		return serviceLogistics;
	}
	public void setServiceLogistics(Integer serviceLogistics) {
		this.serviceLogistics = serviceLogistics;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
		this.pictureList= StringUtils.isNotBlank(picture) ? Arrays.asList(picture.split(",")):null;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<String> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<String> pictureList) {
		this.pictureList = pictureList;
	}
	public String getIsPicture() {
		return isPicture;
	}
	public void setIsPicture(String isPicture) {
		this.isPicture = isPicture;
	}
	public String getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIsAppend() {
		return isAppend;
	}
	public void setIsAppend(String isAppend) {
		this.isAppend = isAppend;
	}
	public String getSpecItemIds() {
		return specItemIds;
	}
	public void setSpecItemIds(String specItemIds) {
		this.specItemIds = specItemIds;
	}
	public List<Map<String, String>> getSpecItemList() {
		return specItemList;
	}
	public void setSpecItemList(List<Map<String, String>> specItemList) {
		this.specItemList = specItemList;
	}
	
	public String getDiffDays() {
		return diffDays;
	}
	public void setDiffDays(String diffDays) {
		this.diffDays = diffDays;
	}
	public CommentAppend getCommentAppend() {
		return commentAppend;
	}
	public void setCommentAppend(CommentAppend commentAppend) {
		this.commentAppend = commentAppend;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl =InnApiConfig.INN_API.getValue("http_ftp_ip")+ avatarUrl;
	}
}
