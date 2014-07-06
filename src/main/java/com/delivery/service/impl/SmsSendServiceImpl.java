package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.bo.SmsSend;
import com.delivery.dao.SmsSendDaoInf;
import com.delivery.service.SmsSendService;

@Service("smsSendService")
public class SmsSendServiceImpl implements SmsSendService{
	
	@Autowired
	private SmsSendDaoInf smsSendDaoInf;

	@Override
	public List<SmsSend> querySmsSendList() {
		return (List<SmsSend>) smsSendDaoInf.findAll();
	}

	@Override
	public SmsSend saveSmsSend(SmsSend smsSend) {
		return smsSendDaoInf.save(smsSend);
	}

	@Override
	public void deleteSmsSend(SmsSend smsSend) {
		smsSendDaoInf.delete(smsSend);
	}

	@Override
	public SmsSend querySmsSend(int id) {
		return smsSendDaoInf.findOne(id);
	}

}
