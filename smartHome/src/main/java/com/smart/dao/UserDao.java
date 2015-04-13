package com.smart.dao;

import java.util.List;

import javax.servlet.http.HttpSession;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.smart.domain.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	public void saveUser(User user){
		hibernateTemplate.save(user);
	}
	
	public List<User> findUserByUserName(String username){
		String hql="from User where username=?";
		return (List<User>)hibernateTemplate.find(hql, username);
	}
	
	public List<User> findUser(String username,String password){
		String sql="from User where username = ? and password = ?";
		return (List<User>)hibernateTemplate.find(sql,username,password);
	}

	public void addMessageByUserName(User user,String username){
		//User u = (User)session.getAttribute("user2");
		//String name = u.getUsername();
		User u1 = (User)hibernateTemplate
				.getSessionFactory()
				.openSession()
				.get(User.class, username);
		
		String phone = user.getPhone();
		String email = user.getEmail();
		u1.setPhone(phone);
		u1.setEmail(email);
		hibernateTemplate.getSessionFactory().getCurrentSession().update(u1);
	}
}
