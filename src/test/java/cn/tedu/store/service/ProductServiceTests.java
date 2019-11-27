package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

	@Autowired
	private IProductService service;
	
	@Test
	public void getById() {
		Integer id = 10000017;
		Product result = service.getById(id);
		System.err.println(result);
	}
	
	@Test
	public void getHostList() {
		List<Product> list = service.getHostList();
		System.err.println("count=" + list.size());
		for (Product item : list) {
			System.err.println(item);
		}
	}
	
}








