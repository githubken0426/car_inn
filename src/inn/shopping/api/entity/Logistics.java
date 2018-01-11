package inn.shopping.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Logistics {
	private String id;
	private String orderId;
	private String realname;
	private String telphone;
	private String address;
	private String postalCode;
	private String logisticsNo;
	private Integer logisticsType;
	private BigDecimal logisticsFee;
	private BigDecimal deliveryAmount;
	private Integer logisticsStatus;
	private Integer settlementStatus;
	private String logisticsResult;
	private Date createTime;
	private Date updateTime;
	
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
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getLogisticsNo() {
		return logisticsNo;
	}
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	public Integer getLogisticsType() {
		return logisticsType;
	}
	public void setLogisticsType(Integer logisticsType) {
		this.logisticsType = logisticsType;
	}
	public BigDecimal getLogisticsFee() {
		return logisticsFee;
	}
	public void setLogisticsFee(BigDecimal logisticsFee) {
		this.logisticsFee = logisticsFee;
	}
	public BigDecimal getDeliveryAmount() {
		return deliveryAmount;
	}
	public void setDeliveryAmount(BigDecimal deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}
	public Integer getLogisticsStatus() {
		return logisticsStatus;
	}
	public void setLogisticsStatus(Integer logisticsStatus) {
		this.logisticsStatus = logisticsStatus;
	}
	public Integer getSettlementStatus() {
		return settlementStatus;
	}
	public void setSettlementStatus(Integer settlementStatus) {
		this.settlementStatus = settlementStatus;
	}
	public String getLogisticsResult() {
		return logisticsResult;
	}
	public void setLogisticsResult(String logisticsResult) {
		this.logisticsResult = logisticsResult;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
