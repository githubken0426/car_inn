package inn.shopping.api.form;

import java.math.BigDecimal;

public class TobuyGoodsAttr {
	private String goodsId;
	private String goodsTitle;
	private BigDecimal primePrice;
	private BigDecimal promotionPrice;
	private String number;
	private String picture;
	private String specItemIds;
	private String specItemName;
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSpecItemIds() {
		return specItemIds;
	}
	public void setSpecItemIds(String specItemIds) {
		this.specItemIds = specItemIds;
	}
	public String getSpecItemName() {
		return specItemName;
	}
	public void setSpecItemName(String specItemName) {
		this.specItemName = specItemName;
	}
}
