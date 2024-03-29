package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;

/**
 * 处理收货地址数据的业务层接口
 */
public interface IAddressService {

	/**
	 * 增加新的收货地址数据
	 * @param uid 当前登录的用户id
	 * @param username 当前登录的用户名
	 * @param address 新的收货地址数据
	 */
	void addnew(Integer uid, String username, Address address);

	/**
	 * 获取某用户的收货地址列表
	 * @param uid 用户的id
	 * @return 该用户的收货地址列表
	 */
	List<Address> getByUid(Integer uid);
	
	/**
	 * 将用户的某条收货地址数据设置为默认收货地址
	 * @param aid 即将要设置为默认收货地址的数据的id
	 * @param uid 该收货地址归属的用户的id
	 * @param username 进行当前操作的用户的用户名
	 */
	void setDefault(Integer aid, Integer uid, String username);
	
	/**
	 * 删除某条收货地址数据
	 * @param aid 即将要删除的收货地址的数据的id
	 * @param uid 该收货地址归属的用户的id
	 * @param username 进行当前操作的用户的用户名
	 */
	void delete(Integer aid, Integer uid, String username);
	
	/**
	 * 根据收货地址数据id查询收货地址详情
	 * @param aid 收货地址数据id
	 * @param uid 当前登录的用户的id
	 * @return 匹配的收货地址详情，如果没有匹配的数据，则返回null
	 */
	Address getByAid(Integer aid, Integer uid);
	
}








