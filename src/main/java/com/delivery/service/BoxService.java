package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.Box;

public interface BoxService {

	public List<Box> queryBoxList();

	public Box saveBox(Box box);

	public void deleteBox(Box box);
	
	public Box queryBox(String hid);
	
	public List<Box> queryBoxByStationId(String stationId);
	
	public Page<Box> queryBoxListByPage(Pageable page);
	
	public List<Box> queryBoxListByStatus(String status);
	
	public long count();
}
