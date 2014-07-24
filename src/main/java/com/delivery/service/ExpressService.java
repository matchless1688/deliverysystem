package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.Express;

public interface ExpressService {

	public List<Express> queryExpressList(String phone, String barCode);

	public Express saveExpress(Express express);

	public void deleteExpress(Express express);
	
	public Express queryExpress(String hid);

	public Page<Express> queryExpressListByPage(Pageable page);
	
	public Express queryExpressByBarCode(String barCode);
	
	public long count();
}
