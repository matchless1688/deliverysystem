package com.delivery.service;

import java.util.List;

import com.delivery.bo.Tcp;

public interface TcpService {

	public List<Tcp> queryTcpList();
	
	public Tcp saveTcp(Tcp tcp);
	
	public void deleteTcp(Tcp tcp);
	
	public Tcp queryTcp(int id);
}
