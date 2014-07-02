package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.bo.Station;
import com.delivery.dao.StationDaoInf;
import com.delivery.service.StationService;

@Service("stationService")
public class StationServiceImpl implements StationService {

	@Autowired
	private StationDaoInf stationDaoInf;

	@Override
	public List<Station> queryStationList() {
		return (List<Station>) stationDaoInf.findAll();
	}

	@Override
	public Station saveStation(Station station) {
		return stationDaoInf.save(station);
	}

	@Override
	public void deleteStation(Station station) {
		stationDaoInf.delete(station);
	}
}