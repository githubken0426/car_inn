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
import org.springframework.web.servlet.ModelAndView;

import inn.shopping.api.entity.Order;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.pay.alipay.util.AlipayNotify;
import inn.shopping.api.service.order.OrderService;

@Controller
@RequestMapping(value="v1/open/pay")
public class PayController {
	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping(value = "/alipay/notify", method = RequestMethod.GET)
	public ModelAndView goodsHot(ModelAndView view,HttpServletRequest request)
			throws ApiException {
		view.setViewName("resources/alipay/notify_url");
		return view;
	}
	/**
     * 支付宝支付订单
     * @return
     * @throws IOException 
     */
    @ResponseBody
    @RequestMapping(value = "pay/aliPayOrder", method = RequestMethod.POST)
    public void aliPayOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {

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
    }


 /** 
  * 从request中获得参数Map，并返回可读的Map 
  *  
  * @param request 
  * @return 
  */  
 @SuppressWarnings("unchecked")  
 public static Map getParameterMap(HttpServletRequest request) {  
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
