package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.Agency;

public interface AgencyService {

	public List<Agency> queryAgencyList();
	
	public Agency saveAgency(Agency agency);
	
	public void deleteAgency(Agency agency);
	
	public Agency queryAgency(String id);
	
	public List<Agency> queryAgencyByType(String type);
	
	public List<Agency> queryAgencyByParent(String parent);
	
	public Page<Agency> queryAgencyListByPage(Pageable page);
	
	public long count();
}
