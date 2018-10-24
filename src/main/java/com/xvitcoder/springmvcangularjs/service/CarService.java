package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import com.xvitcoder.springmvcangularjs.beans.Car;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/20/12
 * Time: 11:12 PM
 */
public interface CarService {
    public List<Car> getAllCars();

    public void addCar(String car);

    public void deleteCar(String car);

    public void deleteAll();
}
