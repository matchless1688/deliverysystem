package com.delivery.dao;

import org.springframework.data.repository.CrudRepository;

import com.delivery.bo.User;

public interface UserDaoInf extends CrudRepository<User, String>{

	public User findByUserName(String userName);
	
	public User findByTelPhone(String phone);
}
