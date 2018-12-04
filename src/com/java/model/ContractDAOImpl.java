package com.java.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.dao.ContractDAO;
import com.java.util.DatabaseManagerCtrl;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ContractDAOImpl implements ContractDAO {
	Connection connection = null;

	@Override
	public void addContract(Contract contract) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {

			String sql = "insert into t_contract(carID,name,license,time,rent,userID) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, contract.getCarID());
			preparedStatement.setString(2, contract.getName());
			preparedStatement.setString(3, contract.getLicense());
			preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
			preparedStatement.setDouble(5, contract.getRent());
			preparedStatement.setInt(6, contract.getUserID());
			preparedStatement.executeUpdate();
		}
	}

	@Override
	public List queryall() throws Exception {
		List list = null;
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select carName,t_contract.name,t_contract.license,t_contract.time,t_contract.rent from t_car,t_contract where t_car.carID=t_contract.carID";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			list = new ArrayList<SelectOnContractModel>();
			while (rs.next()) {
				SelectOnContractModel s = new SelectOnContractModel();
				s.setCarName(rs.getString(1));
				s.setName(rs.getString(2));
				s.setLicense(rs.getString(3));
				s.setDate(rs.getDate(4));
				s.setRent(rs.getInt(5));
				list.add(s);
			}
		}
		connection.close();
		return list;
	}
	@Override
	public int exist_carId_in_contract(int carID) throws Exception {
		int exist = 0;
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select * from t_contract where t_contract.carID " + " = " + carID ;
			ResultSet i = connection.createStatement().executeQuery(sql);
			if(i.next()){
				exist = 1;
			}
			connection.close();
			return exist;
		} else {
			connection.close();
			return 0;
		}
	}

	@Override
	public void delContract(Contract contract) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {

//			String sql = "delete from t_contract(carID,name,license,time,rent,userID) values(?,?,?,?,?,?)";
//			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//			preparedStatement.setInt(1, contract.getCarID());
//			preparedStatement.setString(2, contract.getName());
//			preparedStatement.setString(3, contract.getLicense());
//			preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
//			preparedStatement.setDouble(5, contract.getRent());
//			preparedStatement.setInt(6, contract.getUserID());
//			preparedStatement.executeUpdate();
		}
	}

	@Override
	public List queryByLicense(String license) throws Exception {
		
		return null;
	}
}
