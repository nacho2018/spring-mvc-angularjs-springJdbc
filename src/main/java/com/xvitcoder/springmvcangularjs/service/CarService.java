package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.xvitcoder.springmvcangularjs.beans.Car;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/20/12
 * Time: 11:12 PM
 */
public interface CarService {
    public List<Car> getAllCars() throws DataAccessException;

    public void addCar(String car);

    public void deleteCar(Long id) throws DataAccessException;

    public void deleteAll();
}
