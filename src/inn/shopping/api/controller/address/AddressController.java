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
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/open/address")
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
		if(StringUtils.isNotBlank(userId)){
			throw new ApiException(APICode.SYS_PARAM_NULL);
		}
		List<Address> list=addressService.selectAddressByUserId(userId);
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
	public JsonView appAddressAdd(@RequestBody AddressForm form,Address address, HttpServletRequest request)
			throws ApiException {
		if (!(form.validateParam())) {
			throw new ApiException(APICode.SYS_PARAM_NULL);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
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
		jsonView.setResult(resultMap);
		jsonView.setMessage(APICode.SYS_ADD_SUCCESS.getMessage());
		return jsonView;
	}
	
	/**
	 * 修改地址
	 * @param request
	 * @return
	 * @throws ApiException
	 
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public JsonView appAddressUpdate(@RequestBody AddressForm form, HttpServletRequest request)
			throws ApiException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		form.setUserId(userId);
		String addressId=form.getAddressId();
		String name=form.getName();
		String phone=form.getPhone();
		String address=form.getAddress();
		Integer defaultFlag=form.getDefaultFlag();
		if (!(form.checkAddress())) {
			throw new ApiException(ErrorCode.USER_PARAM_NULL_ERROR);
		}
		Address info=new Address();
		info.setAddressId(addressId);
		info.setUserId(userId);
		info.setProvince(form.getProvince());
		info.setCity(form.getCity());
		info.setDistrict(form.getDistrict());
		info.setName(name);
		info.setPhone(phone);
		if(defaultFlag==null)
			defaultFlag=0;
		info.setDefaultFlag(defaultFlag);
		info.setAddress(address);
		info.setPostalCode(form.getPostalCode());
		
		addressService.updateByPrimaryKey(info);
		jsonView.setResult(resultMap);
		jsonView.setMessage("修改成功");
		return jsonView;
	}
	*/
	/**
	 * 删除用户地址
	 * @param request
	 * @return
	 * @throws ApiException
	 
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonList<Address> appAddressDelete(@RequestBody AddressForm form,HttpServletRequest request)
			throws ApiException {
		JsonList<Address> jsonView = new JsonList<Address>();
		String addressId=form.getAddressId();
		if(null==addressId || addressId==""){
			throw new ApiException(ErrorCode.USER_PARAM_NULL_ERROR);
		}
		addressService.deleteByPrimaryKey(addressId);
		jsonView.setMessage("删除成功");
		return jsonView;
	}
	*/
	/**
	 * 主键查询
	 * @param request
	 * @return
	 * @throws ApiException
	 
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public JsonView appAddressGetById(@RequestBody AddressForm form,HttpServletRequest request)
			throws ApiException {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		String addressId=form.getAddressId();
		String orderId = form.getOrderId();
		if(null==addressId || addressId==""){
			throw new ApiException(ErrorCode.USER_PARAM_NULL_ERROR);
		}
		Address info = addressService.getByPrimaryKey(addressId);
		if(info==null){
			throw new ApiException(ErrorCode.USER_OPERATION_ERROR);
		}
		String address =info.getProvince()+info.getCity()+info.getDistrict()+info.getAddress();
		addressService.changeAddressId(addressId, orderId);
		resultMap.put("address", address);
		jsonView.setResult(resultMap);
//		jsonView.setMessage("成功");
		return jsonView;
	}
	*/
	/**
	 * 设置默认收货地址
	 * @param form
	 * @param request
	 * @return
	 * @throws ApiException
	 
	@ResponseBody
	@RequestMapping(value = "/default/set", method = RequestMethod.POST)
	public JsonView appAddressGetDefaultSet(@RequestBody AddressForm form,HttpServletRequest request)
			throws ApiException {
		Map<String,Object> map=new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		String addressId=form.getAddressId();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		if((null==addressId || addressId=="") && (null==userId || userId=="")){
			throw new ApiException(ErrorCode.USER_OPERATION_ERROR);
		}
		map.put("addressId", addressId);
		map.put("userId", userId);
		addressService.defaultAddressSet(map);
		jsonView.setMessage("设置成功");
		return jsonView;
	}
	*/
}
