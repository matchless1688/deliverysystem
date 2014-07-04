package com.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Agency;
import com.delivery.service.AgencyService;
import com.delivery.utils.JsonUtils;

@Controller
public class AgencyController {
	
	@Autowired
	private AgencyService agencyService;

	@RequestMapping(value = "queryAgencyList.do")
	@ResponseBody
	public String queryAgencyList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Agency> agencyList = agencyService.queryAgencyList();
		return JsonUtils.toJson(agencyList);
	}
	
	@RequestMapping(value = "addAgency.do")
	@ResponseBody
	public String addAgency(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parent = request.getParameter("parent");
		String region = request.getParameter("region");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String manager = request.getParameter("manager");
		String managerPhone = request.getParameter("managerPhone");
		
		Agency agency = new Agency();
		agency.setParent(parent);
		agency.setRegion(region);
		agency.setName(name);
		agency.setCode(code);
		agency.setType(type);
		agency.setAddress(address);
		agency.setManager(manager);
		agency.setManagerPhone(managerPhone);
		
	
		Agency a = agencyService.saveAgency(agency);
		
		response.sendRedirect("view/agency.html");
		return String.valueOf(a.getId());
	}
	
	@RequestMapping(value = "deleteAgency.do")
	@ResponseBody
	public String deleteAgency(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Agency agency = new Agency();
		agency.setId(hid);
		agencyService.deleteAgency(agency);
		
		response.sendRedirect("view/agency.html");
		return "0";
	}
	
	@RequestMapping(value = "queryAgency.do")
	@ResponseBody
	public String queryAgency(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Agency agency = agencyService.queryAgency(hid);
		return JsonUtils.toJson(agency);
	}
	
	@RequestMapping(value = "queryAgencyByType.do")
	@ResponseBody
	public String queryAgencyByType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String type = request.getParameter("type");
		List<Agency> agencyList = agencyService.queryAgencyByType(type);
		return JsonUtils.toJson(agencyList);
	}
	
	@RequestMapping(value = "queryAgencyByParent.do")
	@ResponseBody
	public String queryAgencyByParent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parent = request.getParameter("parent");
		List<Agency> agencyList = agencyService.queryAgencyByParent(parent);
		return JsonUtils.toJson(agencyList);
	}
}
