package com.java.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.CarDAO;
import com.java.dao.LoginDao;
import com.java.util.DatabaseManagerCtrl;
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
	public boolean update(Car car) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		boolean flag = false;// 成功标记
		if (connection != null) {
			String sql = "update t_car set carName=?,brank=?,type=?,carInfo=?,number=? ,rent =? where carID=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getCarName());
			preparedStatement.setString(2, car.getBrank());
			preparedStatement.setString(3, car.getType());
			preparedStatement.setString(4, car.getCarInfo());
			preparedStatement.setInt(5, car.getNumber());
			preparedStatement.setInt(6, (int) car.getRent());
			preparedStatement.setInt(7, car.getCarID());
			preparedStatement.executeUpdate();
			flag = true;
			connection.close();
		}
		return flag;
	}

	// 执行数据库更新操作

	@Override
	public int delete(int carID) throws Exception {

		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "delete  from t_car where t_car.carID " + " = " + carID;
			return connection.createStatement().executeUpdate(sql);
		}else
		return 0;
	}

	public int insert(String sql) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			PreparedStatement rPreparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			return rPreparedStatement.executeUpdate();
		}
		connection.close();
		return 0;
	}

	public List selectCarList(String sql) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		List list = new ArrayList();
		ResultSet result = LoginDao.executeQuery(sql);
		try {
			while (result.next()) {
				Car car = new Car();
				car.setCarID(result.getInt("carID"));
				car.setRent(result.getDouble("rent"));
				car.setCarName(result.getString("carName"));
				car.setBrank(result.getString("brank"));
				car.setType(result.getString("type"));
				car.setCarInfo(result.getString("carInfo"));
				car.setNumber(result.getInt("number"));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
		return list;
	}
	public Car selectCar(String sql) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		ResultSet result = LoginDao.executeQuery(sql);
		Car car = null;
		try {
			while (result.next()) {
				car = new Car();
				car.setCarID(result.getInt("carID"));
				car.setRent(result.getDouble("rent"));
				car.setCarName(result.getString("carName"));
				car.setBrank(result.getString("brank"));
				car.setType(result.getString("type"));
				car.setCarInfo(result.getString("carInfo"));
				car.setNumber(result.getInt("number"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
		return car;
	}

	@Override
	public List queryByKey(String key1, String key2) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		List<Car> list = null;
		if (connection != null) {
			String sql = "select * from t_car where brank=? and type=?";
			PreparedStatement rPreparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			rPreparedStatement.setString(1, key1);
			rPreparedStatement.setString(2, key2);
//			rPreparedStatement.setString(3, key);
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

}
