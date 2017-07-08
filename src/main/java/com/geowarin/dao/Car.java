package com.geowarin.dao;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car implements Serializable { 
	
	private static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="car_id")
    private int carId;  
	
	@Column(name="car_model")
    private String carModel;
	
	@Column(name="car_make")	
	private String carMake;
	
	@Column(name="car_year")	
	private String carYear;
	
	@Column(name="price")	
	private String price;
	
	public Car() {

	}
	
	public Car(String carModel, String carMake, String carYear, String price) {
		this.carModel = carModel;
		this.carMake = carMake;
		this.carYear = carYear;
		this.price = price;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
} 