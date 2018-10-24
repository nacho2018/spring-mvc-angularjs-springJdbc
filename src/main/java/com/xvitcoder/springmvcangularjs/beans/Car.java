package com.xvitcoder.springmvcangularjs.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="cars")
public class Car {

	@Id 
	@GeneratedValue
	private Long id;
	private String model;
	private String firm;
	private int year;
	
	public Car(){ };
	public Car(Long id, String model, String firm, int year){
		
		this.id = id;
		this.firm = firm;
		this.model = model;
		this.year = year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString(){
		
		return "car: [id = " + this.id + " model = " + this.model +
				" firm = " + this.firm + " year= " + this.year;
	}
	
}
