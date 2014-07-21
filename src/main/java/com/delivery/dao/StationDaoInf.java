package com.delivery.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.Station;

public interface StationDaoInf extends PagingAndSortingRepository<Station, Integer>{

}
