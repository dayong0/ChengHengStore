package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {

	@Autowired
	private AddressMapper mapper;
	
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(1);
		address.setName("Tom");
		Integer rows = mapper.insert(address);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void deleteByAid() {
		Integer aid = 25;
		Integer rows = mapper.deleteByAid(aid);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateDefaultByAid() {
		Integer aid = 25;
		String modifiedUser = "王二麻子";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateDefaultByAid(aid, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateNonDefaultByUid() {
		Integer uid = 8;
		Integer rows = mapper.updateNonDefaultByUid(uid);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void countByUid() {
		Integer uid = 1;
		Integer count = mapper.countByUid(uid);
		System.err.println("count=" + count);
	}
	
	@Test
	public void findByAid() {
		Integer aid = 25;
		Address address = mapper.findByAid(aid);
		System.err.println(address);
	}
	
	@Test
	public void findLastModifiedByUid() {
		Integer uid = 8;
		Address address = mapper.findLastModifiedByUid(uid);
		System.err.println(address);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 8;
		List<Address> list = mapper.findByUid(uid);
		System.err.println("count=" + list.size());
		for (Address address : list) {
			System.err.println(address);
		}
	}
	
}







