package com.lenovo.logapp.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenovo.logapp.user.entities.User;
import com.lenovo.logapp.user.repository.UserRepository;
import com.lenovo.logapp.user.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService<User, Long> {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User queryUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public Iterable<User> queryAllUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByName(name);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	@Override
	public void updateUserName(Long id, String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findOne(id);
		user.setName(name);
		userRepository.save(user);
	}

}
