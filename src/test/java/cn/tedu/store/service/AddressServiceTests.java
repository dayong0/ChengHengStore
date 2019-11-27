package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {

	@Autowired
	private IAddressService service;

	@Test
	public void addnew() {
		try {
			Integer uid = 1;
			String username = "HAHAHA";
			Address address = new Address();
			address.setName("小刘同学");
			service.addnew(uid, username, address);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		Integer uid = 8;
		List<Address> list = service.getByUid(uid);
		System.err.println("count=" + list.size());
		for (Address address : list) {
			System.err.println(address);
		}
	}

	@Test
	public void setDefault() {
		try {
			Integer aid = 1900;
			Integer uid = 8;
			String username = "HAHAHA";
			service.setDefault(aid, uid, username);
			System.err.println("OK.");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void delete() {
		try {
			Integer aid = 19;
			Integer uid = 8;
			String username = "HAHAHA";
			service.delete(aid, uid, username);
			System.err.println("OK.");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
}








