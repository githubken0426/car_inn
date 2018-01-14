package inn.shopping.api.form;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class OrderForm {
	private List<OrderGoodsAttribute> goodsAttrList;
	private String addressId ;
	private String totalPrice;
	private String itemCount;
	private String specItemIds;
	private String customerMark;
	private String invoice;
	
	public boolean checkeParam() {
		if(goodsAttrList.size()== 0 ||StringUtils.isBlank(addressId))
			return false;
		return true;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getSpecItemIds() {
		return specItemIds;
	}

	public void setSpecItemIds(String specItemIds) {
		this.specItemIds = specItemIds;
	}
	
	public List<OrderGoodsAttribute> getGoodsAttrList() {
		return goodsAttrList;
	}
	public void setGoodsAttrList(List<OrderGoodsAttribute> goodsAttrList) {
		this.goodsAttrList = goodsAttrList;
	}
	public String getItemCount() {
		return itemCount;
	}
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}
	public String getCustomerMark() {
		return customerMark;
	}
	public void setCustomerMark(String customerMark) {
		this.customerMark = customerMark;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
}
