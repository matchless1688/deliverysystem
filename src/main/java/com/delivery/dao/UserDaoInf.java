package com.delivery.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.User;

public interface UserDaoInf extends PagingAndSortingRepository<User, String>{

	public User findByUserName(String userName);
	
	public User findByTelPhone(String phone);
}
