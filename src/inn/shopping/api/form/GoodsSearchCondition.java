package inn.shopping.api.form;

import java.util.List;

import inn.shopping.api.entity.GoodsBrand;
import inn.shopping.api.entity.Spec;

public class GoodsSearchCondition {
	private List<Spec> specList;
	private List<Spec> priceList;
	private List<GoodsBrand> brandList;
	public List<Spec> getSpecList() {
		return specList;
	}
	public void setSpecList(List<Spec> specList) {
		this.specList = specList;
	}
	public List<Spec> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<Spec> priceList) {
		this.priceList = priceList;
	}
	public List<GoodsBrand> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<GoodsBrand> brandList) {
		this.brandList = brandList;
	}
}
