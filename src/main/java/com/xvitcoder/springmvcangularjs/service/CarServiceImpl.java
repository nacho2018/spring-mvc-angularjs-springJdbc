package com.xvitcoder.springmvcangularjs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Service;

import com.xvitcoder.springmvcangularjs.beans.Car;
import com.xvitcoder.springmvcangularjs.repository.CarRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/20/12
 * Time: 11:14 PM
 */
@Service("carService")
public class CarServiceImpl implements CarService {
	
	@Autowired 
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
    private List<String> carList = new ArrayList<String>();
    
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Car> getAllCars(){
//    	String[] cars = new String[]{"ford", "volvo", "toyota"};
//    	for (int i = 0; i < cars.length; i++){
//    		carList.add(cars[i]);
//    	}
//        return carList;
    	
    	jdbcTemplate = new JdbcTemplate(dataSource);
    	
    	String sql = "SELECT * FROM CARS";
    	List<Car> cars = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Car.class));
    	
    	return cars;
    	
    	
    }

    @Override
    public void addCar(String car) {
        carList.add(car);
    }

    @Override
    public void deleteCar(String car) {
        if (carList.contains(car)) {
            carList.remove(car);
        }
    }

    @Override
    public void deleteAll() {
        carList.clear();
    }
}
