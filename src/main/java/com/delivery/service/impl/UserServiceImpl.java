package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public User queryUser(String hid) {
		return userDaoInf.findOne(hid);
	}

	@Override
	public User queryUserByUserName(String userName) {
		return userDaoInf.findByUserName(userName);
	}

	@Override
	public User queryUserByTelPhone(String phone) {
		return userDaoInf.findByTelPhone(phone);
	}

	@Override
	public Page<User> queryUserListByPage(Pageable page) {
		return userDaoInf.findAll(page);
	}

	@Override
	public long count() {
		return userDaoInf.count();
	}

}
