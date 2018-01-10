package inn.shopping.api.controller.cart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Cart;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.CartForm;
import inn.shopping.api.service.cart.CartService;
import inn.shopping.api.utils.Encrypt;
import inn.shopping.api.view.JsonList;
import inn.shopping.api.view.JsonObjectView;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	/**
	 * 获取购物车中商品列表
	 * @throws ApiException 
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<Cart> goodsSortTypeList(HttpServletRequest request) throws ApiException {
		JsonList<Cart> jsonView = new JsonList<Cart>();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		List<Cart> list=cartService.selectGoodsInCart(userId);
		jsonView.setResult(list);
		return jsonView;
	}
	
	/**
	 * 购物车添加商品
	 * @throws ApiException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonView cartGoodsAdd(HttpServletRequest request,@RequestBody CartForm cartForm) throws ApiException{
		Map<String,Object> map = new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		cartService.meger(cartForm,userId);
		
		jsonView.setMessage("添加成功");
		jsonView.setResult(map);
		return jsonView;
	}
	/**
	 * 购物车删除商品
	 * @throws ApiException 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonObjectView cartGoodsDel(HttpServletRequest request) throws ApiException {
		JsonObjectView view = new JsonObjectView();
		String ids = request.getParameter("cart_ids");
		cartService.deleteByPrimaryKeyBatch(Arrays.asList(ids.split(",")));
		view.setMessage("删除成功");
		return view;
	}
	
	/**
	 * 购物车修改商品数量
	 * @throws ApiException 
	 */
	@ResponseBody
	@RequestMapping(value = "/number", method = RequestMethod.POST)
	public JsonObjectView cartGoodsUpdate(HttpServletRequest request,Cart cart) throws ApiException {
		JsonObjectView view = new JsonObjectView();
		String id = request.getParameter("cart_id");
		String number = request.getParameter("number");
		cart.setId(id);
		int num=Integer.valueOf(number);
		cart.setNumber(num);
		cartService.updateGoodsNumber(cart);
		view.setMessage("更改成功");
		view.setResult(null);
		return view;
	}
	
	/**
	 * 购物车去结算
	 * @throws ApiException 
	 */
	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public JsonView cartGoodsOrder(HttpServletRequest request) throws ApiException {
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		String cartIds = request.getParameter("cart_ids");
		/*//获取部分去结算所需信息
		Map<String,Object> map = cartService.cartGoodsOrder(goods_ids, user_id, cart_ids);
		//获取积分数据信息
		BigDecimal bdPrice = null;
		if(map.get("total_price") !=null){
			bdPrice = new BigDecimal(String.valueOf(map.get("total_price"))); 
		}else{
			throw new ApiException(ErrorCode.CART_PARAM_NULL_ERROR);
		}
		Map<String,String> tmp = orderService.getIntegralInfo(bdPrice , user_id); */
		//封装积分数据
		//map.put("integral_info", tmp);
		//封装所有-去结算-所需要的信息
//		jsonView.setResult(map);
		jsonView.setMessage("购物车去结算中");
		return jsonView;
	}
}
