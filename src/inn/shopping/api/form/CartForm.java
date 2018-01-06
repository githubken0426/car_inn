package inn.shopping.api.form;

public class CartForm {
	
	private String goodsId;
	private String number;
	private String specItemIds;
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSpecItemIds() {
		return specItemIds;
	}
	public void setSpecItemIds(String specItemIds) {
		this.specItemIds = specItemIds;
	}
}
