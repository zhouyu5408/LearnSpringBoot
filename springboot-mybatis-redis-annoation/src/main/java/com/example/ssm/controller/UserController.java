package com.example.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ssm.domain.User;
import com.example.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/")
	@ResponseBody
	public List<User> getAll() {
		return userService.getAllUser();
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		User user = new User();
		user.setUserId("3");
		user.setUserName("王五");
		user.setUserLoginName("wangwu");
		user.setUserPassword("123456");
		user.setUserEmail("wangwu@qq.com");
		user.setUserPhone("15712345678");
		userService.insert(user);
		return "OK";
	}

	@RequestMapping("/getById")
	@ResponseBody
	public User getById(String userId) {
		return userService.getById(userId);
	}

	@RequestMapping("/remove")
	@ResponseBody
	public String remove(String userId) {
		userService.delete(userId);
		return "delere is success";
	}
}
