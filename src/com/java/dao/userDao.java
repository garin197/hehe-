package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class userDao {
	
	
	protected static String driver = "com.mysql.jdbc.Driver"; // ���ݿ�����

	protected static String url = "jdbc:mysql://127.0.0.1:3306/db_heherentcar?characterEncoding=utf-8"; // ����url

	protected static String dbUser = "root"; // ���ݿ��û���

	protected static String dbPwd = "root"; // ���ݿ�����

	private static Connection conn = null;

	// ���췽�����������ݿ�����
	private userDao() {
		try {
			if (conn == null) {
				Class.forName(driver); // �������ݿ�����
				conn = DriverManager.getConnection(url, dbUser, dbPwd); // �������ݿ�����
				System.out.println("���ӳɹ�����������������������");
			} else
				System.out.println("����ʧ�ܣ���������������������");
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	// ִ�����ݿ��ѯ����
	public static ResultSet executeQuery(String sql) {
		try {
			if (conn == null)
				new userDao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql); // ִ�����ݿ��ѯ
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ִ�����ݿ���²���
	public static int executeUpdate(String sql) {

		try {
			if (conn == null)
				new userDao();
			return conn.createStatement().executeUpdate(sql); // ִ�����ݿ����
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
//	 * �û���¼
//	 * @param connection
//	 * @param userLogin
//	 * @author Garin
//	 * @throws Exception 
//	 */
//	public static UserLogin Login(Connection connection,UserLogin userLogin) throws Exception {
//		//�����ݿ����Ҹ��û�
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
