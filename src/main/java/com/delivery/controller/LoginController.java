package com.delivery.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.User;
import com.delivery.exception.ApplicationException;
import com.delivery.service.UserService;
import com.delivery.utils.JsonUtils;
import com.delivery.utils.LastOprUtils;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	private final static String LOGIN_MESSAGE = "loginMsg";
	private final static String LOGIN_USER = "loginUser";
	
	@RequestMapping(value = "login.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String userphone = request.getParameter("userphone");
		String password = request.getParameter("password");
		String result = "login.html";
		
		session.removeAttribute(LOGIN_MESSAGE);
		session.removeAttribute(LOGIN_USER);
		User user = userService.queryUserByTelPhone(userphone);
		if(user == null) {
			session.setAttribute(LOGIN_MESSAGE, "用户不存在.");
		} else {
			if(!user.getPwd().equals(password)) {
				session.setAttribute(LOGIN_MESSAGE, "用户名或者密码错误.");
			} else {
				session.setAttribute(LOGIN_USER, user.getUserName());
				LastOprUtils.setLastOpr(user.getUserName());
				result = "index.html";
			}
		}
		response.sendRedirect(result);
	}
	
	@RequestMapping(value = "logout.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		session.removeAttribute(LOGIN_MESSAGE);
		session.removeAttribute(LOGIN_USER);
		LastOprUtils.clear();
		response.sendRedirect("login.html");
	}
	
	@RequestMapping(value = "querySession.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String querySession(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ApplicationException {
		String loginUser = (String) session.getAttribute(LOGIN_USER);
		String loginMsg = (String) session.getAttribute(LOGIN_MESSAGE);
		Map<String, String> sessionMap = new HashMap<String, String>();
		sessionMap.put(LOGIN_USER, loginUser);
		sessionMap.put(LOGIN_MESSAGE, loginMsg);
		return JsonUtils.toJson(sessionMap);
	}
}
