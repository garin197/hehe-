package com.java.util;

import java.sql.Connection;

public class DBINFO {
	public final static String DBNAME = "db_heherentcar";
	public final static String DRIVER = "com.mysql.jdbc.Driver"; // 数据库驱动
	public final static String DBURL = "jdbc:mysql://localhost:3306/" + DBNAME + "?useSSL=true&characterEncoding=utf-8"; // 连接url
	public final static String DBUSER = "root"; // 数据库用户名
	public final static String DBPWD = "root"; // 数据库密码
}
