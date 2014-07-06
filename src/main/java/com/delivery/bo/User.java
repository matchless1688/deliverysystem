package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "Id", length = 32)
	private String id;
	
	@Column(name = "userName", length = 20)
	private String userName;
	
	@Column(name = "telPhone", length = 11)
	private String telPhone;
	
	@Column(name = "pwd", length = 20)
	private String pwd;
	
	@Column(name = "type", length=32)
	private String type;
	
	@Column(name = "status", length=2)
	private String status;
	
	@Column(name = "companyId", length = 10)
	private String companyId;
	
	@Column(name = "info", length = 100)
	private String info;
	
	@Column(name = "smsVerifyCode", length = 6)
	private String smsVerifyCode;
	
	@Column(name = "smsCodeDateTime", length = 6)
	private String smsCodeDateTime;
	
	@Column(name = "departmentId", length = 10)
	private String departmentId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSmsVerifyCode() {
		return smsVerifyCode;
	}
	public void setSmsVerifyCode(String smsVerifyCode) {
		this.smsVerifyCode = smsVerifyCode;
	}
	public String getSmsCodeDateTime() {
		return smsCodeDateTime;
	}
	public void setSmsCodeDateTime(String smsCodeDateTime) {
		this.smsCodeDateTime = smsCodeDateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
