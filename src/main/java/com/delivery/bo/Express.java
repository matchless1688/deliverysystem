package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_express")
public class Express extends IdEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "barCode", length = 32)
	private String barCode;
	
	@Column(name = "tdjh", length = 32)
	private String tdjh;
	
	@Column(name = "status", length = 10)
	private String status;
	
	@Column(name = "deliTel", length = 20)
	private String deliTel;
	
	@Column(name = "stationId", length = 32)
	private String stationId;
	
	@Column(name = "boxId", length = 32)
	private String boxId;
	
	@Column(name = "expressCompanyCode", length = 32)
	private String expressCompanyCode;
	
	@Column(name = "ownerPhone", length = 20)
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
}
