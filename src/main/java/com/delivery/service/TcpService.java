package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.Tcp;

public interface TcpService {

	public List<Tcp> queryTcpList();
	
	public Tcp saveTcp(Tcp tcp);
	
	public void deleteTcp(Tcp tcp);
	
	public Tcp queryTcp(int id);
	
	public Page<Tcp> queryTcpListByPage(Pageable page);
	
	public long count();
}
