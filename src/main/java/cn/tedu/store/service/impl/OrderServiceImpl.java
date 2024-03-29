package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVO;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired 
	private IAddressService addressService;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IProductService productService;
	
	@Override
	@Transactional
	public Order create(Integer aid, Integer[] cids, Integer uid, String username) {
		// 创建当前时间对象
		Date now = new Date();

		// 基于参数aid，调用addressService中的方法得到Address对象
		Address address = addressService.getByAid(aid, uid);

		// 基于参数cids和uid，调用cartService中的方法，得到List<CartVO>
		List<CartVO> carts = cartService.getVOByCids(cids, uid);

		// 声明totalPrice
		Long totalPrice = 0L;
		// 遍历以上List<CartVO>
		for (CartVO cart : carts) {
			// 将totalPrice累加商品的单价乘以数量
			totalPrice += cart.getRealPrice() * cart.getNum();
		}

		// 创建Order对象
		Order order = new Order();
		// 补全数据：uid
		order.setUid(uid);
		// 补全数据：收货人相关的6条数据
		order.setRecvName(address.getName());
		order.setRecvPhone(address.getPhone());
		order.setRecvProvince(address.getProvinceName());
		order.setRecvCity(address.getCityName());
		order.setRecvArea(address.getAreaName());
		order.setRecvAddress(address.getAddress());
		// 补全数据：totalPrice
		order.setTotalPrice(totalPrice);
		// 补全数据：orderTime-当前时间
		order.setOrderTime(now);
		// 补全数据：payTime-null
		order.setPayTime(null);
		// 补全数据：status-0
		order.setStatus(0);
		// 补全数据：4条日志
		order.setCreatedUser(username);
		order.setCreatedTime(now);
		order.setModifiedUser(username);
		order.setModifiedTime(now);
		// 调用insertOrder(Order order)插入订单数据
		insertOrder(order);

		// 遍历以上List<CartVO>
		for (CartVO cart : carts) {
			// 创建OrderItem对象
			OrderItem item = new OrderItem();
			// 补全数据：oid-order.getOid();
			item.setOid(order.getOid());
			// 补全数据：从CartVO对象中取出所需的商品数据
			item.setPid(cart.getPid());
			item.setTitle(cart.getTitle());
			item.setImage(cart.getImage());
			item.setPrice(cart.getRealPrice());
			item.setNum(cart.getNum());
			// 补全数据：4条日志
			item.setCreatedUser(username);
			item.setCreatedTime(now);
			item.setModifiedUser(username);
			item.setModifiedTime(now);
			// 调用insertOrderItem(OrderItem orderItem)插入订单商品数据
			insertOrderItem(item);
			// 减少对应的商品的库存
			productService.reduceNum(cart.getPid(), cart.getNum());
		}

		// 删除购物车中对应的数据
		cartService.delete(cids, uid);
		
		// TODO 开启倒计时15分钟，如果超时未支付，则关闭订单，归还库存
		// TODO 也可以只使用1个线程，定期更新那些未支付且超时的数据状态，例如：update t_order set status=3 where status=0 and order_time < xx

		// 返回order对象
		return order;
	}
	
	/**
	 * 插入订单数据
	 * @param order 订单数据
	 */
	private void insertOrder(Order order) {
		Integer rows = orderMapper.insertOrder(order);
		if (rows != 1) {
			throw new InsertException(
				"插入订单数据时出现未知错误，请联系系统管理员");
		}
	}
	
	/**
	 * 插入订单商品数据
	 * @param order 订单商品数据
	 */
	private void insertOrderItem(OrderItem orderItem) {
		Integer rows = orderMapper.insertOrderItem(orderItem);
		if (rows != 1) {
			throw new InsertException(
				"插入订单商品数据时出现未知错误，请联系系统管理员");
		}
	}

	
}










