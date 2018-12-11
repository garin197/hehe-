package com.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.util.DatabaseManagerCtrl;


public class LoginDao {


	private static Connection conn = null;

	// ���췽�����������ݿ�����
	private LoginDao() {
		try {
			if (conn == null) {
				conn = new DatabaseManagerCtrl().getConnection();
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
				new LoginDao();
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
				new LoginDao();
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
