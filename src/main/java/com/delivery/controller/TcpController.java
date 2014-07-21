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

import com.delivery.bo.Tcp;
import com.delivery.service.TcpService;
import com.delivery.utils.JsonUtils;

@Controller
public class TcpController {

	@Autowired
	private TcpService tcpService;

	@RequestMapping(value = "queryTcpList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryTcpList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Tcp> tcpList = tcpService.queryTcpList();
		return JsonUtils.toJson(tcpList);
	}
	
	@RequestMapping(value = "queryTcpListByPage.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryTcpListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sEcho = request.getParameter("sEcho");
		String iDisplayStart = request.getParameter("iDisplayStart");
		String iDisplayLength = request.getParameter("iDisplayLength");
		
		PageRequest page = new PageRequest(Integer.valueOf(iDisplayStart) / Integer.valueOf(iDisplayLength), Integer.valueOf(iDisplayLength));
		Page<Tcp> tcpPage = tcpService.queryTcpListByPage(page);
		List<Tcp> returnList = new ArrayList<Tcp>();
		for(Tcp tcp : tcpPage) {
			returnList.add(tcp);
		}
		long count = tcpService.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData", returnList);
		map.put("iTotalRecords", count);
		map.put("iTotalDisplayRecords", count);
		map.put("sEcho", sEcho);
		return JsonUtils.toJson(map);
	}
	
	@RequestMapping(value = "addTcp.do")
	@ResponseBody
	public String addTcp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Tcp tcp = new Tcp();
		Tcp t = tcpService.saveTcp(tcp);
		
		response.sendRedirect("userlog.html");
		return String.valueOf(t.getId());
	}
	
	@RequestMapping(value = "deleteTcp.do")
	@ResponseBody
	public String deleteTcp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Tcp tcp = new Tcp();
		tcp.setId(Integer.valueOf(hid));
		tcpService.deleteTcp(tcp);
		
		response.sendRedirect("userlog.html");
		return "0";
	}
	
	@RequestMapping(value = "queryTcp.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryTcp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Tcp tcp = tcpService.queryTcp(Integer.valueOf(hid));
		return JsonUtils.toJson(tcp);
	}
}
