package com.delivery.service;

import java.util.List;

import com.delivery.bo.Box;

public interface BoxService {

	public List<Box> queryBoxList();

	public Box saveBox(Box box);

	public void deleteBox(Box box);
}