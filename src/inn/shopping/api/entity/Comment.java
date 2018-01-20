package inn.shopping.api.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	private Integer commend;
	private String content;
	private String isPicture;//是否有图：Y是，N否
	private String isAppend;//是否追加评价：Y是，N否
	private String picture;
	private Date createTime;
	
	private Integer totalCount;  //总评论数
	private Integer goodCount;   //好评数
	private Integer goodPercent; //好评率
	private Integer middleCount; //中评数
	private Integer badCount;    //差评数
	private Integer pictureCount;//有图评数
	private Integer appendCount; //追加评数
	private Integer replyCount; //回复评数
	
	private String nickname;
	private List<String> pictureList;
	private List<CommentTag> tagList;
	
	
	public String getTagIds() {
		return tagIds;
	}
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	public List<CommentTag> getTagList() {
		return tagList;
	}
	public void setTagList(List<CommentTag> tagList) {
		this.tagList = tagList;
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
	public Integer getGoodPercent() {
		return goodPercent;
	}
	public void setGoodPercent(Integer goodPercent) {
		this.goodPercent = goodPercent;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}
	public Integer getMiddleCount() {
		return middleCount;
	}
	public void setMiddleCount(Integer middleCount) {
		this.middleCount = middleCount;
	}
	public Integer getBadCount() {
		return badCount;
	}
	public void setBadCount(Integer badCount) {
		this.badCount = badCount;
	}
	public Integer getPictureCount() {
		return pictureCount;
	}
	public void setPictureCount(Integer pictureCount) {
		this.pictureCount = pictureCount;
	}
	public Integer getAppendCount() {
		return appendCount;
	}
	public void setAppendCount(Integer appendCount) {
		this.appendCount = appendCount;
	}
	public String getIsAppend() {
		return isAppend;
	}
	public void setIsAppend(String isAppend) {
		this.isAppend = isAppend;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
}
