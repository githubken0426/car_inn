package inn.shopping.api.form;

import org.apache.commons.lang.StringUtils;

/**
 * 地址
 * 表单实体类
 * @ClassName: AddressForm 
 * @Description: 
 * @author ken 
 * @date 2017年9月22日 下午4:09:58
 */
public class AddressForm {
	private String province;
	private String city;
	private String district;
	private String address;
	private String postalCode;
	private String name;
	private String phone;
	private String defaultFlag;
	
	public boolean validateParam() {
		if(StringUtils.isBlank(province) && StringUtils.isBlank(city) &&StringUtils.isBlank(district))
			return false;
		if(StringUtils.isBlank(name) && StringUtils.isBlank(phone))
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
	public String getDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
}
