package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author Garin
 *
 */
public class DBUtil {
	/**
	 * 连接到  指定的 Mysql 数据库
	 * @param db_userName
	 * @param db_userPassword
	 * @param Url
	 * @return connection 对象
	 * @throws Exception
	 * @author Garin
	 */
	public static Connection getConnection(String db_userName,String db_userPassword,String Url) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(Url, db_userName, db_userPassword);
		return connection;
	}
	/**
	 * 关闭 mysql 数据库连接
	 * @param connection
	 * @throws Exception
	 * @author Garin
	 */
	public static void closeDBConnection(Connection connection) throws Exception {
		if (connection!=null) {
			connection.close();
		}
	}
	
}
