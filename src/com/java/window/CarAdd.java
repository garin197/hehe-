package com.java.window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.java.dao.LoginDao;
import com.java.util.Constant;

public class CarAdd extends JFrame {

	private JPanel dialogPane;
	private JPanel panel_content;
	private JPanel btn_bar;
	private JLabel lb_car_type;
	private JLabel lb_car_info;
	private JLabel lb_car_rent;
	private JLabel lb_car_name;
	private JTextField tf_car_name;
	private JTextField tf_car_rent;
	private JComboBox cb_car_type;
	private JComboBox cb_car_info;
	private JButton  btn_save;
	private JButton  btn_close;
	private JTextField tf_car_brank;
	private JTextField tf_car_number;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public CarAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dialogPane = new JPanel();
		new JPanel();
		
		setTitle("车型添加");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(dialogPane, BorderLayout.CENTER);
		dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
		dialogPane.setLayout(new BorderLayout(0, 0));
		
		panel_content = new  JPanel();
		dialogPane.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(null);
		
		lb_car_name = new JLabel("\u8F66\u8F86\u540D\u79F0\uFF1A");
		lb_car_name.setBounds(15, 44, 80, 18);
		panel_content.add(lb_car_name);
		lb_car_name.setFont(new Font("宋体", Font.BOLD, 15));
		lb_car_name.setHorizontalAlignment(SwingConstants.LEFT);
		
		tf_car_name = new JTextField();
		tf_car_name.setBounds(100, 41, 96, 24);
		panel_content.add(tf_car_name);
		tf_car_name.setHorizontalAlignment(SwingConstants.LEFT);
		tf_car_name.setFont(new Font("宋体", Font.BOLD, 15));
		tf_car_name.setColumns(10);
		
		cb_car_info = new JComboBox(Constant.CAR_INFO);
		cb_car_info.setBounds(100, 132, 96, 24);
		panel_content.add(cb_car_info);
		
		tf_car_rent = new JTextField();
		tf_car_rent.setBounds(374, 232, 95, 24);
		panel_content.add(tf_car_rent);
		tf_car_rent.setColumns(10);
		
		lb_car_rent = new JLabel("\u62BC\u91D1\uFF1A");
		lb_car_rent.setBounds(300, 234, 48, 18);
		panel_content.add(lb_car_rent);
		lb_car_rent.setFont(new Font("宋体", Font.BOLD, 15));
		lb_car_rent.setHorizontalAlignment(SwingConstants.LEFT);
		
		lb_car_info = new JLabel("\u8F66\u8F86\u4FE1\u606F\uFF1A");
		lb_car_info.setBounds(15, 135, 80, 18);
		panel_content.add(lb_car_info);
		lb_car_info.setHorizontalAlignment(SwingConstants.LEFT);
		lb_car_info.setFont(new Font("宋体", Font.BOLD, 15));
		
		cb_car_type = new JComboBox(Constant.CAR_TYPE);
		cb_car_type.setBounds(374, 132, 96, 24);
		panel_content.add(cb_car_type);
		
		lb_car_type = new JLabel("\u5EA7\u4F4D\u6570\uFF1A");
		lb_car_type.setBounds(300, 135, 64, 18);
		panel_content.add(lb_car_type);
		lb_car_type.setFont(new Font("宋体", Font.BOLD, 15));
		lb_car_type.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lb_car_brank = new JLabel("\u54C1\u724C\uFF1A");
		lb_car_brank.setFont(new Font("宋体", Font.BOLD, 14));
		lb_car_brank.setBounds(300, 46, 54, 15);
		panel_content.add(lb_car_brank);
		
		tf_car_brank = new JTextField();
		tf_car_brank.setBounds(364, 42, 96, 24);
		panel_content.add(tf_car_brank);
		tf_car_brank.setColumns(10);
		
		JLabel lb_car_number = new JLabel("\u6570\u91CF\uFF1A");
		lb_car_number.setFont(new Font("宋体", Font.BOLD, 14));
		lb_car_number.setBounds(10, 236, 54, 15);
		panel_content.add(lb_car_number);
		
		tf_car_number = new JTextField();
		tf_car_number.setBounds(100, 233, 96, 21);
		panel_content.add(tf_car_number);
		tf_car_number.setColumns(10);
		
		btn_bar  = new JPanel();
		dialogPane.add(btn_bar, BorderLayout.SOUTH);
		GridBagLayout gbl_btn_bar = new GridBagLayout();
		gbl_btn_bar.columnWidths = new int[]{138, 97, 65, 0, 0, 0, 0, 0, 0, 0};
		gbl_btn_bar.rowHeights = new int[]{27, 0};
		gbl_btn_bar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_btn_bar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		btn_bar.setLayout(gbl_btn_bar);
		
		btn_save = new JButton("\u786E\u8BA4\u4FDD\u5B58");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btn_save = new GridBagConstraints();
		gbc_btn_save.anchor = GridBagConstraints.NORTHWEST;
		gbc_btn_save.insets = new Insets(0, 0, 0, 5);
		gbc_btn_save.gridx = 5;
		gbc_btn_save.gridy = 0;
		btn_bar.add(btn_save, gbc_btn_save);
		btn_save.setFont(new Font("新宋体", Font.PLAIN, 14));
		
		btn_close = new JButton("\u53D6\u6D88");
		GridBagConstraints gbc_btn_close = new GridBagConstraints();
		gbc_btn_close.insets = new Insets(0, 0, 0, 5);
		gbc_btn_close.anchor = GridBagConstraints.NORTHWEST;
		gbc_btn_close.gridx = 7;
		gbc_btn_close.gridy = 0;
		btn_bar.add(btn_close, gbc_btn_close);
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.frame.setVisible(true);
				dispose();
			}
		});
		btn_close.setFont(new Font("新宋体", Font.PLAIN, 14));
		setSize(573, 397);
		setLocationRelativeTo(getOwner());
		
	}

	protected void btn_saveActionPerformed(ActionEvent e) {
		// 获取用户输入信息
		String carName = tf_car_name.getText();
	//	int carId = Integer.parseInt(tf_car_id.getText());
		String brank = tf_car_brank.getText();
		String type = cb_car_type.getSelectedItem().toString();
		String info = cb_car_info.getSelectedItem().toString();
		String rent = tf_car_rent.getText();
		int number = Integer.parseInt(tf_car_number.getText());
		
		String sql = "insert into t_car(rent,carName,brank,type,carInfo,number) values('"
				+ rent
				+ "','"
				+ carName
				+ "','"
				+ brank
				+ "','"
				+ type
				+ "','"
				+ info
				+ "','"
				+ number
				+  "')";
	
			int i =LoginDao.executeUpdate(sql);
		
		if (i ==1 ) {
			JOptionPane.showMessageDialog(null, "添加成功");
			dispose();
			Main.frame.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "添加失败");
		}
		
	}
}
