package inn.shopping.api.form;

import org.apache.commons.lang.StringUtils;

/**
 * 店铺 表单实体类
 * 
 * @ClassName: ShopForm
 * @Description:
 * @author ken
 * @date 2017年9月22日 下午4:09:58
 */
public class ShopForm {
	private String province;
	private String city;
	private String district;
	private String categoryId;
	private String cityCode;

	public boolean validateParam() {
		if (StringUtils.isBlank(categoryId) || StringUtils.isBlank(cityCode))
			return false;
		return true;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
