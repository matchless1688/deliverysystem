package com.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Express;
import com.delivery.service.ExpressService;
import com.delivery.utils.JsonUtils;

@Controller
public class ExpressController {

	@Autowired
	private ExpressService expressService;
	
	@RequestMapping(value = "queryExpressList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryExpressList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Express> expressList = expressService.queryExpressList();
		return JsonUtils.toJson(expressList);
	}
	
	@RequestMapping(value = "queryExpressListByPage.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryExpressListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sEcho = request.getParameter("sEcho");
		String iDisplayStart = request.getParameter("iDisplayStart");
		String iDisplayLength = request.getParameter("iDisplayLength");
		
		PageRequest page = new PageRequest(Integer.valueOf(iDisplayStart) / Integer.valueOf(iDisplayLength), Integer.valueOf(iDisplayLength));
		Page<Express> expressPage = expressService.queryExpressListByPage(page);
		List<Express> returnList = new ArrayList<Express>();
		for(Express express : expressPage) {
			returnList.add(express);
		}
		long count = expressService.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData", returnList);
		map.put("iTotalRecords", count);
		map.put("iTotalDisplayRecords", count);
		map.put("sEcho", sEcho);
		return JsonUtils.toJson(map);
	}
	
	@RequestMapping(value = "addExpress.do")
	@ResponseBody
	public String addExpress(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String barCode = request.getParameter("barCode");
		String tdjh = request.getParameter("tdjh");
		String dateTime = request.getParameter("dateTime");
		String deliTel = request.getParameter("deliTel");
		String station = request.getParameter("station");
		String box = request.getParameter("box");
		String expressCompanyCode = request.getParameter("expressCompanyCode");
		String ownerPhone = request.getParameter("ownerPhone");
		String status = request.getParameter("status");
		String expressId = request.getParameter("expressId");
		
		Express express;
		if(StringUtils.isEmpty(expressId)) {
			express = new Express();
			express.setBarCode(barCode);
			express.setTdjh(tdjh);
			express.setDateTime(dateTime);
			express.setDeliTel(deliTel);
			express.setStationId(station);
			express.setBoxId(box);
			express.setExpressCompanyCode(expressCompanyCode);
			express.setOwnerPhone(ownerPhone);
			express.setStatus(status);
		} else {
			express = expressService.queryExpress(Integer.valueOf(expressId));
			express.setBarCode(barCode);
			express.setTdjh(tdjh);
			express.setDateTime(dateTime);
			express.setDeliTel(deliTel);
			express.setStationId(station);
			express.setBoxId(box);
			express.setExpressCompanyCode(expressCompanyCode);
			express.setOwnerPhone(ownerPhone);
			express.setStatus(status);
		}
		
		Express e = expressService.saveExpress(express);
		
		response.sendRedirect("express.html");
		return String.valueOf(e.getId());
	}
	
	@RequestMapping(value = "deleteExpress.do")
	@ResponseBody
	public String deleteExpress(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Express express = new Express();
		express.setId(Integer.valueOf(hid));
		expressService.deleteExpress(express);
		
		response.sendRedirect("express.html");
		return "0";
	}
	
	@RequestMapping(value = "queryExpress.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryExpress(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Express express = expressService.queryExpress(Integer.valueOf(hid));
		return JsonUtils.toJson(express);
	}
}
