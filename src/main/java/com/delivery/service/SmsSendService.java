package com.delivery.service;

import java.util.List;

import com.delivery.bo.SmsSend;

public interface SmsSendService {

	public List<SmsSend> querySmsSendList();
	
	public SmsSend saveSmsSend(SmsSend smsSend);
	
	public void deleteSmsSend(SmsSend smsSend);
	
	public SmsSend querySmsSend(int id);
	
}
