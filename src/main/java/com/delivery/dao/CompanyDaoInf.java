package com.delivery.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.Company;

public interface CompanyDaoInf extends PagingAndSortingRepository<Company, Integer>{

}
