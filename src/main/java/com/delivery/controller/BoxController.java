package com.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Box;
import com.delivery.service.BoxService;
import com.delivery.utils.JsonUtils;

@Controller
public class BoxController {

	@Autowired
	private BoxService boxService;
	
	@RequestMapping(value = "queryBoxList.do")
	@ResponseBody
	public String queryBoxList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Box> boxList = boxService.queryBoxList();
		return JsonUtils.toJson(boxList);
	}
	
	@RequestMapping(value = "addBox.do")
	@ResponseBody
	public String addBox(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String length = request.getParameter("length");
		String height = request.getParameter("height");
		String width = request.getParameter("width");
		String station = request.getParameter("station");
		String barCode = request.getParameter("barCode");
		String ownerPhone = request.getParameter("ownerPhone");
		Box box = new Box();
		box.setLength(length);
		box.setHeight(height);
		box.setWidth(width);
		box.setStationId(station);
		box.setBarCode(barCode);
		box.setOwnerPhone(ownerPhone);
		box.setStatus("1");
		Box b = boxService.saveBox(box);
		
		response.sendRedirect("view/box.html");
		return String.valueOf(b.getId());
	}
	
	@RequestMapping(value = "deleteBox.do")
	@ResponseBody
	public String deleteBox(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Box box = new Box();
		box.setId(Integer.valueOf(hid));
		boxService.deleteBox(box);
		
		response.sendRedirect("view/box.html");
		return "0";
	}
}
