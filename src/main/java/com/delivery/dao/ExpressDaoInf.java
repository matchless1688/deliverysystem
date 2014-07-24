package com.delivery.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.Express;

public interface ExpressDaoInf extends PagingAndSortingRepository<Express, String>{

	public List<Express> findByOwnerPhoneAndBarCode(String phone, String barCode);
	
	public List<Express> findByOwnerPhone(String phone);
	
	public List<Express> findByBarCode(String barCode);
}
