package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_smssent")
public class SmsSend extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -785493941841352834L;

	@Column(name = "sn", length = 20)
	private String sn;
	
	@Column(name = "dateTime", length = 30)
	private String dateTime;
	
	@Column(name = "Type", length = 2)
	private int type;
	
	@Column(name = "telPhone", length = 11)
	private String telPhone;
	
	@Column(name = "context", length = 200)
	private String context;
	
	@Column(name = "status", length = 50)
	private String status;
	
	@Column(name = "deliveryConfirmation", length = 2)
	private String deliveryConfirmation;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryConfirmation() {
		return deliveryConfirmation;
	}

	public void setDeliveryConfirmation(String deliveryConfirmation) {
		this.deliveryConfirmation = deliveryConfirmation;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
