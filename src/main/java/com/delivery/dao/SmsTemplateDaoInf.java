package com.delivery.dao;

import org.springframework.data.repository.CrudRepository;

import com.delivery.bo.SmsTemplate;

public interface SmsTemplateDaoInf extends CrudRepository<SmsTemplate, String>{

}
