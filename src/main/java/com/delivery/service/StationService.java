package com.delivery.service;

import java.util.List;

import com.delivery.bo.Station;

public interface StationService {

	public List<Station> queryStationList();

	public Station saveStation(Station station);

	public void deleteStation(Station station);
	
	public Station queryStation(int id);
}
