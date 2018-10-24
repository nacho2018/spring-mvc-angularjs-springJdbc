package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.RailwayStation;

import java.util.List;

import org.springframework.dao.DataAccessException;


public interface RailwayStationService {
	
    public List<RailwayStation> getAllRailwayStations() throws DataAccessException;

    public RailwayStation getRailwayStationById(Long id);

    public void addRailwayStation(RailwayStation RailwayStation);

    public void deleteRailwayStationById(Long id);

    public void deleteAll();

    public void updateRailwayStation(RailwayStation RailwayStation);
}
