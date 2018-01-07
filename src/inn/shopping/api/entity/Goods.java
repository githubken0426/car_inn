package inn.shopping.api.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Goods {
    private String id;
    private String productId;
    private String scoreId;
    private String skuCode;
    private BigDecimal primePrice;
    private BigDecimal promotionPrice;
    private BigDecimal costPrice;
    private String productArea;
    private String goodsTitle;
    private String goodsSynopsis;
    private String goodsDescription;
    private String goodsDetail;
    private String searchTag;
    private Integer stock;
    private String bigPicture;
    private String smallPicture;
    private Integer soldNumber;
    private String isHot;
    private String isNew;
    private Date upTime;
    private Date downTime;
    private Integer status;
    private String cityCode;
    private Date updateTime;
    private double weight;
    
    private Integer commentCount;//评论数量
    private Integer precnet;     //好评百分比
    private List<String> bigPictureList;
    private List<String> smallPictureList;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId == null ? null : scoreId.trim();
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public BigDecimal getPrimePrice() {
        return primePrice;
    }

    public void setPrimePrice(BigDecimal primePrice) {
        this.primePrice = primePrice;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea == null ? null : productArea.trim();
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public String getGoodsSynopsis() {
        return goodsSynopsis;
    }

    public void setGoodsSynopsis(String goodsSynopsis) {
        this.goodsSynopsis = goodsSynopsis == null ? null : goodsSynopsis.trim();
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    public String getSearchTag() {
        return searchTag;
    }

    public void setSearchTag(String searchTag) {
        this.searchTag = searchTag == null ? null : searchTag.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getBigPicture() {
		return bigPicture;
	}

	public void setBigPicture(String bigPicture) {
		this.bigPicture = bigPicture == null ? "" : bigPicture.trim();
		this.bigPictureList= StringUtils.isNotBlank(bigPicture) ? Arrays.asList(bigPicture.split(",")):null;
	}

	public String getSmallPicture() {
		return smallPicture;
	}

	public void setSmallPicture(String smallPicture) {
		this.smallPicture = smallPicture == null ? "" : smallPicture.trim();
		this.smallPictureList= StringUtils.isNotBlank(smallPicture) ? Arrays.asList(smallPicture.split(",")):null;
	}

	public Integer getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(Integer soldNumber) {
        this.soldNumber = soldNumber;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew == null ? null : isNew.trim();
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public List<String> getBigPictureList() {
		return bigPictureList;
	}

	public void setBigPictureList(List<String> bigPictureList) {
		this.bigPictureList = bigPictureList;
	}

	public List<String> getSmallPictureList() {
		return smallPictureList;
	}

	public void setSmallPictureList(List<String> smallPictureList) {
		this.smallPictureList = smallPictureList;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getPrecnet() {
		return precnet;
	}

	public void setPrecnet(Integer precnet) {
		this.precnet = precnet;
	}
}