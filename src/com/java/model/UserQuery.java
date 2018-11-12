package com.java.model;

/**
 * 查询客户模型类
 * 
 * @author Garin
 *
 */
public class UserQuery {
	private int userID;
	private String name;
	private String phone;
	private String license;
	private String IDCard;
	private String carID;
	
	public UserQuery() {
		super();
	}	

	public UserQuery(int userID, String phone, String license, String iDCard, String carID) {
		super();
		this.userID = userID;
		this.phone = phone;
		this.license = license;
		IDCard = iDCard;
		this.carID = carID;
	}

	public UserQuery(int userID, String name, String phone, String license, String iDCard, String carID) {
		super();
		this.userID = userID;
		this.name = name;
		this.phone = phone;
		this.license = license;
		IDCard = iDCard;
		this.carID = carID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

}
