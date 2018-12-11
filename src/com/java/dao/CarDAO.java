package com.java.dao;

import java.util.List;

import com.java.model.Car;

public interface CarDAO {
	public List getCarBrankList() throws Exception;

	public List getCarTypeList() throws Exception;

	public List getCarInfo() throws Exception;

	public List queryALL() throws Exception;
	
	public List queryByKey(String key)throws Exception;
	
	public List queryByKey(String key1,String key2)throws Exception;
	
	public boolean update(Car car)throws Exception;
	public boolean updateByCarName(String carName)throws Exception;
	
	public int delete(int carID)throws Exception;
	public   int insert(String sql)throws Exception ;
	
	
}