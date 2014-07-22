package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.SmsSend;

public interface SmsSendService {

	public List<SmsSend> querySmsSendList();
	
	public SmsSend saveSmsSend(SmsSend smsSend);
	
	public void deleteSmsSend(SmsSend smsSend);
	
	public SmsSend querySmsSend(String hid);
	
	public Page<SmsSend> querySmsSendListByPage(Pageable page);
	
	public long count();
}
