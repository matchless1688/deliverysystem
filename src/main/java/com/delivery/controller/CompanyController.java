package com.delivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Company;
import com.delivery.constants.Constants;
import com.delivery.service.CompanyService;
import com.delivery.utils.JsonUtils;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "queryCompanyList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryCompanyList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Company> companyList = companyService.queryCompanyList();
		Map<String, List<Company>> map = new HashMap<String, List<Company>>();
		map.put("aaData", companyList);
		return JsonUtils.toJson(map);
	}
	
	@RequestMapping(value = "addCompany.do")
	@ResponseBody
	public String addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String telPhone = request.getParameter("telPhone");
		String remark = request.getParameter("remark");
		String companyId = request.getParameter("companyId");
		
		Company company;
		if(StringUtils.isEmpty(companyId)) {
			company = new Company();
			company.setName(name);
			company.setProvince(province);
			company.setCity(city);
			company.setAddress(address);
			company.setContact(contact);
			company.setTelPhone(telPhone);
			company.setRemark(remark);
			company.setStatus(Constants.STATUS_AVAILABLE);
		} else {
			company = companyService.queryCompany(Integer.valueOf(companyId));
			company.setName(name);
			company.setProvince(province);
			company.setCity(city);
			company.setAddress(address);
			company.setContact(contact);
			company.setTelPhone(telPhone);
			company.setRemark(remark);
			company.setStatus(Constants.STATUS_AVAILABLE);
		}
		Company c = companyService.saveCompany(company);
		
		response.sendRedirect("company.html");
		return String.valueOf(c.getId());
	}
	
	@RequestMapping(value = "deleteCompany.do")
	@ResponseBody
	public String deleteCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Company company = new Company();
		company.setId(Integer.valueOf(hid));
		companyService.deleteCompany(company);
		
		response.sendRedirect("company.html");
		return "0";
	}
	
	@RequestMapping(value = "queryCompany.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Company company = companyService.queryCompany(Integer.valueOf(hid));
		return JsonUtils.toJson(company);
	}
}
