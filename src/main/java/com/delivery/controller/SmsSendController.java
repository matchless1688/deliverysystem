package com.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	@RequestMapping(value = "querySmsSendListByPage.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String querySmsSendListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sEcho = request.getParameter("sEcho");
		String iDisplayStart = request.getParameter("iDisplayStart");
		String iDisplayLength = request.getParameter("iDisplayLength");
		
		PageRequest page = new PageRequest(Integer.valueOf(iDisplayStart) / Integer.valueOf(iDisplayLength), Integer.valueOf(iDisplayLength));
		Page<SmsSend> smsSendPage = smsSendService.querySmsSendListByPage(page);
		List<SmsSend> returnList = new ArrayList<SmsSend>();
		for(SmsSend sms : smsSendPage) {
			returnList.add(sms);
		}
		long count = smsSendService.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData", returnList);
		map.put("iTotalRecords", count);
		map.put("iTotalDisplayRecords", count);
		map.put("sEcho", sEcho);
		return JsonUtils.toJson(map);
	}
	
	@RequestMapping(value = "addSmsSend.do")
	@ResponseBody
	public String addSmsSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SmsSend smsSend = new SmsSend();
		SmsSend s = smsSendService.saveSmsSend(smsSend);
		
		response.sendRedirect("sms.html");
		return s.getHid();
	}
	
	@RequestMapping(value = "deleteSmsSend.do")
	@ResponseBody
	public String deleteSmsSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		SmsSend smsSend = new SmsSend();
		smsSend.setHid(hid);
		smsSendService.deleteSmsSend(smsSend);
		
		response.sendRedirect("sms.html");
		return "0";
	}
	
	@RequestMapping(value = "querySmsSend.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String querySmsSend(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		SmsSend smsSend = smsSendService.querySmsSend(hid);
		return JsonUtils.toJson(smsSend);
	}
}
