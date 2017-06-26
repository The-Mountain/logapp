package com.lenovo.logapp.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenovo.logapp.user.entities.User;

public interface UserService<User, Long> {
	
	User insertUser(User user);
	
	User queryUserById(Long id);
	
	void deleteUserById(Long id);
	
	Iterable<User> queryAllUserByName(String userName);
	
	void updateUserName(Long id, String name);
}
