package com.java.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseManagerCtrl {
	private Connection connection=null;
	public Connection getConnection() throws Exception {
		Class.forName(DBINFO.DRIVER); // �������ݿ�����
		connection = (Connection) DriverManager.getConnection(DBINFO.DBURL, DBINFO.DBUSER, DBINFO.DBPWD);
		return connection;
	}
}
