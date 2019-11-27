package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

	@Autowired
	private UserMapper mapper;
	
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("root");
		user.setPassword("1234");
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updatePasswordByUid() {
		Integer uid = 10;
		String password = "8888";
		String modifiedUser = "超级管理员";
		Date modifiedTime = new Date();
		Integer rows = mapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateAvatarByUid() {
		Integer uid = 8;
		String avatar = "8888";
		String modifiedUser = "超级管理员";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateInfoByUid() {
		User user = new User();
		user.setUid(8);
		user.setPhone("13800138008");
		user.setEmail("root@tedu.cn");
		user.setGender(0);
		user.setModifiedUser("管理员");
		user.setModifiedTime(new Date());
		Integer rows = mapper.updateInfoByUid(user);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 8;
		User user = mapper.findByUid(uid);
		System.err.println(user);
	}
	
	@Test
	public void findByUsername() {
		String username = "salt";
		User user = mapper.findByUsername(username);
		System.err.println(user);
	}
	
}







