package com.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Agency;
import com.delivery.bo.Role;
import com.delivery.bo.User;
import com.delivery.service.AgencyService;
import com.delivery.service.RoleService;
import com.delivery.service.UserService;
import com.delivery.utils.CommonUtils;
import com.delivery.utils.JsonUtils;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AgencyService agencyService;

	@RequestMapping(value = "queryUserList.do")
	@ResponseBody
	public String queryUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> userList = userService.queryUserList();
		List<User> returnList = new ArrayList<User>();
		for(User user : userList) {
			Role role = roleService.queryRole(user.getType());
			if(role != null) {
				user.setType(role.getRoleName());
			}
			Agency agencyC = agencyService.queryAgency(user.getCompanyId());
			if(agencyC != null) {
				user.setCompanyId(agencyC.getName());
			}
			Agency agencyD = agencyService.queryAgency(user.getDepartmentId());
			if(agencyD != null) {
				user.setDepartmentId(agencyD.getName());
			}
			returnList.add(user);
		}
		return JsonUtils.toJson(returnList);
	}
	
	@RequestMapping(value = "addUser.do")
	@ResponseBody
	public String addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		String department = request.getParameter("department");
		String type = request.getParameter("role");
		User user = new User();
		user.setUserName(userName);
		user.setTelPhone(phone);
		user.setCompanyId(company);
		user.setDepartmentId(department);
		user.setStatus(true);
		user.setPwd(CommonUtils.genPwdBasedOnTel(phone));
		user.setType(type);
		User u = userService.saveUser(user);
		
		response.sendRedirect("view/index.html");
		return String.valueOf(u.getId());
	}
	
	@RequestMapping(value = "deleteUser.do")
	@ResponseBody
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		User user = new User();
		user.setId(hid);
		userService.deleteUser(user);
		
		response.sendRedirect("view/index.html");
		return "0";
	}
	
	@RequestMapping(value = "queryUser.do")
	@ResponseBody
	public String queryUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		User user = userService.queryUser(hid);
		return JsonUtils.toJson(user);
	}
}
