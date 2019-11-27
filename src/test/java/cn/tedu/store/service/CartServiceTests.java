package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {

	@Autowired
	private ICartService service;

	@Test
	public void addToCart() {
		try {
			Integer uid = 6;
			String username = "超级管理员";
			Integer pid = 10000022;
			Integer num = 1;
			service.addToCart(uid, username, pid, num);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getVOByUid() {
		Integer uid = 8;
		List<CartVO> list = service.getVOByUid(uid);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void addNum() {
		try {
			Integer cid = 11;
			Integer uid = 8;
			String username = "超级管理员";
			Integer newNum = service.addNum(cid, uid, username);
			System.err.println("OK. newNum=" + newNum);
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getVOByCids() {
		Integer uid = 8;
		Integer[] cids = {6,7,8,9,10,11,12,13,14,15};
		List<CartVO> list = service.getVOByCids(cids, uid);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
}








