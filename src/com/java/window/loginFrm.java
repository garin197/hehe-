package com.java.window;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import com.java.window.Main;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.java.dao.LoginDao;

public class loginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField tf_userlogin;
	private JPasswordField tf_passwordlogin;
	private JPanel panel;
	private JLabel lb_username;
	private JLabel lb_password;
	private JButton btn_confirm;
	private JButton btn_close;
	private JButton btn_youkelogin;
	private int flag = 1;
	private static boolean haslogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrm frame = new loginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginFrm(boolean haslogin) {
		this();
		this.haslogin=haslogin;
	}
	public loginFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Garin\\Desktop\\hehe\u79DF\u8F66\\image\\app\\car_48px_1132259_easyicon.net.ico"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 257);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 432, 218);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lb_username = new JLabel("\u7528\u6237\u540D\uFF1A");
		lb_username.setFont(new Font("宋体", Font.BOLD, 14));
		lb_username.setBounds(101, 57, 60, 15);
		panel.add(lb_username);
		
		lb_password = new JLabel("\u5BC6\u7801\uFF1A");
		lb_password.setFont(new Font("宋体", Font.BOLD, 14));
		lb_password.setToolTipText("");
		lb_password.setBounds(107, 100, 54, 15);
		panel.add(lb_password);
		
		tf_userlogin = new JTextField();
		tf_userlogin.setToolTipText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		tf_userlogin.setBounds(171, 54, 178, 21);
		panel.add(tf_userlogin);
		tf_userlogin.setColumns(10);
		
		tf_passwordlogin = new JPasswordField();
		tf_passwordlogin.setToolTipText("\u8BF7\u8F93\u5165\u5BC6\u7801");
		tf_passwordlogin.setBounds(171, 97, 178, 21);
		panel.add(tf_passwordlogin);
		tf_passwordlogin.setColumns(10);
		
		btn_confirm = new JButton("\u786E\u8BA4");
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_confrimActionPerformed(e);
			}
		});
		btn_confirm.setBounds(52, 165, 93, 23);
		panel.add(btn_confirm);
		
		btn_close = new JButton("\u53D6\u6D88");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_closeActionPerformed(e);
			}
		});
		btn_close.setBounds(296, 165, 93, 23);
		panel.add(btn_close);
		
		btn_youkelogin = new JButton("\u6E38\u5BA2\u767B\u5F55");
		btn_youkelogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 0;
				Main main = new Main();
				main.visterlogin(flag);
				dispose();
			}
		});
		btn_youkelogin.setBounds(171, 165, 93, 23);
		panel.add(btn_youkelogin);
		this.setLocationRelativeTo(null);
	}

	protected void btn_closeActionPerformed(ActionEvent e) {
		this.dispose();
		
	}

	protected void btn_confrimActionPerformed(ActionEvent e) {
		String user = tf_userlogin.getText(); // 获得用户名
		String pass = tf_passwordlogin.getText(); // 获得密码
		String username = new String();
		

		// 未输入用户名
		if (user.equals("")) {
			JOptionPane.showMessageDialog(this, "用户名不允许为空！");
			return;
		}
		
		try {
			// 在数据库中查询
			String sqlStr = "select * from t_login where userName=" + "'" + user
					+ "' and userPassword=" + "'" + pass + "'";
			ResultSet result = LoginDao.executeQuery(sqlStr);
			if (result.next()) {
				username = result.getString("userName");
				LoginDao.close();
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码不正确!");
				LoginDao.close();
				return;
			}



			// 进入主界面
			
			Main main = new Main();
			main.visterlogin(flag);
			main.lbl_relogin1.setVisible(false);
			main.lbl_relogin2.setVisible(false);
			this.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
