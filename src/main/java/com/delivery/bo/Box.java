package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_boxesinfo")
public class Box extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -373475183290601758L;

	@Column(name = "length", length = 6)
	private String length;
	
	@Column(name = "higth", length = 6)
	private String height;
	
	@Column(name = "width", length = 6)
	private String width;
	
	@Column(name = "status", length = 2)
	private String status;
	
	@Column(name = "type", length = 2)
	private String type;
	
	@Column(name = "stationId", length = 32)
	private String stationId;
	
	@Column(name = "barCode", length = 30)
	private String barCode;
	
	@Column(name = "ownerPhone", length = 11)
	private String ownerPhone;
	
	@Column(name = "pwd", length = 6)
	private String pwd;
	
	@Column(name = "boxId", length = 10)
	private String boxId;
	
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
	public String getBoxId() {
		return boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
}
