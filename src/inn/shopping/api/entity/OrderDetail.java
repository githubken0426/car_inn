package inn.shopping.api.entity;

public class OrderDetail {
	private String id;
	private String orderId;
	private String goodsId;
	private String goodsTitle;
	private String skuCode;
	private Double goodsPrice;
	private String goodsModeDesc;
	private String goodsModeParams;
	private Integer number;
	private Double subtotal;
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
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
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsModeDesc() {
		return goodsModeDesc;
	}
	public void setGoodsModeDesc(String goodsModeDesc) {
		this.goodsModeDesc = goodsModeDesc;
	}
	public String getGoodsModeParams() {
		return goodsModeParams;
	}
	public void setGoodsModeParams(String goodsModeParams) {
		this.goodsModeParams = goodsModeParams;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
