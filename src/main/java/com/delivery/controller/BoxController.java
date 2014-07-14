package com.delivery.controller;

import java.util.ArrayList;
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

import com.delivery.bo.Box;
import com.delivery.bo.Station;
import com.delivery.service.BoxService;
import com.delivery.service.StationService;
import com.delivery.utils.JsonUtils;

@Controller
public class BoxController {

	@Autowired
	private BoxService boxService;
	
	@Autowired
	private StationService stationService;
	
	@RequestMapping(value = "queryBoxList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryBoxList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Box> boxList = boxService.queryBoxList();
		List<Box> returnList = new ArrayList<Box>();
		for(Box box : boxList) {
			if(StringUtils.isNotEmpty(box.getStationId())) {
				Station station = stationService.queryStation(Integer.valueOf(box.getStationId()));
				if(station != null) {
					box.setStationId(station.getName());
				}
			}
			returnList.add(box);
		}
		Map<String, List<Box>> map = new HashMap<String, List<Box>>();
		map.put("aaData", returnList);
		return JsonUtils.toJson(map);
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
		String status = request.getParameter("status");
		String boxId = request.getParameter("boxId");
		
		Box box;
		if(StringUtils.isEmpty(boxId)) {
			box = new Box();
			box.setLength(length);
			box.setHeight(height);
			box.setWidth(width);
			box.setStationId(station);
			box.setBarCode(barCode);
			box.setOwnerPhone(ownerPhone);
			box.setStatus(status);
		} else {
			box = boxService.queryBox(Integer.valueOf(boxId));
			box.setLength(length);
			box.setHeight(height);
			box.setWidth(width);
			box.setStationId(station);
			box.setBarCode(barCode);
			box.setOwnerPhone(ownerPhone);
			box.setStatus(status);
		}
		Box b = boxService.saveBox(box);
		
		response.sendRedirect("box.html");
		return String.valueOf(b.getId());
	}
	
	@RequestMapping(value = "deleteBox.do")
	@ResponseBody
	public String deleteBox(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Box box = new Box();
		box.setId(Integer.valueOf(hid));
		boxService.deleteBox(box);
		
		response.sendRedirect("box.html");
		return "0";
	}
	
	@RequestMapping(value = "queryBox.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryBox(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Box box = boxService.queryBox(Integer.valueOf(hid));
		return JsonUtils.toJson(box);
	}
	
	@RequestMapping(value = "queryBoxByStationId.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryBoxByStationId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String stationId = request.getParameter("stationId");
		List<Box> boxList = boxService.queryBoxByStationId(stationId);
		return JsonUtils.toJson(boxList);
	}
}
