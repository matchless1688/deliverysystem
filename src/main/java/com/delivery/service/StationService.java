package com.delivery.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.delivery.bo.Station;

public interface StationService {

	public List<Station> queryStationList();

	public Station saveStation(Station station);

	public void deleteStation(Station station);
	
	public Station queryStation(String hid);
	
	public Page<Station> queryStationListByPage(Pageable page);
	
	public long count();
}
