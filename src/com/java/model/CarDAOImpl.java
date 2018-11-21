package com.java.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.CarDAO;
import com.java.util.DatabaseManagerCtrl;
import com.java.util.stringUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CarDAOImpl implements CarDAO {
	Connection connection = null;
	List list = null;

	@Override
	public List getCarInfo() throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select carInfo from t_car group by carInfo";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			list = new ArrayList<String>();
			while (resultSet.next()) {
				String string = resultSet.getString(1);
				list.add(string);
			}
		}
		connection.close();
		return list;
	}

	@Override
	public List getCarBrankList() throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select brank from t_car group by brank";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			list = new ArrayList<String>();
			while (resultSet.next()) {
				String string = resultSet.getString(1);
				list.add(string);
			}
		}
		connection.close();
		return list;
	}

	@Override
	public List getCarTypeList() throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select type from t_car group by type";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			list = new ArrayList<String>();
			while (resultSet.next()) {
				String string = resultSet.getString(1);
				list.add(string);
			}
		}
		connection.close();
		return list;
	}

	@Override
	public List queryALL() throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select * from t_car";
			PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet result = pStatement.executeQuery();
			list = new ArrayList<Car>();
			while (result.next()) {
				Car car = new Car();
				car.setCarID(result.getInt(1));
				car.setRent(result.getDouble(2));
				car.setCarName(result.getString(3));
				car.setBrank(result.getString(4));
				car.setType(result.getString(5));
				car.setCarInfo(result.getString(6));
				car.setNumber(result.getInt(7));
				list.add(car);
			}
			connection.close();
		}
		return list;
	}

	@Override
	public List queryByKey(String key) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		List<Car> list = null;
		if (connection != null) {
			String sql = "select * from t_car where brank=? or type=? or carInfo=?";
			PreparedStatement rPreparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			rPreparedStatement.setString(1, key);
			rPreparedStatement.setString(2, key);
			rPreparedStatement.setString(3, key);
			ResultSet result = rPreparedStatement.executeQuery();
			list = new ArrayList<>();
			while (result.next()) {
				Car car = new Car();
				car.setCarID(result.getInt(1));
				car.setRent(result.getDouble(2));
				car.setCarName(result.getString(3));
				car.setBrank(result.getString(4));
				car.setType(result.getString(5));
				car.setCarInfo(result.getString(6));
				car.setNumber(result.getInt(7));
				list.add(car);
			}
		}
		connection.close();
		return list;
	}

	@Override
	public void update(Car car) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "update t_car set number=? where carID=?";
			PreparedStatement rPreparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			rPreparedStatement.setInt(1, car.getNumber()-1);
			rPreparedStatement.setInt(2, car.getCarID());
			rPreparedStatement.executeUpdate();
		}
		connection.close();
	}
	
	
}
