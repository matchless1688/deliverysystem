package com.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Agency;
import com.delivery.bo.Company;
import com.delivery.bo.Role;
import com.delivery.bo.SmsSend;
import com.delivery.bo.SmsTemplate;
import com.delivery.bo.User;
import com.delivery.constants.Constants;
import com.delivery.dao.SmsSendDaoInf;
import com.delivery.dao.SmsTemplateDaoInf;
import com.delivery.service.AgencyService;
import com.delivery.service.CompanyService;
import com.delivery.service.RoleService;
import com.delivery.service.UserService;
import com.delivery.utils.CommonUtils;
import com.delivery.utils.JsonUtils;
import com.delivery.utils.SmsUtils;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private SmsTemplateDaoInf smsTemplateDaoInf;
	
	@Autowired
	private SmsSendDaoInf smsSendDaoInf;

	@RequestMapping(value = "queryUserList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> userList = userService.queryUserList();
		List<User> returnList = new ArrayList<User>();
		for(User user : userList) {
			if(StringUtils.isNotEmpty(user.getType())) {
				Role role = roleService.queryRole(user.getType());
				if(role != null) {
					user.setType(role.getRoleName());
				}
			}
			
			if(StringUtils.isNotEmpty(user.getCompanyId())) {
				Company company = companyService.queryCompany(Integer.valueOf(user.getCompanyId()));
				if(company != null) {
					user.setCompanyId(company.getName());
				}
			}
			
			if(StringUtils.isNotEmpty(user.getDepartmentId())) {
				Agency department = agencyService.queryAgency(user.getDepartmentId());
				if(department != null) {
					user.setDepartmentId(department.getName());
				}
			}
			returnList.add(user);
		}
		return JsonUtils.toJson(returnList);
	}
	
	@RequestMapping(value = "queryUserListByPage.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryUserListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sEcho = request.getParameter("sEcho");
		String iDisplayStart = request.getParameter("iDisplayStart");
		String iDisplayLength = request.getParameter("iDisplayLength");
		
		PageRequest page = new PageRequest(Integer.valueOf(iDisplayStart) / Integer.valueOf(iDisplayLength), Integer.valueOf(iDisplayLength));
		Page<User> userList = userService.queryUserListByPage(page);
		List<User> returnList = new ArrayList<User>();
		for(User user : userList) {
			if(StringUtils.isNotEmpty(user.getType())) {
				Role role = roleService.queryRole(user.getType());
				if(role != null) {
					user.setType(role.getRoleName());
				}
			}
			
			if(StringUtils.isNotEmpty(user.getCompanyId())) {
				Company company = companyService.queryCompany(Integer.valueOf(user.getCompanyId()));
				if(company != null) {
					user.setCompanyId(company.getName());
				}
			}
			
			if(StringUtils.isNotEmpty(user.getDepartmentId())) {
				Agency department = agencyService.queryAgency(user.getDepartmentId());
				if(department != null) {
					user.setDepartmentId(department.getName());
				}
			}
			returnList.add(user);
		}
		long count = userService.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData", returnList);
		map.put("iTotalRecords", count);
		map.put("iTotalDisplayRecords", count);
		map.put("sEcho", sEcho);
		return JsonUtils.toJson(map);
	}
	
	@RequestMapping(value = "addUser.do")
	@ResponseBody
	public String addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		String department = request.getParameter("department");
		String type = request.getParameter("role");
		String info = request.getParameter("info");
		String userId = request.getParameter("userId");
		User user;
		if(StringUtils.isEmpty(userId)) {
			user = new User();
			user.setUserName(userName);
			user.setTelPhone(phone);
			user.setCompanyId(company);
			user.setDepartmentId(department);
			user.setStatus(Constants.STATUS_AVAILABLE);
			user.setPwd(CommonUtils.genPwdBasedOnTel(phone));
			user.setType(type);
			user.setInfo(info);
			user = userService.saveUser(user);
			if(user != null) {
				SmsTemplate template = smsTemplateDaoInf.findOne(4);
				if(template != null) {
					SmsSend send = SmsUtils.send(user.getTelPhone(), user.getPwd(), template);
					smsSendDaoInf.save(send);
				}
			}
		} else {
			user = userService.queryUser(userId);
			user.setUserName(userName);
			user.setTelPhone(phone);
			user.setCompanyId(company);
			user.setDepartmentId(department);
			user.setStatus(Constants.STATUS_AVAILABLE);
			user.setPwd(CommonUtils.genPwdBasedOnTel(phone));
			user.setType(type);
			user.setInfo(info);
			user = userService.saveUser(user);
		}
		
		response.sendRedirect("index.html");
		return String.valueOf(user.getId());
	}
	
	@RequestMapping(value = "deleteUser.do")
	@ResponseBody
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		User user = new User();
		user.setId(hid);
		userService.deleteUser(user);
		
		response.sendRedirect("index.html");
		return "0";
	}
	
	@RequestMapping(value = "queryUser.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		User user = userService.queryUser(hid);
		return JsonUtils.toJson(user);
	}
	
	@RequestMapping(value = "queryUserByPhone.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryUserByPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
		User user = userService.queryUserByTelPhone(phone);
		String result = "0";
		if(user != null) {
			result = "1";
		}
		return result;
	}
}
