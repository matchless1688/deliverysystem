package com.delivery.service;

import java.util.List;

import com.delivery.bo.User;

public interface UserService {

	public List<User> queryUserList();
	
	public User saveUser(User user);
	
	public void deleteUser(User user);
	
	public User queryUser(String id);
}
