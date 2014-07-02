package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_expressinfo")
public class Express implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", length = 20)
	private int id;
	
	@Column(name = "BarCode", length = 20)
	private String barCode;
	
	@Column(name = "TDJH", length = 6)
	private String tdjh;
	
	@Column(name = "Status", length = 6)
	private String status;
	
	@Column(name = "Datetime", length = 20)
	private String dateTime;
	
	@Column(name = "Deli_Tel", length = 20)
	private String deliTel;
	
	@Column(name = "StationId", length = 32)
	private String stationId;
	
	@Column(name = "BoxId", length = 32)
	private String boxId;
	
	@Column(name = "ExpressCompanyCode", length = 32)
	private String expressCompanyCode;
	
	@Column(name = "OwnerPhone", length = 20)
	private String ownerPhone;
	
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getTdjh() {
		return tdjh;
	}
	public void setTdjh(String tdjh) {
		this.tdjh = tdjh;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeliTel() {
		return deliTel;
	}
	public void setDeliTel(String deliTel) {
		this.deliTel = deliTel;
	}
	public String getExpressCompanyCode() {
		return expressCompanyCode;
	}
	public void setExpressCompanyCode(String expressCompanyCode) {
		this.expressCompanyCode = expressCompanyCode;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getBoxId() {
		return boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
