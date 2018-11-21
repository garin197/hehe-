package com.java.model;

/**
 * 查询客户模型类
 * 
 * @author Garin
 *
 */
public class Car {
	private double rent;
	private String carName;
	private String brank;
	private String type;
	private String carInfo;
	private int  number;
	private int userID;
	private int carID;

	public Car() {
		super();
	}

	public Car(double rent, String carName, String brank, String type, String carInfo, int number, int carID) {
		super();
		this.rent = rent;
		this.carName = carName;
		this.brank = brank;
		this.type = type;
		this.carInfo = carInfo;
		this.number = number;
		this.carID = carID;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getBrank() {
		return brank;
	}

	public void setBrank(String brank) {
		this.brank = brank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	public int  getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}
}
