package cn.tedu.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	public DataSource dataSource;
	
	@Test
	public void getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		System.err.println(conn);
	}
	
	public static void main(String[] args) {
		// 原始密码
		String password = "123456";
		// 盐值
		String salt = UUID.randomUUID().toString();
		System.out.println(salt);
		
		for (int i = 0; i < 10; i++) {
			// 执行加密
			password 
				= DigestUtils.md5DigestAsHex(
					(password + salt).getBytes());
			// 输出
			System.out.println(password);
		}
	}

}







