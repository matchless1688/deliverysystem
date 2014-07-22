package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Agency queryAgency(String hid) {
		return agencyDaoInf.findOne(hid);
	}

	@Override
	public List<Agency> queryAgencyByType(String type) {
		return agencyDaoInf.findByType(type);
	}

	@Override
	public List<Agency> queryAgencyByParent(String parent) {
		return agencyDaoInf.findByParent(parent);
	}

	@Override
	public Page<Agency> queryAgencyListByPage(Pageable page) {
		return agencyDaoInf.findAll(page);
	}

	@Override
	public long count() {
		return agencyDaoInf.count();
	}

}
