package com.geowarin.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CarDao implements ICarDao {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Car getCarById(int carId) {
		return entityManager.find(Car.class, carId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getAllCars() {
		String hql = "FROM Car as atcl ORDER BY atcl.carId";
		return (List<Car>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public void addCar(Car car) {
		entityManager.persist(car);
	}
	
	@Override
	public void updateCar(Car car) {
		Car artcl = getCarById(car.getCarId());
//		artcl.setTitle(car.getTitle());
//		artcl.setCategory(car.getCategory());
		entityManager.flush();
	}
	
	@Override
	public void deleteCar(int carId) {
		entityManager.remove(getCarById(carId));
	}

	@Override
	public boolean CarExists(String title, String category) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@Override
//	public boolean carExists(String title, String category) {
//		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, title)
//		              .setParameter(2, category).getResultList().size();
//		return count > 0 ? true : false;
//	}
}

