package inn.shopping.api.controller.pay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Order;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.pay.alipay.AliPayService;
import inn.shopping.api.service.order.OrderService;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/open/pay")
public class PayController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private AliPayService aliPayService;
	
	/**
     * 支付宝支付订单
	 * 订单状态1待付款,2已付款(待发货),3关闭订单(超时未付款),4已发货(待收货),
	 * 5已签收(待评价),6已评价(订单完成),7退货申请,8退货中,9已退货
	 * @return
     * @throws IOException 
	 */
    @ResponseBody
    @RequestMapping(value = "aliPay", method = RequestMethod.POST)
    public JsonView aliPayOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	JsonView view = new JsonView();
    	String orderId=request.getParameter("order_id");
		/*
		 * Map<String,Object> map=new HashMap<String,Object>(); //更新订单状态
		 * map.put("status", "2"); map.put("orderId", order.getId());
		 * orderDao.updateOrderStatus(map);
		 */
		Order order = orderService.selectByPrimaryKey(orderId);
		if(null == order)
			throw new ApiException(APICode.PAYMENT_ORDER_NON_EXISTENT_CODE);
		String result=aliPayService.aliUnifiedOrderRequest(order);
		view.getResult().put("key", result);
		return view;
    }


 /** 
  * 从request中获得参数Map，并返回可读的Map 
  *  
  * @param request 
  * @return 
  */  
 @SuppressWarnings("unchecked")  
 public static Map getParameterMap(HttpServletRequest request) {  
	 /*//从request中获得参数Map，并返回可读的Map 
     Map<String, String> params = RequestUtil.getParameterMap(request);
     //验证支付宝签名
     boolean aliSign = AlipayNotify.verify(params);
     if (aliSign) {//验证成功
         //交易状态
         String tradeStatus = params.get("trade_status");
         //订单编号          
         String orderNo = params.get("out_trade_no");
         //支付单号
         String payNo = params.get("trade_no");
         //支付账号
         String payAccount = params.get("buyer_email");
         //支付金额
         String totalFee = params.get("total_fee");
         //收款支付宝账号
         String sellerId = params.get("seller_id");
         if (Constant.ALIPAY_TRADE_SUCCESS.equals(tradeStatus)) {//支付宝支付状态为成功
             //验证支付宝返回信息与请求信息一致
             if (ProInfoUtil.getInstance().getProperty("alipay_partner").equals(sellerId)) {
                 //订单处理状态
                 String orderHandleStatus = "error";
                 //验证订单未做支付处理
                 Order order = orderService.queryOrderByOrderNo(orderNo);
                 //订单已支付
                 if (Constant.DEALSTATUS_PAY.equals(order.getDealStatus())) {
                     response.getWriter().print("success");
                     return;
                 }
                 if (null != order && Double.parseDouble(totalFee) == order.getDealPrice() && 
                         Constant.DEALSTATUS_NOT_PAY.equals(order.getDealStatus())) {//验证金额是否和订单一致
                     //更新订单为已支付、更新用户套餐余额、添加用户充值记录、添加用户余额支出记录
                     order.setDealStatus(Constant.DEALSTATUS_PAY);
                     order.setPayNo(payNo);
                     order.setPayType(Constant.ALIPAY);
                     order.setPayAccount(payAccount);
                     try {
                         //支付成功处理支付业务
                         boolean result = orderService.payOrder(order);
                         if (result) {
                             //成功后向支付宝返回成功标志
                             orderHandleStatus = "success";
                             response.getWriter().print("success");
                         }
                     } catch (Exception e) {
                         e.printStackTrace();
                         response.getWriter().print("fail");
                     }

                 }
                 //添加支付信息
                 Map<String, Object> map = new HashMap<String, Object>();
                 map.put("params", params.toString());
                 map.put("payType", Constant.ALIPAY);
                 map.put("orderNo", orderNo);
                 map.put("handleStatus", orderHandleStatus);
                 orderService.addPayInfo(map);
             }
         }

     } else {//验证失败
         response.getWriter().print("fail");
     }*/
     // 参数Map  
     Map properties = request.getParameterMap();  
     // 返回值Map  
     Map<String, String> returnMap = new HashMap<String, String>();  
     Iterator entries = properties.entrySet().iterator();  
     Map.Entry entry;  
     String name = "";  
     String value = "";  
     while (entries.hasNext()) {  
         entry = (Map.Entry) entries.next();  
         name = (String) entry.getKey();  
         Object valueObj = entry.getValue();  
         if(null == valueObj){  
             value = "";  
         }else if(valueObj instanceof String[]){  
             String[] values = (String[])valueObj;  
             for(int i=0;i<values.length;i++){  
                 value = values[i] + ",";  
             }  
             value = value.substring(0, value.length()-1);  
         }else{  
             value = valueObj.toString();  
         }  
         returnMap.put(name, value);  
     }  
     return returnMap;  
 }  
}
