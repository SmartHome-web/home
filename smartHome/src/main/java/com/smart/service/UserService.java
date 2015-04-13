package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.UserDao;
import com.smart.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	
	public List<User> matchUser(String username,String password){
		return userDao.findUser(username, password);
	}
	
	public List<User> findUserByUserName(String username){
		return userDao.findUserByUserName(username);
	}
	
	public void addMessageByUserName(User user,String username){
		userDao.addMessageByUserName(user, username);
	}
}
