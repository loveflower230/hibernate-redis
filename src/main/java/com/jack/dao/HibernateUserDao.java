package com.jack.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jack.domain.User;

@Repository
public class HibernateUserDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
	
	public Integer save(User user){
		return  (Integer)getSession().save(user);
	}
	
	public User findOne(Integer id ){
		 User user = (User)getSession().load(User.class, id);
		  return user;
	}

	public List<User> findAll() {
//		
//		Criteria criteria = getSession().createCriteria(User.class);
//		List<User> users = criteria.list();

		
		//note: use class name
		String hql= "select u from User u";
		Query query = getSession().createQuery(hql);
		List users = query.list();
		return users;
	}
	
	public void delete(User user){
		getSession().delete(user);
	}
}
