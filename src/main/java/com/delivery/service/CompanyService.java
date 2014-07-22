package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.Company;

public interface CompanyService {

	public List<Company> queryCompanyList();
	
	public Company saveCompany(Company company);
	
	public void deleteCompany(Company company);
	
	public Company queryCompany(String hid);
	
	public Page<Company> queryCompanyListByPage(Pageable page);
	
	public long count();
}
