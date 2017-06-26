package com.lenovo.logapp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.logapp.user.entities.User;
import com.lenovo.logapp.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	UserService<User, Long> userService;
	
	@RequestMapping(value = "createUser/{name}/{mail}/{address}")
	public User createUser(@PathVariable String name, @PathVariable String mail, @PathVariable String address){
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setMail(mail);
		return userService.insertUser(user);
	}
	
	@RequestMapping(value = "queryById/{id}")
	@ResponseBody
	public User queryById(@PathVariable Long id){
		return userService.queryUserById(id);
	}
	@RequestMapping(value = "queryByName/{name}")
	//@ResponseBody
	public Iterable<User> queryByName(@PathVariable String name){
		return userService.queryAllUserByName(name);
	}
	
	@RequestMapping(value ="deleteById/{id}")
	public void deleteById(@PathVariable Long id){
		userService.deleteUserById(id);
	}
	
	@RequestMapping(value ="updateUserName/{id}/{name}")
	public void updateUserName(@PathVariable Long id, @PathVariable String name){
		userService.updateUserName(id, name);
	}
}
