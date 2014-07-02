package com.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "queryExpressList.do")
	@ResponseBody
	public String queryExpressList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Express> expressList = expressService.queryExpressList();
		return JsonUtils.toJson(expressList);
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
		Express express = new Express();
		express.setBarCode(barCode);
		express.setTdjh(tdjh);
		express.setDateTime(dateTime);
		express.setDeliTel(deliTel);
		express.setStationId(station);
		express.setBoxId(box);
		express.setExpressCompanyCode(expressCompanyCode);
		express.setOwnerPhone(ownerPhone);
		express.setStatus("1");
		
		Express e = expressService.saveExpress(express);
		
		response.sendRedirect("view/express.html");
		return String.valueOf(e.getId());
	}
	
	@RequestMapping(value = "deleteExpress.do")
	@ResponseBody
	public String deleteExpress(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Express express = new Express();
		express.setId(Integer.valueOf(hid));
		expressService.deleteExpress(express);
		
		response.sendRedirect("view/express.html");
		return "0";
	}
}