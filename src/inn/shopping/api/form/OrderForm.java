package inn.shopping.api.form;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class OrderForm {
	private List<OrderGoodsAttribute> goodsAttrList;
	private String addressId ;
	private String expertId;//达人id
	private String totalPrice;
	private String itemCount;
	private String specItemIds;
	private String customerMark;
	private String invoice;
	private String invoiceType;//发票类型,E电子发票,P纸质发票
	private String invoiceTitle;
	private String invoiceContent;
	
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
	public String getExpertId() {
		return expertId;
	}
	public void setExpertId(String expertId) {
		this.expertId = expertId;
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
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getInvoiceContent() {
		return invoiceContent;
	}
	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}
}
