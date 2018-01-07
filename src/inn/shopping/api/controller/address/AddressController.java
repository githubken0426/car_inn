package inn.shopping.api.controller.address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Address;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.AddressForm;
import inn.shopping.api.service.AddressService;
import inn.shopping.api.utils.CommonUtil;
import inn.shopping.api.utils.Encrypt;
import inn.shopping.api.view.JsonList;
import inn.shopping.api.view.JsonObjectView;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	/**
	 * 获取用户地址列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<Address> appAddressList(HttpServletRequest request)
			throws ApiException {
		JsonList<Address> jsonView = new JsonList<Address>();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		
		List<Address> list=addressService.selectAddressByUserId(userId,null);
		if(list.size()==0){
			jsonView.setMessage("没有数据");
		}
		jsonView.setResult(list);
		return jsonView;
	}
	
	/**
	 * 添加地址
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonView appAddressAdd(@RequestBody AddressForm form,Address address,HttpServletRequest request)
			throws ApiException {
		if (!(form.validateParam(0))) {
			throw new ApiException(APICode.SYS_PARAM_NULL);
		}
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		
		address.setId(CommonUtil.getUID());
		address.setUserId(userId);
		address.setProvince(form.getProvince());
		address.setCity(form.getCity());
		address.setDistrict(form.getDistrict());
		address.setName(form.getName());
		address.setPhone(form.getPhone());
		address.setDefaultFlag(form.getDefaultFlag());
		address.setAddress(form.getAddress());
		address.setPostalCode(form.getPostalCode());
		
		addressService.insert(address);
		jsonView.setMessage(APICode.SYS_ADD_SUCCESS.getMessage());
		return jsonView;
	}
	
	/**
	 * 修改地址
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public JsonView appAddressUpdate(@RequestBody AddressForm form,Address address,HttpServletRequest request)
			throws ApiException {
		if (!(form.validateParam(1))) {
			throw new ApiException(APICode.SYS_PARAM_NULL);
		}
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		
		address.setId(form.getAddressId());
		address.setUserId(userId);
		address.setProvince(form.getProvince());
		address.setCity(form.getCity());
		address.setDistrict(form.getDistrict());
		address.setName(form.getName());
		address.setPhone(form.getPhone());
		address.setDefaultFlag(form.getDefaultFlag());
		address.setAddress(form.getAddress());
		address.setPostalCode(form.getPostalCode());
		
		addressService.updateByPrimaryKey(address);
		jsonView.setMessage(APICode.SYS_UPDATE_SUCCESS.getMessage());
		return jsonView;
	}
	
	/**
	 * 删除用户地址
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonList<Address> appAddressDelete(HttpServletRequest request)
			throws ApiException {
		JsonList<Address> jsonView = new JsonList<Address>();
		String addressId=request.getParameter("address_id");
		if(StringUtils.isBlank(addressId)){
			throw new ApiException(APICode.SYS_PARAM_NULL);
		}
		addressService.deleteByPrimaryKey(addressId);
		jsonView.setMessage(APICode.SYS_DELETE_SUCCESS.getMessage());
		return jsonView;
	}
	
	/**
	 * 查询默认地址
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/default/get", method = RequestMethod.GET)
	public JsonObjectView appAddressGetById(HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		
		List<Address> list=addressService.selectAddressByUserId(userId,"Y");
		Address address = list.size() > 0 ? list.get(0) : null;
		jsonView.setResult(address);
		return jsonView;
	}
	
	/**
	 * 设置默认收货地址
	 * @param form
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/default/set", method = RequestMethod.POST)
	public JsonView appAddressGetDefaultSet(HttpServletRequest request)
			throws ApiException {
		JsonView jsonView = new JsonView();
		String addressId=request.getParameter("address_id");
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		if(StringUtils.isBlank(addressId)){
			throw new ApiException(APICode.SYS_PARAM_NULL);
		}
		addressService.setAddressDefault(userId,addressId);
		jsonView.setMessage(APICode.SYS_SET_SUCCESS.getMessage());
		return jsonView;
	}
	
}
