package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.bo.User;
import com.delivery.dao.UserDaoInf;
import com.delivery.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoInf userDaoInf;
	
	@Override
	public List<User> queryUserList() {
		return (List<User>) userDaoInf.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userDaoInf.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userDaoInf.delete(user);;
	}
	
	@Override
	public User queryUser(String id) {
		return userDaoInf.findOne(id);
	}

}
