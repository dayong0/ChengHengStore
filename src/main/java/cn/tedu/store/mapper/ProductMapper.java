package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Product;

/**
 * 处理商品数据的持久层接口
 */
public interface ProductMapper {
	
	/**
	 * 更新商品的库存
	 * @param id 商品的id
	 * @param num 商品的新的库存
	 * @return 受影响的行数
	 */
	Integer updateNumById(
			@Param("id") Integer id, 
			@Param("num") Integer num);
	
	/**
	 * 根据商品id查询商品详情
	 * @param id 商品id
	 * @return 匹配的商品详情，如果没有匹配的数据，则返回null
	 */
	Product findById(Integer id);

	/**
	 * 获取热销排行的前4个商品
	 * @return 热销排行的前4个商品
	 */
	List<Product> findHostList();
	
}



