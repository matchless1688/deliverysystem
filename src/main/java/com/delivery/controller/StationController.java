package com.delivery.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.delivery.bo.Station;
import com.delivery.service.StationService;
import com.delivery.utils.DateUtils;
import com.delivery.utils.JsonUtils;
import com.delivery.utils.LastOprUtils;

@Controller
public class StationController {

	@Autowired
	private StationService stationService;
	
	@RequestMapping(value = "queryStationList.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryStationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Station> stationList = stationService.queryStationList();
		return JsonUtils.toJson(stationList);
	}
	
	@RequestMapping(value = "queryStationListByPage.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryStationListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sEcho = request.getParameter("sEcho");
		String iDisplayStart = request.getParameter("iDisplayStart");
		String iDisplayLength = request.getParameter("iDisplayLength");
		
		PageRequest page = new PageRequest(Integer.valueOf(iDisplayStart) / Integer.valueOf(iDisplayLength), Integer.valueOf(iDisplayLength));
		Page<Station> stationPage = stationService.queryStationListByPage(page);
		List<Station> returnList = new ArrayList<Station>();
		for(Station station : stationPage) {
			returnList.add(station);
		}
		long count = stationService.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaData", returnList);
		map.put("iTotalRecords", count);
		map.put("iTotalDisplayRecords", count);
		map.put("sEcho", sEcho);
		return JsonUtils.toJson(map);
	}
	
	@RequestMapping(value = "addStation.do")
	@ResponseBody
	public String addStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String boxes = request.getParameter("boxes");
		String tdjh = request.getParameter("tdjh");
		String tdd = request.getParameter("tdd");
		String stationKeyId = request.getParameter("stationKeyId");
		String stationId = request.getParameter("stationId");
		
		Station station;
		if(StringUtils.isEmpty(stationId)) {
			station = new Station();
			station.setAddress(address);
			station.setName(name);
			station.setBoxes(boxes);
			station.setTdd(tdd);
			station.setTdjh(tdjh);
			station.setStationId(stationKeyId);
			station.setBuildDate(DateUtils.buildDateStr());
			station.setLastUpdateOpr(LastOprUtils.getLastOpr());
		} else {
			station = stationService.queryStation(stationId);
			station.setAddress(address);
			station.setName(name);
			station.setBoxes(boxes);
			station.setTdd(tdd);
			station.setTdjh(tdjh);
			station.setStationId(stationKeyId);
			station.setBuildDate(DateUtils.buildDateStr());
			station.setLastUpdateOpr(LastOprUtils.getLastOpr());
			station.setLastUpdateDt(new Date());
		}
		
		Station s = stationService.saveStation(station);
		
		response.sendRedirect("station.html");
		return s.getHid();
	}
	
	@RequestMapping(value = "deleteStation.do")
	@ResponseBody
	public String deleteStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Station station = new Station();
		station.setHid(hid);
		stationService.deleteStation(station);
		
		response.sendRedirect("station.html");
		return "0";
	}
	
	@RequestMapping(value = "queryStation.do", produces= {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String queryStation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String hid = request.getParameter("hid");
		Station station = stationService.queryStation(hid);
		return JsonUtils.toJson(station);
	}
}
