package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_box")
public class Box extends IdEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "length", length = 20)
	private String length;
	
	@Column(name = "height", length = 20)
	private String height;
	
	@Column(name = "width", length = 20)
	private String width;
	
	@Column(name = "status", length = 10)
	private String status;
	
	@Column(name = "type", length = 10)
	private String type;
	
	@Column(name = "stationId", length = 32)
	private String stationId;
	
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
}
