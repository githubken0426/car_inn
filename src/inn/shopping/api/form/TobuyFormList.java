package inn.shopping.api.form;

import java.util.List;

public class TobuyFormList {
	private String flag;
	private String shopId;
	List<TobuyForm> goodsList;

	public List<TobuyForm> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<TobuyForm> goodsList) {
		this.goodsList = goodsList;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
