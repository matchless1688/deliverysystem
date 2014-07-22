package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tcpinfo")
public class Tcp extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5406372825713344278L;

	@Column(name = "serialCode", length = 20)
	private String serialCode;
	
	@Column(name = "tcpDirection", length = 10)
	private String tcpDirection;
	
	@Column(name = "tcpReceive", length = 300)
	private String tcpReceive;
	
	@Column(name = "tcpSend", length = 300)
	private String tcpSend;

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
