package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.delivery.bo.Express;
import com.delivery.dao.ExpressDaoInf;
import com.delivery.service.ExpressService;

@Service("expressService")
public class ExpressServiceImpl implements ExpressService {

	@Autowired
	private ExpressDaoInf expressDaoInf;
	
	@Override
	public List<Express> queryExpressList() {
		return (List<Express>) expressDaoInf.findAll();
	}

	@Override
	public Express saveExpress(Express express) {
		return expressDaoInf.save(express);
	}

	@Override
	public void deleteExpress(Express express) {
		expressDaoInf.delete(express);
	}

	@Override
	public Express queryExpress(int id) {
		return expressDaoInf.findOne(id);
	}

	@Override
	public Page<Express> queryExpressListByPage(Pageable page) {
		return expressDaoInf.findAll(page);
	}

	@Override
	public long count() {
		return expressDaoInf.count();
	}

}
