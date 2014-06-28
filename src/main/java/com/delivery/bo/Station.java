package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_station")
public class Station extends IdEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "address", length = 200)
	private String address;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "boxes", length = 50)
	private String boxes;
	
	@Column(name = "tdjh", length = 50)
	private String tdjh;
	
	@Column(name = "tdd", length = 50)
	private String tdd;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoxes() {
		return boxes;
	}
	public void setBoxes(String boxes) {
		this.boxes = boxes;
	}
	public String getTdjh() {
		return tdjh;
	}
	public void setTdjh(String tdjh) {
		this.tdjh = tdjh;
	}
	public String getTdd() {
		return tdd;
	}
	public void setTdd(String tdd) {
		this.tdd = tdd;
	}
}
