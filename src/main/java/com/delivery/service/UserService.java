package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.User;

public interface UserService {

	public List<User> queryUserList();
	
	public User saveUser(User user);
	
	public void deleteUser(User user);
	
	public User queryUser(String id);
	
	public User queryUserByUserName(String userName);
	
	public User queryUserByTelPhone(String phone);
	
	public Page<User> queryUserListByPage(Pageable page);
	
	public long count();
}
