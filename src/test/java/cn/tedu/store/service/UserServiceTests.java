package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private IUserService service;

	@Test
	public void reg() {
		try {
			User user = new User();
			user.setUsername("mybatis");
			user.setPassword("1234");
			user.setGender(1);
			user.setPhone("电话号码");
			user.setEmail("邮箱");
			user.setAvatar("头像");
			service.reg(user);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void login() {
		try {
			String username = "service";
			String password = "123456";
			User user = service.login(username, password);
			System.err.println(user);
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getClass().getName());
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changePassword() {
		try {
			Integer uid = 8;
			String username = "系统管理员";
			String oldPassword = "8888";
			String newPassword = "1234";
			service.changePassword(uid, username, oldPassword, newPassword);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeAvatar() {
		try {
			Integer uid = 8;
			String username = "系统管理员";
			String avatar = "111111";
			service.changeAvatar(uid, username, avatar);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeInfo() {
		try {
			Integer uid = 8;
			String username = "系统管理员";
			User user = new User();
			user.setPhone("010-88888888");
			user.setEmail("8888@qq.com");
			user.setGender(1);
			service.changeInfo(uid, username, user);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	
	@Test
	public void getByUid() {
		try {
			Integer uid = 8;
			User user = service.getByUid(uid);
			System.err.println(user);
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	

}








