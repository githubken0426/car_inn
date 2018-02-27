package inn.shopping.api.form;

public class OrderCancelForm {
	private String orderId ;
	private String cancelType;//取消类别0:未在规定时间内付款，1,用户取消交易
	private String cancelReason;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCancelType() {
		return cancelType;
	}

	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	public String getCancelReason() {
		return cancelReason;
	}


	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
}
