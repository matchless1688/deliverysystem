package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.bo.Agency;
import com.delivery.dao.AgencyDaoInf;
import com.delivery.service.AgencyService;

@Service("agencyService")
public class AgencyServiceImpl implements AgencyService{
	
	@Autowired
	private AgencyDaoInf agencyDaoInf;

	@Override
	public List<Agency> queryAgencyList() {
		return (List<Agency>) agencyDaoInf.findAll();
	}

	@Override
	public Agency saveAgency(Agency agency) {
		return agencyDaoInf.save(agency);
	}

	@Override
	public void deleteAgency(Agency agency) {
		agencyDaoInf.delete(agency);
	}

	@Override
	public Agency queryAgency(String id) {
		return agencyDaoInf.findOne(id);
	}

}
