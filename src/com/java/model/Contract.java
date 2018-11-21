package com.java.model;

import java.sql.Date;

import com.java.util.stringUtil;

public class Contract {

	private int carID;
	private String name;
	private String license;
	private Date date;
	private double rent;
	private int userID;

	public Contract(int carID, String name, String license, Date date, double rent, int userID) {
		super();
		this.carID = carID;
		this.name = name;
		this.license = license;
		this.date = date;
		this.rent = rent;
		this.userID = userID;
	}

	public Contract() {
		super();
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Date getDate() {
		return date;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
