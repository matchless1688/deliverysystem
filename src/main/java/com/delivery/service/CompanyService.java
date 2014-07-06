package com.delivery.service;

import java.util.List;

import com.delivery.bo.Company;

public interface CompanyService {

	public List<Company> queryCompanyList();
	
	public Company saveCompany(Company company);
	
	public void deleteCompany(Company company);
	
	public Company queryCompany(int id);
	
}
