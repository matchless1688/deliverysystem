package com.delivery.service;

import java.util.List;

import com.delivery.bo.Role;

public interface RoleService {

	public List<Role> queryRoleList();
	
	public Role saveRole(Role role);
	
	public void deleteRole(Role role);
	
	public Role queryRole(String id);
}
