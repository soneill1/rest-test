package com.geowarin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geowarin.dao.Car;
import com.geowarin.dao.ICarDao;

@Service
public class CarService implements ICarService {
	
	@Autowired
	private ICarDao carDAO;
	
	@Override
	public Car getCarById(int carId) {
		Car obj = carDAO.getCarById(carId);
		return obj;
	}	
	
	@Override
	public List<Car> getAllCars(){
		return carDAO.getAllCars();
	}
	
//	@Override
//	public synchronized boolean addCar(Car car){
//       if (carDAO.articleExists(article.getTitle(), article.getCategory())) {
//    	   return false;
//       } else {
//    	   carDAO.addArticle(article);
//    	   return true;
//       }
//	}
	
	@Override
	public void updateCar(Car car) {
		carDAO.updateCar(car);
	}
	
	@Override
	public void deleteCar(int carId) {
		carDAO.deleteCar(carId);
	}

	@Override
	public boolean addCar(Car car) {
		// TODO Auto-generated method stub
		return false;
	}
}

