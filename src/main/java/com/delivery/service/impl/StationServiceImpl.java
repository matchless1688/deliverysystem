package com.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Station queryStation(int id) {
		return stationDaoInf.findOne(id);
	}

	@Override
	public Page<Station> queryStationListByPage(Pageable page) {
		return stationDaoInf.findAll(page);
	}

	@Override
	public long count() {
		return stationDaoInf.count();
	}
}
