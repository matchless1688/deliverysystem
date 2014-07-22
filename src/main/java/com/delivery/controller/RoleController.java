package com.delivery.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Company;
import com.delivery.bo.Role;
import com.delivery.service.CompanyService;
import com.delivery.service.RoleService;
import com.delivery.utils.JsonUtils;
import com.delivery.utils.LastOprUtils;

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
				Company company = companyService.queryCompany(role.getOrganization());
				if(company != null) {
					role.setOrganization(company.getName());
				}
			}
			returnList.add(role);
		}
		return JsonUtils.toJson(returnList);
	}
	
	@RequestMapping(value = "queryRoleListByPage.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryRoleListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sEcho = request.getParameter("sEcho");
		String iDisplayStart = request.getParameter("iDisplayStart");
		String iDisplayLength = request.getParameter("iDisplayLength");
		
		PageRequest page = new PageRequest(Integer.valueOf(iDisplayStart) / Integer.valueOf(iDisplayLength), Integer.valueOf(iDisplayLength));
		Page<Role> rolePage = roleService.queryRoleListByPage(page);
		List<Role> returnList = new ArrayList<Role>();
		for(Role role : rolePage) {
			if(StringUtils.isNotEmpty(role.getOrganization())) {
				Company company = companyService.queryCompany(role.getOrganization());
				if(company != null) {
					role.setOrganization(company.getName());
				}
			}
			returnList.add(role);
		}
		long count = companyService.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData", returnList);
		map.put("iTotalRecords", count);
		map.put("iTotalDisplayRecords", count);
		map.put("sEcho", sEcho);
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
			role.setLastUpdateOpr(LastOprUtils.getLastOpr());
		} else {
			role = roleService.queryRole(roleId);
			role.setRoleName(name);
			role.setOrganization(organization);
			role.setAuthority(authority);
			role.setLastUpdateOpr(LastOprUtils.getLastOpr());
			role.setLastUpdateDt(new Date());
		}
		
		Role r = roleService.saveRole(role);
		
		response.sendRedirect("role.html");
		return r.getHid();
	}
	
	@RequestMapping(value = "deleteRole.do")
	@ResponseBody
	public String deleteRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Role role = new Role();
		role.setHid(hid);
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
