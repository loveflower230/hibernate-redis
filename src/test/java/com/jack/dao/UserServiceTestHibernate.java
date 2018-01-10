package com.jack.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.jack.domain.User;
import com.jack.service.UserService;

@ContextConfiguration({ "classpath:applicationContext-hibernate.xml", "classpath:application-3.xml" })
public class UserServiceTestHibernate extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void find() {
		System.out.println(userService.getClass().getAnnotatedInterfaces());
		User user = new User();
		user.setId(6);
		user.setUserName("jessica");
		user.setPassword("123");
		user.setStatus(1);
		user.setTeamId(1);
		User saveUser = userService.save1(user);
		assertEquals(saveUser.getUserName(), user.getUserName());
		
		System.out.println("======-====开启缓存后，下面将不执行sql=============");
		User user1 = userService.findById1(6);
		System.out.println(user1.getUserName());
		
		
//		User user1 = userService.findById(2);
//		System.out.println(user1.getUserName());
//		System.out.println("======-====开启缓存后，下面将不执行sql=============");
//		user1 = userService.findById(2);
//		System.out.println(user1.getUserName());
		
		
		
	}
}
