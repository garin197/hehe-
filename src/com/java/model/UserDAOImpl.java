package com.java.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.java.dao.UserDAO;
import com.java.util.DatabaseManagerCtrl;
import com.java.util.stringUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class UserDAOImpl implements UserDAO {
	private List list = null;
	private Connection connection = null;

	@Override
	public User queryByKeyword(String key) throws Exception {
		User user = null;
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select * from t_users where phone=? or IDCard=?";
			PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, key);
			pStatement.setString(2, key);
			ResultSet result = pStatement.executeQuery();
			while (result.next()) {
				user = new User();
				user.setUserID(result.getInt(1));
				user.setName(result.getString(2));
				user.setPhone(result.getString(3));
				user.setLicense(result.getString(4));
				user.setIDCard(result.getString(5));
				user.setCarID(result.getInt(6));
			}
			connection.close();
		}
		return user;
	}

	@Override
	public List queryALL() throws Exception {
		/**
		 * 查询全部用户信息
		 */
		connection = new DatabaseManagerCtrl().getConnection();
		if (connection != null) {
			String sql = "select * from t_users";
			PreparedStatement pStatement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet result = pStatement.executeQuery();
			list = new ArrayList<User>();
			while (result.next()) {
				User user = new User();
				user.setUserID(result.getInt(1));
				user.setName(result.getString(2));
				user.setPhone(result.getString(3));
				user.setLicense(result.getString(4));
				user.setIDCard(result.getString(5));
				user.setCarID(result.getInt(6));
				list.add(user);
			}
			connection.close();
		}
		return list;
	}

	@Override
	public boolean delect(User user) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		boolean flag = false;// 删除成功标记
		if (connection != null) {
			String sql = "delete from t_users where userID=? and IDCard=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sql);
			preparedStatement.setInt(1, user.getUserID());
			preparedStatement.setString(2, user.getIDCard());
			preparedStatement.executeUpdate();
			flag = true;
			connection.close();
		}
		return flag;
	}

	@Override
	public boolean insert(User user) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		boolean flag = false;// 成功标记
		if (connection != null) {
			PreparedStatement preparedStatement=null;
			if (user.getCarID()==0) {
				String sql = "insert into t_users(name,phone,license,IDCard) values(?,?,?,?)";
				preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sql);
			}else {
				String sql = "insert into t_users(name,phone,license,IDCard,carID) values(?,?,?,?,?)";
				preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sql);
				preparedStatement.setInt(5, user.getCarID());
			}
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhone());
			preparedStatement.setString(3, user.getLicense());
			preparedStatement.setString(4, user.getIDCard());
			preparedStatement.executeUpdate();
			flag = true;
			connection.close();
		}
		return flag;
	}

	@Override
	public boolean update(User user) throws Exception {
		connection = new DatabaseManagerCtrl().getConnection();
		boolean flag = false;// 成功标记
		if (connection != null) {
			String sql = "update t_users set name=?,phone=?,license=?,IDCard=?,carID=? where userID=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.clientPrepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhone());
			preparedStatement.setString(3, user.getLicense());
			preparedStatement.setString(4, user.getIDCard());
			preparedStatement.setInt(5, user.getCarID());
			preparedStatement.setInt(6, user.getUserID());
			preparedStatement.executeUpdate();
			flag = true;
			connection.close();
		}
		return flag;
	}

}
