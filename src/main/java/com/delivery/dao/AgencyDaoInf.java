package com.delivery.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.Agency;

public interface AgencyDaoInf extends PagingAndSortingRepository<Agency, String>{

	public List<Agency> findByType(String type);
	
	public List<Agency> findByParent(String parent);
}
