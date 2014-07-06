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
import com.delivery.bo.Company;
import com.delivery.service.AgencyService;
import com.delivery.service.CompanyService;
import com.delivery.utils.JsonUtils;

@Controller
public class AgencyController {
	
	@Autowired
	private AgencyService agencyService;
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "queryAgencyList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryAgencyList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Agency> agencyList = agencyService.queryAgencyList();
		List<Agency> returnList = new ArrayList<Agency>();
		for(Agency agency : agencyList) {
			Company company = companyService.queryCompany(Integer.valueOf(agency.getParent()));
			if(company != null) {
				agency.setParent(company.getName());
			}
			returnList.add(agency);
		}
		return JsonUtils.toJson(returnList);
	}
	
	@RequestMapping(value = "addAgency.do")
	@ResponseBody
	public String addAgency(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String company = request.getParameter("company");
		String region = request.getParameter("region");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String manager = request.getParameter("manager");
		String managerPhone = request.getParameter("managerPhone");
		
		Agency agency = new Agency();
		agency.setParent(company);
		agency.setRegion(region);
		agency.setName(name);
		agency.setCode(code);
		agency.setType(type);
		agency.setAddress(address);
		agency.setManager(manager);
		agency.setManagerPhone(managerPhone);
		
	
		Agency a = agencyService.saveAgency(agency);
		
		response.sendRedirect("agency.html");
		return String.valueOf(a.getId());
	}
	
	@RequestMapping(value = "deleteAgency.do")
	@ResponseBody
	public String deleteAgency(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Agency agency = new Agency();
		agency.setId(hid);
		agencyService.deleteAgency(agency);
		
		response.sendRedirect("agency.html");
		return "0";
	}
	
	@RequestMapping(value = "queryAgency.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryAgency(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Agency agency = agencyService.queryAgency(hid);
		return JsonUtils.toJson(agency);
	}
	
	@RequestMapping(value = "queryAgencyByType.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryAgencyByType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String type = request.getParameter("type");
		List<Agency> agencyList = agencyService.queryAgencyByType(type);
		return JsonUtils.toJson(agencyList);
	}
	
	@RequestMapping(value = "queryAgencyByParent.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryAgencyByParent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parent = request.getParameter("parent");
		List<Agency> agencyList = agencyService.queryAgencyByParent(parent);
		return JsonUtils.toJson(agencyList);
	}
}
