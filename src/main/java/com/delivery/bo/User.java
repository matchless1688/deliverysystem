package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "Id", length = 10)
	private int id;
	
	@Column(name = "userName", length = 20)
	private String userName;
	
	@Column(name = "telPhone", length = 11)
	private String telPhone;
	
	@Column(name = "pwd", length = 20)
	private String pwd;
	
	@Column(name = "type", length=20)
	private String type;
	
	@Column(name = "status", length=1)
	private int status;
	
	@Column(name = "companyId", length = 10)
	private String companyId;
	
	@Column(name = "info", length = 100)
	private String info;
	
	@Column(name = "smsVerifyCode", length = 6)
	private String smsVerifyCode;
	
	@Column(name = "smsCodeDateTime", length = 6)
	private String smsCodeDateTime;
	
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
