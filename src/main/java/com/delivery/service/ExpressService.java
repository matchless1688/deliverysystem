package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.Express;

public interface ExpressService {

	public List<Express> queryExpressList();

	public Express saveExpress(Express express);

	public void deleteExpress(Express express);
	
	public Express queryExpress(int id);

	public Page<Express> queryExpressListByPage(Pageable page);
	
	public long count();
}
