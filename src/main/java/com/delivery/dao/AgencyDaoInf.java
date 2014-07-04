package com.delivery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.delivery.bo.Agency;

public interface AgencyDaoInf extends CrudRepository<Agency, String>{

	public List<Agency> findByType(String type);
	
	public List<Agency> findByParent(String parent);
}
