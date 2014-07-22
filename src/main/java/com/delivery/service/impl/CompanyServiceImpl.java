package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Company queryCompany(String hid) {
		return companyDaoInf.findOne(hid);
	}

	@Override
	public Page<Company> queryCompanyListByPage(Pageable page) {
		return companyDaoInf.findAll(page);
	}

	@Override
	public long count() {
		return companyDaoInf.count();
	}

}
