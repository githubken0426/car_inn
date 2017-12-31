package inn.shopping.api.form;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 商品筛选
 * 价格、品牌、属性、规格
 * @author ken
 *
 */
public class GoodsSearchForm {
	private double fromPrice;
	private double toPrice;
	private String cityCode;
	private String brandIds;
	private String specIds;
	
	private List<String> brandList;
	private List<String> specList;
	
	public double getFromPrice() {
		return fromPrice;
	}
	public void setFromPrice(double fromPrice) {
		this.fromPrice = fromPrice;
	}
	public double getToPrice() {
		return toPrice;
	}
	public void setToPrice(double toPrice) {
		this.toPrice = toPrice;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getBrandIds() {
		return brandIds;
	}
	public void setBrandIds(String brandIds) {
		this.brandIds = brandIds == null ? "" : brandIds.trim();
		this.brandList= StringUtils.isNotBlank(brandIds) ? Arrays.asList(brandIds.split(",")):null;
	}
	public String getSpecIds() {
		return specIds;
	}
	public void setSpecIds(String specIds) {
		this.specIds = specIds == null ? "" : specIds.trim();
		this.specList= StringUtils.isNotBlank(specIds) ? Arrays.asList(specIds.split(",")):null;
	}
	public List<String> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<String> brandList) {
		this.brandList = brandList;
	}
	public List<String> getSpecList() {
		return specList;
	}
	public void setSpecList(List<String> specList) {
		this.specList = specList;
	}
}
