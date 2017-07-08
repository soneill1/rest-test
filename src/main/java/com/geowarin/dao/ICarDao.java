package com.geowarin.dao;

import java.util.List;

public interface ICarDao {
    List<Car> getAllCars();
    Car getCarById(int carId);
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int carId);
    boolean CarExists(String title, String category);
}
 
