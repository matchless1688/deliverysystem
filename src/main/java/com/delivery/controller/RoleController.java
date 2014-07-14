package com.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Company;
import com.delivery.bo.Role;
import com.delivery.service.CompanyService;
import com.delivery.service.RoleService;
import com.delivery.utils.JsonUtils;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "queryRoleList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryRoleList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Role> roleList = roleService.queryRoleList();
		List<Role> returnList = new ArrayList<Role>();
		for(Role role : roleList) {
			if(StringUtils.isNotEmpty(role.getOrganization())) {
				Company company = companyService.queryCompany(Integer.valueOf(role.getOrganization()));
				if(company != null) {
					role.setOrganization(company.getName());
				}
			}
			returnList.add(role);
		}
		Map<String, List<Role>> map = new HashMap<String, List<Role>>();
		map.put("aaData", returnList);
		return JsonUtils.toJson(map);
	}
	
	@RequestMapping(value = "addRole.do")
	@ResponseBody
	public String addRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String organization = request.getParameter("organization");
		String authority = request.getParameter("authority");
		String roleId = request.getParameter("roleId");
		
		Role role;
		if(StringUtils.isEmpty(roleId)) {
			role = new Role();
			role.setRoleName(name);
			role.setOrganization(organization);
			role.setAuthority(authority);
		} else {
			role = roleService.queryRole(roleId);
			role.setRoleName(name);
			role.setOrganization(organization);
			role.setAuthority(authority);
			
		}
		
		Role r = roleService.saveRole(role);
		
		response.sendRedirect("role.html");
		return r.getId();
	}
	
	@RequestMapping(value = "deleteRole.do")
	@ResponseBody
	public String deleteRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Role role = new Role();
		role.setId(hid);
		roleService.deleteRole(role);
		
		response.sendRedirect("role.html");
		return "0";
	}
	
	@RequestMapping(value = "queryRole.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Role role = roleService.queryRole(hid);
		return JsonUtils.toJson(role);
	}
}
