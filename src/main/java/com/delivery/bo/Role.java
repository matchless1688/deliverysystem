package com.delivery.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5319395944944046592L;

	@Column(name = "roleName", length = 30)
	private String roleName;
	
	@Column(name = "organization", length = 50)
	private String organization;
	
	@Column(name = "authority", length = 50)
	private String authority;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
