package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_boxesinfo")
public class Box implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", length = 10)
	private int id;
	
	@Column(name = "Length", length = 6)
	private String length;
	
	@Column(name = "Higth", length = 6)
	private String height;
	
	@Column(name = "Width", length = 6)
	private String width;
	
	@Column(name = "Status", length = 2)
	private String status;
	
	@Column(name = "Type", length = 2)
	private String type;
	
	@Column(name = "StationId", length = 32)
	private String stationId;
	
	@Column(name = "BarCode", length = 30)
	private String barCode;
	
	@Column(name = "OwnerPhone", length = 11)
	private String ownerPhone;
	
	@Column(name = "Pwd", length = 6)
	private String pwd;
	
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
