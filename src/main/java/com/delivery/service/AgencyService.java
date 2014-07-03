package com.delivery.service;

import java.util.List;

import com.delivery.bo.Agency;

public interface AgencyService {

	public List<Agency> queryAgencyList();
	
	public Agency saveAgency(Agency agency);
	
	public void deleteAgency(Agency agency);
	
	public Agency queryAgency(String id);
}
