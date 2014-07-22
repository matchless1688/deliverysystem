package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stations")
public class Station extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8249378374144347745L;

	@Column(name = "stationId", length = 100)
	private String stationId;
	
	@Column(name = "address", length = 100)
	private String address;
	
	@Column(name = "stationName", length = 20)
	private String name;
	
	@Column(name = "boxes", length = 4)
	private String boxes;
	
	@Column(name = "tdjh", length = 100)
	private String tdjh;
	
	@Column(name = "tdd", length = 100)
	private String tdd;
	
	@Column(name = "buildDate", length = 100)
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
}
