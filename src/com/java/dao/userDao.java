package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class userDao {
	
	
	protected static String driver = "com.mysql.jdbc.Driver"; // 数据库驱动

	protected static String url = "jdbc:mysql://127.0.0.1:3306/db_heherentcar?characterEncoding=utf-8"; // 连接url

	protected static String dbUser = "root"; // 数据库用户名

	protected static String dbPwd = "root"; // 数据库密码

	private static Connection conn = null;

	// 构造方法，创建数据库连接
	private userDao() {
		try {
			if (conn == null) {
				Class.forName(driver); // 加载数据库驱动
				conn = DriverManager.getConnection(url, dbUser, dbPwd); // 建立数据库连接
				System.out.println("连接成功！！！！！！！！！！！");
			} else
				System.out.println("连接失败！！！！！！！！！！！");
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	// 执行数据库查询操作
	public static ResultSet executeQuery(String sql) {
		try {
			if (conn == null)
				new userDao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql); // 执行数据库查询
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 执行数据库更新操作
	public static int executeUpdate(String sql) {

		try {
			if (conn == null)
				new userDao();
			return conn.createStatement().executeUpdate(sql); // 执行数据库更新
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} finally {
		}
	}

	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
//	/**
//	 * 用户登录
//	 * @param connection
//	 * @param userLogin
//	 * @author Garin
//	 * @throws Exception 
//	 */
//	public static UserLogin Login(Connection connection,UserLogin userLogin) throws Exception {
//		//从数据库中找该用户
//		UserLogin resultUser=null;
//		String sql = "select * from t_login where userName = ? and userPassword = ?";
//		PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
//		preparedStatement.setString(1, userLogin.getUserName());
//		preparedStatement.setString(2, userLogin.getUserPassword());
//		ResultSet rSet=preparedStatement.executeQuery();
//		if(rSet.next()) {
//			resultUser=new UserLogin();
//			resultUser.setUserName(rSet.getString("userName"));
//			resultUser.setUserPassword(rSet.getString("userPassword"));
//		}
//		return resultUser;
//	}
