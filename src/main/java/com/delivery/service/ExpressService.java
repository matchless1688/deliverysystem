package com.delivery.service;

import java.util.List;

import com.delivery.bo.Express;

public interface ExpressService {

	public List<Express> queryExpressList();

	public Express saveExpress(Express express);

	public void deleteExpress(Express express);
}
