package com.geowarin.service;

import java.util.List;

import com.geowarin.dao.Car;

public interface ICarService {
	
     List<Car> getAllCars();
     
     Car getCarById(int carId);
     
     boolean addCar(Car car);
     
     void updateCar(Car car);
     
     void deleteCar(int carId);
     
}

