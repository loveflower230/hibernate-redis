//package com.jack.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//import com.jack.domain.User;
//
//@ContextConfiguration({"classpath:applicationContext-hibernate.xml", "classpath:applicationContext-jpa2.xml"})
//public class UserDaoTestHibernate extends AbstractTransactionalJUnit4SpringContextTests {
//	
//	@Autowired
//	private  HibernateUserDao hUserDao;
//	
//	@Before
//	public void init(){
//		
//	}
//
//	@Test
//	public void testFindAll() {
//		System.out.println("user 1 :" + hUserDao.findOne(1).getUserName() );
//		save();
//		// 初始化4条，上面又增一条
////		assert (userDao.findAll().iterator().equals(5));
//		
//		assertEquals(hUserDao.findAll().size(), 5);
//	}
//
//	private void save() {
//		final User entity = new User();
//		entity.setUserName(("username"));
//		entity.setPassword(("password"));
////		User save = userDao.save(entity);
//		
//		 Integer id = hUserDao.save(entity);
//		 System.out.println("ID:" + id);
//
//	}
//}
