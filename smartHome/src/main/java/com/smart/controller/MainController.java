package com.smart.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.domain.User;
import com.smart.service.UserService;
import com.smart.socket.Server;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private UserService userService;
	String username;
	User user2 = new User();
	@RequestMapping("/toMain")
	public String toMain(){
		return "mainPage";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/toUserPage")
	public String toUserPage(){
		return "userPage";
	}
	
	@RequestMapping("/toAddPersonalInformation")
	public String toAddPersonalInformation(){
		return "addPersonalInformationPage";	
	}
	
	@RequestMapping("/toRegisterPage")
	public String toRegisterPage(){
		return "registerPage";
	}
//	
	@RequestMapping("/openThread")
	public String openThread(){
		new Server().startServer();
		return "userPage";
	}
	
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(User user){
		if(userService.findUserByUserName(user.getUsername()).size()!=0){
			return new ModelAndView("registerPage","error","此用户名以存在");
		}else{
			userService.saveUser(user);
			return new ModelAndView("success","success","注册成功");
		}
		
	}
	
	@RequestMapping(value="loginCheck")
	public  ModelAndView loginCheck(User user,HttpSession session){
		List<User> answer=userService.matchUser(user.getUsername(),user.getPassword());
		//System.out.println(answer.size());
		if(answer.size()!=0){
			user2 = answer.get(0);
			System.out.println(user2.getUsername());
			System.out.println(user2.getPassword());
			//username = user2.getUsername();
			//new Server().startServer();
			session.setAttribute("user", user2);
			return new ModelAndView("userPage","user2",user2);
		}else{
				return new ModelAndView("login","error","用户名或密码错误！");
		}
	}
	@RequestMapping("/addPersonalInformation")
	public ModelAndView addPersonalInformation(User user,HttpSession session){
		User u = (User)session.getAttribute("user");
		String username = u.getUsername();
		System.out.println(username);
		userService.addMessageByUserName(user, username);
		return new ModelAndView("success","success","添加成功");
		
	}
	

		
	
	
}
