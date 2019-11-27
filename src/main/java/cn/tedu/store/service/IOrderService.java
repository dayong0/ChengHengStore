package cn.tedu.store.service;

import cn.tedu.store.entity.Order;

/**
 * 处理订单与订单商品数据的业务层接口
 */
public interface IOrderService {

	/**
	 * 创建订单
	 * @param aid 收货地址数据id
	 * @param cids 即将购买的商品在购物车中的id
	 * @param uid 当前登录的用户的id
	 * @param username 当前登录的用户名
	 * @return 成功创建的订单
	 */
	Order create(Integer aid, Integer[] cids, Integer uid, String username);
	
}
