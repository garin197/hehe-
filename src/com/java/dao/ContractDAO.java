package com.java.dao;

import java.util.List;

import com.java.model.Contract;

public interface ContractDAO {
	public void addContract(Contract contract)throws Exception;
	public int delContract(String carID) throws Exception;
	public List queryall()throws Exception;
	public List queryByLicense(String license) throws Exception;
	public int exist_carId_in_contract(int carID) throws Exception;
}
