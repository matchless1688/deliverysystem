package com.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.SmsSend;
import com.delivery.service.SmsSendService;
import com.delivery.utils.JsonUtils;

@Controller
public class SmsSendController {

	@Autowired
	private SmsSendService smsSendService;

	@RequestMapping(value = "querySmsSendList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String querySmsSendList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SmsSend> smsSendList = smsSendService.querySmsSendList();
		return JsonUtils.toJson(smsSendList);
	}
	
	@RequestMapping(value = "addSmsSend.do")
	@ResponseBody
	public String addSmsSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SmsSend smsSend = new SmsSend();
		SmsSend s = smsSendService.saveSmsSend(smsSend);
		
		response.sendRedirect("sms.html");
		return String.valueOf(s.getId());
	}
	
	@RequestMapping(value = "deleteSmsSend.do")
	@ResponseBody
	public String deleteSmsSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		SmsSend smsSend = new SmsSend();
		smsSend.setId(Integer.valueOf(hid));
		smsSendService.deleteSmsSend(smsSend);
		
		response.sendRedirect("sms.html");
		return "0";
	}
	
	@RequestMapping(value = "querySmsSend.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String querySmsSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		SmsSend smsSend = smsSendService.querySmsSend(Integer.valueOf(hid));
		return JsonUtils.toJson(smsSend);
	}
}
