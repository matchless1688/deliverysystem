package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.bo.Box;
import com.delivery.dao.BoxDaoInf;
import com.delivery.service.BoxService;

@Service("boxService")
public class BoxServiceImpl implements BoxService{

	@Autowired
	private BoxDaoInf boxDaoInf;
	
	@Override
	public List<Box> queryBoxList() {
		return (List<com.delivery.bo.Box>) boxDaoInf.findAll();
	}

	@Override
	public Box saveBox(Box box) {
		return boxDaoInf.save(box);
	}

	@Override
	public void deleteBox(Box box) {
		boxDaoInf.delete(box);
	}

}