package inn.shopping.api.entity;

import java.util.List;
/**
 * 评论属性
 * @author ken
 *
 */
public class CommentAttr {
	private String goodsId;
	private Integer totalCount;  //总评论数
	private Integer goodCount;   //好评数
	private String goodPercent; //好评率
	private Integer middleCount; //中评数
	private Integer badCount;    //差评数
	private Integer pictureCount;//有图评数
	private Integer appendCount; //追加评数
	private Integer replyCount; //回复评数
	//private List<CommentTag> tagList;
	private List<Comment> commentList;
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
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
	public String getGoodPercent() {
		return goodPercent;
	}
	public void setGoodPercent(String goodPercent) {
		this.goodPercent = goodPercent;
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
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
