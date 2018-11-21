package com.java.dao;

import java.util.List;

import org.ietf.jgss.Oid;

import com.java.model.Contract;

public interface ContractDAO {
	public void addContract(Contract contract)throws Exception;
	public List queryall()throws Exception;
}
