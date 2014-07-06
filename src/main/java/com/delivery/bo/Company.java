package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tb_company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", length = 10)
	private int id;
	
	@Column(name = "companyname", length = 30)
	private String name;
	
	@Column(name = "status", length = 2)
	private String status;
	
	@Column(name = "province", length = 20)
	private String province;
	
	@Column(name = "city", length=20)
	private String city;
	
	@Column(name = "address", length = 100)
	private String address;
	
	@Column(name = "contact", length = 20)
	private String contact;
	
	@Column(name = "telphone", length = 20)
	private String telPhone;
	
	@Column(name = "remark", length = 200)
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
