package inn.shopping.api.form;

import org.apache.commons.lang.StringUtils;

public class OrderForm {
	private String cartIds;
	private String addressId ;
	private String customerMark;
	private String totalPrice;
	
	public boolean checkeParam() {
		if(StringUtils.isBlank(cartIds) ||StringUtils.isBlank(addressId))
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
}
