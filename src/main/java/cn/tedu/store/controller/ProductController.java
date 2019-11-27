package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Product;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.util.JsonResult;

/**
 * 处理商品相关请求的控制器类
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("hot")
	public JsonResult<List<Product>> getHotList() {
		List<Product> data = productService.getHostList();
		return new JsonResult<>(OK, data);
	}
	
	@GetMapping("{id}/details")
	public JsonResult<Product> getById(@PathVariable("id") Integer id) {
		Product data = productService.getById(id);
		return new JsonResult<>(OK, data);
	}

}







