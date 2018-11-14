package com.java.model;

/**
 * 查询客户模型类
 * 
 * @author Garin
 *
 */
public class Car{
	private int carID;
	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	private String rent;
	private String carName;
	private String brank;
	private String type;
	private String carInfo;
	private String number;
	private int userID;
	
	public Car() {
		super();
	}	

	public Car(int carID, String rent, String carName, String brank,String type,String carInfo,String number, int userID) {
		super();
		this.carID = carID;
		this.rent  = rent;
		this.carName = carName;
		this.brank = brank;
		this.type = type;
		this.carInfo = carInfo;
		this.userID = userID;
	}

	public Car(int carID, String rent,  String brank,String type,String carInfo,String number, int userID) {
		super();
		this.carID = carID;
		this.rent = rent;
		this.brank = brank;
		this.type = type;
		this.carInfo = carInfo;
		this.userID = userID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int userID) {
		this.userID = carID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}



}
