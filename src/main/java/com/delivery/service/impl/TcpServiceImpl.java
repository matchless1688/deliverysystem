package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.bo.Tcp;
import com.delivery.dao.TcpDaoInf;
import com.delivery.service.TcpService;

@Service("tcpService")
public class TcpServiceImpl implements TcpService{

	@Autowired
	private TcpDaoInf tcpDaoInf;
	
	@Override
	public List<Tcp> queryTcpList() {
		return (List<Tcp>) tcpDaoInf.findAll();
	}

	@Override
	public Tcp saveTcp(Tcp tcp) {
		return tcpDaoInf.save(tcp);
	}

	@Override
	public void deleteTcp(Tcp tcp) {
		tcpDaoInf.delete(tcp);
	}

	@Override
	public Tcp queryTcp(int id) {
		return tcpDaoInf.findOne(id);
	}

}
