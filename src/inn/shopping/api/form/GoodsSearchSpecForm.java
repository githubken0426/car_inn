package inn.shopping.api.form;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 商品筛选
 * 品牌、规格
 * @author ken
 *
 */
public class GoodsSearchSpecForm {
	private String cityCode;
	private String brandId;
	private String itemIds;
	private List<String> itemList;
	
	public String getItemIds() {
		return itemIds;
	}
	public void setItemIds(String itemIds) {
		this.itemList= StringUtils.isNotBlank(itemIds) ? Arrays.asList(itemIds.split(",")):null;
		this.itemIds = itemIds;
	}
	public List<String> getItemList() {
		return itemList;
		
	}
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
}
