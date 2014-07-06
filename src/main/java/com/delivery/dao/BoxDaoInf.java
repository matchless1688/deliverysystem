package com.delivery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.delivery.bo.Box;

public interface BoxDaoInf extends CrudRepository<Box, Integer>{

	public List<Box> findByStationId(String stationId);
}
