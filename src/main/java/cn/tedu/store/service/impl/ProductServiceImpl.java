package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.ProductMapper;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.ex.ProductNotFoundException;
import cn.tedu.store.service.ex.ProductOutOfStockException;
import cn.tedu.store.service.ex.UpdateException;

/**
 * 处理商品数据的业务层实现类
 */
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Product getById(Integer id) {
		Product product = findById(id);
		if (product == null) {
			throw new ProductNotFoundException(
				"尝试访问的商品数据不存在");
		}
		
		product.setPriority(null);
		product.setCreatedTime(null);
		product.setCreatedUser(null);
		product.setModifiedTime(null);
		product.setModifiedUser(null);
		
		return product;
	}
	
	@Override
	public List<Product> getHostList() {
		List<Product> products = findHostList();
		for (Product product : products) {
			product.setStatus(null);
			product.setPriority(null);
			product.setCreatedTime(null);
			product.setCreatedUser(null);
			product.setModifiedTime(null);
			product.setModifiedUser(null);
		}
		return products;
	}

	@Override
	public void reduceNum(Integer id, Integer amount) {
		Product result = findById(id);
		if (result == null) {
			throw new ProductNotFoundException(
				"尝试访问的商品数据不存在");
		}
		
		Integer newNum = result.getNum() - amount;
		if (newNum < 0) {
			throw new ProductOutOfStockException(
				"尝试访问的商品库存已不足");
		}
		
		updateNumById(id, newNum);
	}
	
	/**
	 * 更新商品的库存
	 * @param id 商品的id
	 * @param num 商品的新的库存
	 */
	private void updateNumById(Integer id, Integer num) {
		Integer rows = productMapper.updateNumById(id, num);
		if (rows != 1) {
			throw new UpdateException("更新商品库存时出现未知错误，请联系系统管理员");
		}
	}
	
	/**
	 * 根据商品id查询商品详情
	 * @param id 商品id
	 * @return 匹配的商品详情，如果没有匹配的数据，则返回null
	 */
	private Product findById(Integer id) {
		return productMapper.findById(id);
	}
	
	/**
	 * 获取热销排行的前4个商品
	 * @return 热销排行的前4个商品
	 */
	private List<Product> findHostList() {
		return productMapper.findHostList();
	}



}





