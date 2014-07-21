package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.delivery.bo.Role;
import com.delivery.dao.RoleDaoInf;
import com.delivery.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDaoInf roleDaoInf;

	@Override
	public List<Role> queryRoleList() {
		return (List<Role>) roleDaoInf.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		return roleDaoInf.save(role);
	}

	@Override
	public void deleteRole(Role role) {
		roleDaoInf.delete(role);
	}

	@Override
	public Role queryRole(String id) {
		return roleDaoInf.findOne(id);
	}

	@Override
	public Page<Role> queryRoleListByPage(Pageable page) {
		return roleDaoInf.findAll(page);
	}

	@Override
	public long count() {
		return roleDaoInf.count();
	}

}
