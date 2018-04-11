package inn.shopping.api.form;

import java.math.BigDecimal;
import java.util.List;

public class TobuyResult {
	private String addresId;
	private String flag;
	private String shopId;
	private String name;
	private String phone;
	private String address;
	private List<TobuyGoodsAttr> goodsList;
	private BigDecimal totalPrice;
	
	public String getAddresId() {
		return addresId;
	}
	public void setAddresId(String addresId) {
		this.addresId = addresId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<TobuyGoodsAttr> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<TobuyGoodsAttr> goodsList) {
		this.goodsList = goodsList;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
}
