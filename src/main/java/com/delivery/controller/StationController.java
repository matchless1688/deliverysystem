package com.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delivery.bo.Station;
import com.delivery.service.StationService;
import com.delivery.utils.DateUtils;
import com.delivery.utils.JsonUtils;

@Controller
public class StationController {

	@Autowired
	private StationService stationService;
	
	@RequestMapping(value = "queryStationList.do")
	@ResponseBody
	public String queryStationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Station> stationList = stationService.queryStationList();
		return JsonUtils.toJson(stationList);
	}
	
	@RequestMapping(value = "addStation.do")
	@ResponseBody
	public String addStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String boxes = request.getParameter("boxes");
		String tdjh = request.getParameter("tdjh");
		String tdd = request.getParameter("tdd");
		Station station = new Station();
		station.setAddress(address);
		station.setName(name);
		station.setBoxes(boxes);
		station.setTdd(tdd);
		station.setTdjh(tdjh);
		station.setBuildDate(DateUtils.buildDateStr());
		stationService.saveStation(station);
		
		response.sendRedirect("view/station.html");
		return String.valueOf(station.getId());
	}
	
	@RequestMapping(value = "deleteStation.do")
	@ResponseBody
	public String deleteStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Station station = new Station();
		station.setId(hid);
		stationService.deleteStation(station);
		
		response.sendRedirect("view/station.html");
		return "0";
	}
}
