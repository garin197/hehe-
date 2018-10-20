package com.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.model.UserLogin;
import com.mysql.jdbc.PreparedStatement;

public class userDao {
	/**
	 * 用户登录
	 * @param connection
	 * @param userLogin
	 * @author Garin
	 * @throws Exception 
	 */
	public static UserLogin Login(Connection connection,UserLogin userLogin) throws Exception {
		//从数据库中找该用户
		UserLogin resultUser=null;
		String sql = "select * from t_login where userName = ? and userPassword = ?";
		PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, userLogin.getUserName());
		preparedStatement.setString(2, userLogin.getUserPassword());
		ResultSet rSet=preparedStatement.executeQuery();
		if(rSet.next()) {
			resultUser=new UserLogin();
			resultUser.setUserName(rSet.getString("userName"));
			resultUser.setUserPassword(rSet.getString("userPassword"));
		}
		return resultUser;
	}
}
