package inn.shopping.api.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Cart {
    private String id;
    private String goodsId;
    private String userId;
    private Integer number;
    private Date createTime;
    private String specItemIds;
    
    private Integer goodsStatus;
    private String goodsTitle;
    private String promotionPrice;
    private String smallPicture;
    private double weight;
    private List<Map<String,String>> specItemList;
    
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getSpecItemIds() {
		return specItemIds;
	}

	public void setSpecItemIds(String specItemIds) {
		this.specItemIds = specItemIds == null ? "": specItemIds.trim();
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public String getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public String getSmallPicture() {
		return smallPicture;
	}

	public void setSmallPicture(String smallPicture) {
		this.smallPicture = smallPicture;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<Map<String, String>> getSpecItemList() {
		return specItemList;
	}

	public void setSpecItemList(List<Map<String, String>> specItemList) {
		this.specItemList = specItemList;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
}