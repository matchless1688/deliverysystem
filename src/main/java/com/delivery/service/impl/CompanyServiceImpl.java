package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.bo.Company;
import com.delivery.dao.CompanyDaoInf;
import com.delivery.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDaoInf companyDaoInf;

	@Override
	public List<Company> queryCompanyList() {
		return (List<Company>) companyDaoInf.findAll();
	}

	@Override
	public Company saveCompany(Company company) {
		return companyDaoInf.save(company);
	}

	@Override
	public void deleteCompany(Company company) {
		companyDaoInf.delete(company);
	}

	@Override
	public Company queryCompany(int id) {
		return companyDaoInf.findOne(id);
	}

}
