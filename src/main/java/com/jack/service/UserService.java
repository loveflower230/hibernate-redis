package com.jack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jack.dao.HibernateUserDao;
import com.jack.dao.jpa.UserDao;
import com.jack.domain.User;

@Service
@Transactional
@CacheConfig(cacheNames={"userCache"},cacheManager="redisCacheManager")
public class UserService {
//	@Autowired
//	private UserDao userDao;
	
	
	@Autowired
	private HibernateUserDao hibernateUserDao;
	
	
	/*
	 * for jpa opreation
	 * 
	 */
//	@Cacheable(key="'User_' + #user.id")
//	public User save(User user){
//		System.out.println("save to database");
//		User user1 = userDao.save(user);
//		return user1;
//	}
//	
//	@Cacheable(key="'User_' + #id")
//	public User findById(Integer id){
//		System.out.println("query database");
//		return userDao.findOne(id);
//	}
//	
//	@CacheEvict(key="'User_' + #id")
//	public void delete(Integer id){
//		userDao.delete(id);
//	}
	
	/*
	 * for hibernate operantion
	 */
	
	@Cacheable(key="'User_' + #user.id")
	public User save1(User user){
		System.out.println("save to database");
		 hibernateUserDao.save(user);
		return user;
	}
	
	@Cacheable(key="'User_' + #id")
	public User findById1(Integer id){
		System.out.println("query database");
		return hibernateUserDao.findOne(id);
	}
	
	@CacheEvict(key="'User_' + #user.idid")
	public void delete1(User user){
		hibernateUserDao.delete(user);
	}

}
