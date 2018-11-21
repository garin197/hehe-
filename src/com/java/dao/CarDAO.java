package com.java.dao;

import java.util.List;

import org.omg.CORBA.ExceptionList;

import com.java.model.Car;

public interface CarDAO {
	public List getCarBrankList() throws Exception;

	public List getCarTypeList() throws Exception;

	public List getCarInfo() throws Exception;

	public List queryALL() throws Exception;
	
	public List queryByKey(String key)throws Exception;
	
	public void update(Car car)throws Exception;
}