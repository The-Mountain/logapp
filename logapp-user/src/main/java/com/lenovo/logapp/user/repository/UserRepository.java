package com.lenovo.logapp.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.lenovo.logapp.user.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	Iterable<User> findByName(String userName);
}
