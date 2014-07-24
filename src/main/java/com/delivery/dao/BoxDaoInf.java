package com.delivery.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.Box;

public interface BoxDaoInf extends PagingAndSortingRepository<Box, String>{

	public List<Box> findByStationId(String stationId);
	
	public List<Box> findByStatus(String status);
}
