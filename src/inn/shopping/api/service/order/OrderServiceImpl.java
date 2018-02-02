package inn.shopping.api.service.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.AddressMapper;
import inn.shopping.api.dao.GoodsMapper;
import inn.shopping.api.dao.OrderDetailMapper;
import inn.shopping.api.dao.OrderMapper;
import inn.shopping.api.dao.SpecItemMapper;
import inn.shopping.api.entity.Address;
import inn.shopping.api.entity.Goods;
import inn.shopping.api.entity.Order;
import inn.shopping.api.entity.OrderDetail;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.OrderForm;
import inn.shopping.api.form.OrderGoodsAttribute;
import inn.shopping.api.form.TobuyForm;
import inn.shopping.api.form.TobuyFormList;
import inn.shopping.api.form.TobuyGoodsAttr;
import inn.shopping.api.form.TobuyResult;
import inn.shopping.api.utils.CommonUtil;
@Transactional
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderDao;
	@Autowired
	private OrderDetailMapper orderDetailDao;
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private AddressMapper addressDao;
	@Autowired
	private SpecItemMapper specItemDao;

	@Override
	public String orderSettlement(OrderForm form, String userId) {
		try {
			List<OrderDetail> detailList = new ArrayList<OrderDetail>();
			List<OrderGoodsAttribute> goodsAttrs = form.getGoodsAttrList();
			String orderId=CommonUtil.getUID();
			String orderNo=CommonUtil.generatorOrderNo(4, userId, "G");
			for (OrderGoodsAttribute attr : goodsAttrs) {
				String goodsId=attr.getGoodsId();
				Goods goods = goodsDao.selectByPrimaryKey(goodsId);
				if (null == goods)  // 判断商品是否 被下架或被人为删除
					continue;
				String number=attr.getNumber();
				String specItemsIds=attr.getSpecItemIds();
				int goodsNumber=1;
				if(StringUtils.isNotBlank(number))
					goodsNumber=Integer.valueOf(number);
				OrderDetail detail = OrderDetail.class.newInstance();
				detail.setId(CommonUtil.getUID());
				detail.setOrderId(orderId);
				detail.setOrderNo(orderNo);
				detail.setGoodsId(goodsId);
				detail.setNumber(goodsNumber);
				BigDecimal price = goods.getPromotionPrice();
				detail.setGoodsPrice(price);
				BigDecimal goodsNum = new BigDecimal(number);
				detail.setSubtotal(price.multiply(goodsNum));
				detail.setSpecItemIds(specItemsIds);
				detailList.add(detail);
			}
			if (detailList.size() > 0) {
				String addressId = form.getAddressId();
				String totalPrice = form.getTotalPrice();
				String itemCount=form.getItemCount();
				String mark = form.getCustomerMark();
				String invoice=form.getInvoice();
				String invoiceType=form.getInvoiceType();//发票类型,E电子发票,P纸质发票
				if("Y".equals(invoice) && "".equals(invoiceType))
					invoiceType="E";
				String invoiceTitle=form.getInvoiceTitle();
				String invoiceContent=form.getInvoiceContent();
				
				Order order = Order.class.newInstance();
				order.setId(orderId);
				order.setOrderNo(orderNo);
				order.setUserId(userId);
				order.setExpertId(form.getExpertId());
				order.setAddressId(addressId);
				order.setItemCount(Integer.valueOf(itemCount));
				order.setTotalAmount(new BigDecimal(totalPrice));
				order.setOrderStatus(1);//待付款
				order.setPayment(new BigDecimal(totalPrice));
				order.setCustomerMark(mark);
				order.setInvoice(invoice);
				order.setInvoiceType(invoiceType);
				order.setInvoiceTitle(invoiceTitle);
				order.setInvoiceContent(invoiceContent);
				
				int orderResult = orderDao.insert(order);
				int detailResult = orderDetailDao.insertBatch(detailList);
				if (orderResult > 0 && detailResult > 0)
					return orderId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> selectUserOrders(String userId, String status) {
		return orderDao.selectUserOrders(userId, status);
	}

	@Override
	public Order selectByPrimaryKey(String orderId) {
		return orderDao.selectByPrimaryKey(orderId);
	}

	@Override
	public TobuyResult selectTobuyResult(TobuyFormList form,String userId) throws ApiException {
		TobuyResult result=new TobuyResult();
		List<TobuyGoodsAttr> goodsList=new ArrayList<TobuyGoodsAttr>();
		List<Address> addressList= addressDao.selectAddressByUserId(userId,"Y");
		if(addressList.size()==0)
			throw new ApiException(APICode.ORDER_ADDRESS_NULL_ERROR);
		Address address=addressList.get(0);
		result.setAddresId(address.getId());
		result.setName(address.getName());
		result.setPhone(address.getPhone());
		String detail=address.getProvince()+address.getCity()+address.getAddress();
		result.setAddress(detail);
		
		BigDecimal totalPrice=new BigDecimal(0);
		for (TobuyForm attr : form.getGoodsList()) {
			TobuyGoodsAttr goodsAttr=new TobuyGoodsAttr();
			String goodsId=attr.getGoodsId();
			Goods goods=goodsDao.selectByPrimaryKey(goodsId);
			if(goods==null)
				throw new ApiException(APICode.ORDER_GOODS_NULL_ERROR);
			String number=attr.getNumber();
			String specItemIds=attr.getSpecItemIds();
			goodsAttr.setGoodsId(goodsId);
			goodsAttr.setNumber(number);
			goodsAttr.setSpecItemIds(specItemIds);
			if (StringUtils.isNotBlank(specItemIds)) {
				List<String> itemList = Arrays.asList(specItemIds.split(","));
				List<String> itemResult = specItemDao.selectConcatSpecItems(itemList);
				String resultStr=toStr(itemResult);
				goodsAttr.setSpecItemName(resultStr);
			}
			goodsAttr.setGoodsTitle(goods.getGoodsTitle());
			goodsAttr.setPrimePrice(goods.getPrimePrice());
			BigDecimal goodsPrice = goods.getPromotionPrice();
			goodsAttr.setPromotionPrice(goodsPrice);
			goodsAttr.setPicture(goods.getSmallPictureList().get(0));
			int num = StringUtils.isBlank(number) ? 1 : Integer.valueOf(number);
			BigDecimal goodsNum = new BigDecimal(num);
			totalPrice = totalPrice.add(goodsPrice.multiply(goodsNum));
			goodsList.add(goodsAttr);
		}
		result.setTotalPrice(totalPrice);
		result.setGoodsList(goodsList);
		return result;
	}

	public <E> String toStr(List<E> list) {
		Iterator<E> i = list.iterator();
		if (!i.hasNext())
			return "";
		StringBuilder sb = new StringBuilder();
		for (;;) {
			E e = i.next();
			sb.append(e);
			if (!i.hasNext())
				return sb.toString();
			sb.append(",");
		}
	}
	/*@Override
	public String buyGoodsNow(OrderForm form, String userId) {
		try {
			Order order = Order.class.newInstance();
			String goodsId = form.getGoodsIds();
			Goods goods = goodsDao.selectByPrimaryKey(goodsId);
			if (null == goods)  // 判断商品是否 被下架或被人为删除
				return null;
			String number = form.getNumber();
			int goodsNumber = 1;
			if (StringUtils.isNotBlank(number))
				goodsNumber = Integer.valueOf(number);
			String addressId = form.getAddressId();
			String mark = form.getCustomerMark();
			String totalPrice = form.getTotalPrice();
			String specItemsIds = form.getSpecItemIds();
			String orderId = CommonUtil.getUID();
			String orderNo = CommonUtil.generatorOrderNo(4, userId, "G");
			
			order.setId(orderId);
			order.setOrderNo(orderNo);
			order.setUserId(userId);
			order.setAddressId(addressId);
			order.setCustomerMark(mark);
			order.setItemCount(1);
			order.setTotalAmount(new BigDecimal(totalPrice));
			order.setOrderStatus(1);// 待付款
			order.setPayment(new BigDecimal(totalPrice));

			OrderDetail detail = OrderDetail.class.newInstance();
			detail.setId(CommonUtil.getUID());
			detail.setOrderId(orderId);
			detail.setOrderNo(orderNo);
			detail.setGoodsId(goodsId);
			detail.setNumber(goodsNumber);
			BigDecimal price = goods.getPromotionPrice();
			detail.setGoodsPrice(price);
			BigDecimal goodsNum = new BigDecimal(goodsNumber);
			detail.setSubtotal(price.multiply(goodsNum));
			detail.setSpecItemIds(specItemsIds);
			
			int orderResult = orderDao.insert(order);
			int detailResult = orderDetailDao.insert(detail);
			if (orderResult > 0 && detailResult > 0) {
				return orderId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public Order selectByOrderNo(String orderNo) {
		return orderDao.selectByOrderNo(orderNo);
	}
}
