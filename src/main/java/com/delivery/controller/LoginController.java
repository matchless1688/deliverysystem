package com.delivery.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.User;
import com.delivery.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "login.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String result = "ok";
		
		User user = userService.queryUserByUserName(userName);
		if(user == null) {
			result = "not exist";
		} else {
			if(!user.getPwd().equals(password)) {
				result = "username or password is not correct!";
			}
		}
		if(result.equals("ok")) {
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("login.html");
		}
		return result;
	}
}
