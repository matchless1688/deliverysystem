package com.delivery.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	public List<Express> queryExpressList(String phone, String barCode) {
		List<Express> result = new ArrayList<Express>();
		if(StringUtils.isEmpty(phone) && StringUtils.isNotEmpty(barCode)) {
			result = expressDaoInf.findByBarCode(barCode);
		}else if(StringUtils.isEmpty(barCode) && StringUtils.isNotEmpty(phone)) {
			result = expressDaoInf.findByOwnerPhone(phone);
		} else {
			result = expressDaoInf.findByOwnerPhoneAndBarCode(phone, barCode);
		}
		return result;
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
	public Express queryExpress(String hid) {
		return expressDaoInf.findOne(hid);
	}

	@Override
	public Page<Express> queryExpressListByPage(Pageable page) {
		return expressDaoInf.findAll(page);
	}

	@Override
	public long count() {
		return expressDaoInf.count();
	}

	@Override
	public Express queryExpressByBarCode(String barCode) {
		Express exp = null;
		List<Express> expressList = expressDaoInf.findByBarCode(barCode);
		if(expressList.size() > 0) {
			exp = expressList.get(0);
		}
		return exp;
	}

}
