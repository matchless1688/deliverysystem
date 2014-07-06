package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_smssent")
public class SmsSend implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", length = 10)
	private int id;
	
	@Column(name = "sn", length = 20)
	private String sn;
	
	@Column(name = "Type", length = 2)
	private int type;
	
	@Column(name = "TelPhone", length = 11)
	private String telPhone;
	
	@Column(name = "context", length = 200)
	private String context;
	
	@Column(name = "Status", length = 50)
	private String status;
	
	@Column(name = "DeliveryConfirmation", length = 2)
	private String deliveryConfirmation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
}