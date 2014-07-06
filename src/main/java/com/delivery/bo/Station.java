package com.delivery.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stations")
public class Station implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", length = 32)
	private int id;
	
	@Column(name = "StationId", length = 100)
	private String stationId;
	
	@Column(name = "Address", length = 100)
	private String address;
	
	@Column(name = "StationName", length = 20)
	private String name;
	
	@Column(name = "Boxes", length = 4)
	private String boxes;
	
	@Column(name = "TDJH", length = 100)
	private String tdjh;
	
	@Column(name = "TDD", length = 100)
	private String tdd;
	
	@Column(name = "BuildDate", length = 100)
	private String buildDate;
	
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
	public String getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
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
}
