package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tcpinfo")
public class Tcp implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 64)
	private int id;
	
	@Column(name = "SerialCode", length = 20)
	private String serialCode;
	
	@Column(name = "TcpDirection", length = 10)
	private String tcpDirection;
	
	@Column(name = "TcpReceive", length = 300)
	private String tcpReceive;
	
	@Column(name = "TcpSend", length = 300)
	private String tcpSend;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialCode() {
		return serialCode;
	}

	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}

	public String getTcpDirection() {
		return tcpDirection;
	}

	public void setTcpDirection(String tcpDirection) {
		this.tcpDirection = tcpDirection;
	}

	public String getTcpReceive() {
		return tcpReceive;
	}

	public void setTcpReceive(String tcpReceive) {
		this.tcpReceive = tcpReceive;
	}

	public String getTcpSend() {
		return tcpSend;
	}

	public void setTcpSend(String tcpSend) {
		this.tcpSend = tcpSend;
	}

}
