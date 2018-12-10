package com.java.window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.*;

import com.java.dao.LoginDao;
import com.java.mainView.MainView;

public class CreatePanel extends JFrame {
	public CreatePanel() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WINDOW_WIDTH = 430;
	public static final int WINDOW_HEIGHT = 330;

	private JTextField tfusername;
	private JPasswordField pfpassword;
	private JLabel lbuser;
	private JLabel lbpassword;
	private JButton btnlogin;
	private JButton btntrlogin;
	private int flag = 1;

	/**
	 * 创建北部面板
	 * 
	 * @return
	 */
	public JPanel CreateNorthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(430, 180));
		// 图片大小440x210
		ImageIcon image = new ImageIcon("src/newImages/login-north.jpg");

		// 添加退出按钮
		JButton close = new JButton("✖");
		close.setContentAreaFilled(false); // 设置按钮透明
		close.setBounds(380, 0, 50, 50);
		close.setForeground(Color.white);
		close.setBorderPainted(false);
		close.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				close.setContentAreaFilled(true);
				close.setBackground(Color.red);
			}
		});
		close.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				close.setContentAreaFilled(false);

			}
		});
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
//		//添加最小化按钮
//		JButton small=new JButton("——");
//		small.setContentAreaFilled(false);  //设置按钮透明		
//		small.setBounds(370,0,30,30);
//		small.setForeground(Color.white);
//		small.addActionListener(new ActionListener() {		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//			}
//		});

		JLabel background = new JLabel(image);
		background.setBounds(0, 0, 430, 180);

		panel.add(close);
//		panel.add(small);
		panel.add(background);

		return panel;
	}

	/**
	 * 创建南部面板
	 */
	public JPanel CreateSouthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(420, 50));

		MyLineBorder myLineBorder = new MyLineBorder(new Color(192, 192, 192), 1, true);

		/**
		 * 用户名密码登录
		 */
		ImageIcon imglogin = new ImageIcon("src/newImages/LoginButton.jpg");
		btnlogin = new JButton();
		btnlogin.setBounds(80, 0, 120, 30);
		btnlogin.setBorder(myLineBorder);
		Image temp = imglogin.getImage().getScaledInstance(btnlogin.getWidth(), btnlogin.getHeight(),
				imglogin.getImage().SCALE_DEFAULT);
		imglogin = new ImageIcon(temp);
		btnlogin.setIcon(imglogin);
		// 添加适配器  
		btnlogin.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				ImageIcon in = new ImageIcon("src/newImages/LoginButtonOn.jpg");
				Image b = in.getImage().getScaledInstance(btnlogin.getWidth(), btnlogin.getHeight(),
						in.getImage().SCALE_DEFAULT);
				in = new ImageIcon(b);
				btnlogin.setIcon(in);
			}

			public void mouseExited(MouseEvent e) {
				ImageIcon out = new ImageIcon("src/newImages/LoginButton.jpg");
				Image b = out.getImage().getScaledInstance(btnlogin.getWidth(), btnlogin.getHeight(),
						out.getImage().SCALE_DEFAULT);
				out = new ImageIcon(b);
				btnlogin.setIcon(out);
			}
		});
		// 添加监听
		btnlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				btnlogin_ActionPerformed(e);
			}
		});

		/**
		 * 游客登录
		 */
		ImageIcon imgtrlogin = new ImageIcon("src/newImages/trLoginButton.jpg");
		btntrlogin = new JButton();
		btntrlogin.setBounds(230, 0, 120, 30);
		btntrlogin.setBorder(myLineBorder);
		Image temp1 = imgtrlogin.getImage().getScaledInstance(btntrlogin.getWidth(), btntrlogin.getHeight(),
				imgtrlogin.getImage().SCALE_DEFAULT);
		imgtrlogin = new ImageIcon(temp1);
		btntrlogin.setIcon(imgtrlogin);
		// 添加适配器
		btntrlogin.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				ImageIcon in = new ImageIcon("src/newImages/trLoginButtonOn.jpg");
				Image b = in.getImage().getScaledInstance(btnlogin.getWidth(), btnlogin.getHeight(),
						in.getImage().SCALE_DEFAULT);
				in = new ImageIcon(b);
				btntrlogin.setIcon(in);
			}

			public void mouseExited(MouseEvent e) {
				ImageIcon out = new ImageIcon("src/newImages/trLoginButton.jpg");
				Image b = out.getImage().getScaledInstance(btnlogin.getWidth(), btnlogin.getHeight(),
						out.getImage().SCALE_DEFAULT);
				out = new ImageIcon(b);
				btntrlogin.setIcon(out);
			}
		});
		//添加监听
		btntrlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					btntrlogin_ActionPerformed(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnlogin);
		panel.add(btntrlogin);
		return panel;

	}

	protected void btntrlogin_ActionPerformed(ActionEvent e) throws Exception {
		// TODO 自动生成的方法存根
		flag = 0;
		MainView mainview = new MainView();
		mainview.visterlogin(flag);
		dispose();
	}

	protected void btnlogin_ActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String user = tfusername.getText(); // 获得用户名
		String pass = pfpassword.getText(); // 获得密码
		String username = new String();

		// 未输入用户名
		if (user.equals("")) {
			JOptionPane.showMessageDialog(null, "用户名不允许为空！");
			return;
		}

		try {
			// 在数据库中查询
			String sqlStr = "select * from t_login where userName=" + "'" + user + "' and userPassword=" + "'" + pass
					+ "'";
			ResultSet result = LoginDao.executeQuery(sqlStr);
			if (result.next()) {
				username = result.getString("userName");
				LoginDao.close();
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码不正确!");
				LoginDao.close();
				return;
			}

			// 进入主界面

			MainView mainview = new MainView();
			mainview.visterlogin(flag);
//			mainview.lbl_relogin1.setVisible(false);
//			mainview.lbl_relogin2.setVisible(false);
			Login.login.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 创建中部面板
	 */
	public JPanel CrateCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(420, 150));
		MyLineBorder myLineBorder = new MyLineBorder(new Color(192, 192, 192), 1, true);

		/**
		 * 用户名、密码标签
		 */
		lbuser = new JLabel("用 户 名");
		lbpassword = new JLabel("密  码:");
		lbuser.setBounds(80, 20, 80, 20);
		lbuser.setForeground(new Color(0,0,0));
		lbuser.setFont(new Font("微软雅黑",0,16));
		lbpassword.setBounds(80, 50, 60, 20);
		lbpassword.setForeground(new Color(0,0,0));
		lbpassword.setFont(new Font("微软雅黑",0,16));
		/**
		 * 用户名、密码输入框
		 */
		tfusername = new JTextField();
		tfusername.setBounds(150, 15, 175, 25);
		tfusername.setBorder(myLineBorder);
		
		pfpassword = new JPasswordField();
		pfpassword.setBounds(150, 50, 175, 25);
		pfpassword.setBorder(myLineBorder);

		panel.add(tfusername);
		panel.add(pfpassword);
		panel.add(lbuser);
		panel.add(lbpassword);
		return panel;
	}

}
