package inn.shopping.api.entity;

import java.util.Date;
/**
 * 评论
 * @author ken
 *
 */
public class Comment {
	private String id;
	private String goodsId;
	private String userId;
	private String toUserId;
	private String type;
	private String status;
	private Integer describeStatus;
	private Integer serviceAttitude;
	private Integer serviceLogistics;
	private String content;
	private String picture;
	private Date createTime;
	
	
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
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
