package com.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.User;
import com.delivery.constants.Constants;
import com.delivery.service.UserService;
import com.delivery.utils.JsonUtils;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "queryUserList.do")
	@ResponseBody
	public String queryUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> userList = userService.queryUserList();
		return JsonUtils.toJson(userList);
	}
	
	@RequestMapping(value = "registerUser.do")
	@ResponseBody
	public String registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		User user = new User();
		user.setUserName(userName);
		user.setPwd(password);
		user.setTelPhone(phone);
		user.setCompanyId(company);
		user.setStatus(Constants.USER_STATUS_ACTIVE);
		User u = userService.saveUser(user);
		
		response.sendRedirect("view/index.html");
		return String.valueOf(u.getId());
	}
	
	@RequestMapping(value = "deleteUser.do")
	@ResponseBody
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		User user = new User();
		user.setId(Integer.valueOf(hid));
		userService.deleteUser(user);
		
		response.sendRedirect("view/index.html");
		return "0";
	}
}
