package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ⹤����
 * @author Garin
 *
 */
public class DBUtil {
	/**
	 * ���ӵ�  ָ���� Mysql ���ݿ�
	 * @param db_userName
	 * @param db_userPassword
	 * @param Url
	 * @return connection ����
	 * @throws Exception
	 * @author Garin
	 */
	public static Connection getConnection(String db_userName,String db_userPassword,String Url) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(Url, db_userName, db_userPassword);
		return connection;
	}
	/**
	 * �ر� mysql ���ݿ�����
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
