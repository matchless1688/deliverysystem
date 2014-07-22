package com.delivery.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.delivery.bo.SmsSend;

public interface SmsSendDaoInf extends PagingAndSortingRepository<SmsSend, String>{

}
