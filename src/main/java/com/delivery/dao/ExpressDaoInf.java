package com.delivery.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.Express;

public interface ExpressDaoInf extends PagingAndSortingRepository<Express, Integer>{

}
