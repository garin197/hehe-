package com.java.model;

import java.sql.Date;

import com.java.util.stringUtil;

public class SelectOnContractModel {

	private String carName;
	private String name;
	private String license;
	private Date date;
	private int rent;

	public SelectOnContractModel(String carName, String name, String license, Date date, int rent) {
		super();
		this.carName = carName;
		this.name = name;
		this.license = license;
		this.date = date;
		this.rent = rent;
	}

	public SelectOnContractModel() {
		super();
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
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

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

}
