package com.java.util;

import java.sql.Connection;

public class DBINFO {
	public final static String DBNAME = "db_heherentcar";
	public final static String DRIVER = "com.mysql.jdbc.Driver"; // ���ݿ�����
	public final static String DBURL = "jdbc:mysql://localhost:3306/" + DBNAME + "?useSSL=true&characterEncoding=utf-8"; // ����url
	public final static String DBUSER = "root"; // ���ݿ��û���
	public final static String DBPWD = "root"; // ���ݿ�����
}
