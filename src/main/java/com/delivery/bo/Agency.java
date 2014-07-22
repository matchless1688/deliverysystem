package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "tb_agency")
public class Agency extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4721335999167329230L;

	@Column(name = "name", length = 300)
	private String name;
	
	@Column(name = "type", length = 20)
	private String type;
	
	@Column(name = "region", length = 100)
	private String region;
	
	@Column(name = "code", length=50)
	private String code;
	
	@Column(name = "address", length = 500)
	private String address;
	
	@Column(name = "manager", length = 50)
	private String manager;
	
	@Column(name = "managerPhone", length = 20)
	private String managerPhone;
	
	@Column(name = "remark", length = 200)
	private String remark;
	
	@Column(name = "parent", length = 200)
	private String parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
}
