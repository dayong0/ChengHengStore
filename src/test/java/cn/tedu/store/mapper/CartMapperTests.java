package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {

	@Autowired
	private CartMapper mapper;
	
	@Test
	public void addnew() {
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setPid(2);
		cart.setNum(3);
		cart.setPrice(4L);
		Integer rows = mapper.addnew(cart);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void deleteByCids() {
		Integer[] cids = {12,13,14,15,16};
		Integer rows = mapper.deleteByCids(cids);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateNumByCid() {
		Integer cid = 1;
		Integer num = 10;
		String modifiedUser = "管理员";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByCid() {
		Integer cid = 6;
		Cart result = mapper.findByCid(cid);
		System.err.println(result);
	}
	
	@Test
	public void findByUidAndPid() {
		Integer uid = 1;
		Integer pid = 2;
		Cart result = mapper.findByUidAndPid(uid, pid);
		System.err.println(result);
	}
	
	@Test
	public void findVOByUid() {
		Integer uid = 8;
		List<CartVO> list = mapper.findVOByUid(uid);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void findVOByCids() {
		Integer[] cids = {6,8,11,10};
		List<CartVO> list = mapper.findVOByCids(cids);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
}







