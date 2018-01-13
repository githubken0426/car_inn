package inn.shopping.api.form;

import org.apache.commons.lang.StringUtils;

public class OrderForm {
	private String cartIds;
	private String addressId ;
	private String customerMark;
	private String totalPrice;
	private String goodsId;
	private String number;
	private String specItemIds;
	
	public boolean checkeParam() {
		if(StringUtils.isBlank(cartIds) ||StringUtils.isBlank(addressId))
			return false;
		return true;
	}
	
	public boolean checkeGoods() {
		if(StringUtils.isBlank(goodsId))
			return false;
		return true;
	}
	
	public String getCartIds() {
		return cartIds;
	}
	public void setCartIds(String cartIds) {
		this.cartIds = cartIds;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getCustomerMark() {
		return customerMark;
	}
	public void setCustomerMark(String customerMark) {
		this.customerMark = customerMark;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
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
