package com.xvitcoder.springmvcangularjs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.xvitcoder.springmvcangularjs.beans.RailwayStation;


@Service("RailwayStationService")
public class RailwayStationServiceImpl implements RailwayStationService {
    
	@Autowired 
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
    private static List<RailwayStation> rsList = new ArrayList<RailwayStation>();
    private static Long id = 0L;

    public RailwayStation getRailwayStationById(Long id) {
    	
    	return findRailwayStationById(id);
    }

    private RailwayStation findRailwayStationById(Long id) {
        for (RailwayStation rs : rsList) {
            if (rs.getId() == id) {
                return rs;
            }
        }

        return null;
    }

	public List<RailwayStation> getAllRailwayStations() throws DataAccessException{	
		
		jdbcTemplate = new JdbcTemplate(dataSource);
    	String sql = "SELECT * FROM RAILWAYSTATIONS";
    	@SuppressWarnings("rawtypes")
		List<RailwayStation> rwsts = jdbcTemplate.query(sql, new BeanPropertyRowMapper(RailwayStation.class));
    	return rwsts;
	}


	public void addRailwayStation(RailwayStation railwayStation) {
		railwayStation.setId(++ id);
		rsList.add(railwayStation);		
		
	}

	public void deleteRailwayStationById(Long id) {
        RailwayStation found = findRailwayStationById(id);
        if (found != null) {
            rsList.remove(found);
            id--;
        }
		
	}

	public void updateRailwayStation(RailwayStation railwayStation) {
        RailwayStation found = findRailwayStationById(railwayStation.getId());
        if (found != null) {
            rsList.remove(found);
            rsList.add(railwayStation);
        }
	}
	
    @Override
    public void deleteAll() {
        rsList.clear();
        id = 0L;
    }
}
