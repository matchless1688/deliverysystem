package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_smsteplate")
public class SmsTemplate extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5779784579151639897L;

	@Column(name = "part1", length = 100)
	private String part1;
	
	@Column(name = "part2", length = 100)
	private String part2;
	
	@Column(name = "part3", length = 100)
	private String part3;
	
	@Column(name = "part4", length = 100)
	private String part4;
	
	@Column(name = "part5", length = 100)
	private String part5;
	
	@Column(name = "part6", length = 100)
	private String part6;

	public String getPart1() {
		return part1;
	}

	public void setPart1(String part1) {
		this.part1 = part1;
	}

	public String getPart2() {
		return part2;
	}

	public void setPart2(String part2) {
		this.part2 = part2;
	}

	public String getPart3() {
		return part3;
	}

	public void setPart3(String part3) {
		this.part3 = part3;
	}

	public String getPart4() {
		return part4;
	}

	public void setPart4(String part4) {
		this.part4 = part4;
	}

	public String getPart5() {
		return part5;
	}

	public void setPart5(String part5) {
		this.part5 = part5;
	}

	public String getPart6() {
		return part6;
	}

	public void setPart6(String part6) {
		this.part6 = part6;
	}
}
