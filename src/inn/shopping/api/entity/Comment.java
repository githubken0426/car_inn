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
	private String goodsId;
	private String userId;
	private String orderId;
	private String tagId;
	private String status;
	private Integer describeStatus;
	private Integer serviceAttitude;
	private Integer serviceLogistics;
	private Integer commend;
	private String content;
	private String isPicture;
	private String picture;
	private Date createTime;
	
	private List<String> pictureList;
	private List<CommentTag> tagList;
	
	
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
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
	
}
