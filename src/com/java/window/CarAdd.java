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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class CarAdd extends JFrame {

	private JPanel dialogPane;
	private JPanel panel_content;
	private JPanel btn_bar;
	private JLabel lb_car_id;
	private JLabel lb_car_site;
	private JLabel lb_car_condition;
	private JLabel lb_car_rent;
	private JLabel lb_car_deposit;
	private JLabel lb_car_name;
	private JTextField tf_car_name;
	private JTextField tf_car_id;
	private JTextField tf_car_deposit;
	private JTextField tf_car_rent;
	private JComboBox cb_car_site;
	private JComboBox cb_car_condition;
	private JButton  btn_save;
	private JButton  btn_close;
	
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
		lb_car_name.setBounds(15, 30, 80, 18);
		panel_content.add(lb_car_name);
		lb_car_name.setFont(new Font("宋体", Font.BOLD, 15));
		lb_car_name.setHorizontalAlignment(SwingConstants.LEFT);
		
		tf_car_name = new JTextField();
		tf_car_name.setBounds(100, 27, 96, 24);
		panel_content.add(tf_car_name);
		tf_car_name.setHorizontalAlignment(SwingConstants.LEFT);
		tf_car_name.setFont(new Font("宋体", Font.BOLD, 15));
		tf_car_name.setColumns(10);
		
		cb_car_condition = new JComboBox();
		cb_car_condition.setBounds(100, 97, 96, 24);
		panel_content.add(cb_car_condition);
		
		tf_car_rent = new JTextField();
		tf_car_rent.setBounds(312, 170, 96, 24);
		panel_content.add(tf_car_rent);
		tf_car_rent.setColumns(10);
		
		lb_car_rent = new JLabel("\u79DF\u91D1\uFF1A");
		lb_car_rent.setBounds(240, 172, 48, 18);
		panel_content.add(lb_car_rent);
		lb_car_rent.setFont(new Font("宋体", Font.BOLD, 15));
		lb_car_rent.setHorizontalAlignment(SwingConstants.LEFT);
		
		tf_car_deposit = new JTextField();
		tf_car_deposit.setBounds(100, 170, 95, 24);
		panel_content.add(tf_car_deposit);
		tf_car_deposit.setColumns(10);
		
		lb_car_deposit = new JLabel("\u62BC\u91D1\uFF1A");
		lb_car_deposit.setBounds(15, 172, 48, 18);
		panel_content.add(lb_car_deposit);
		lb_car_deposit.setFont(new Font("宋体", Font.BOLD, 15));
		lb_car_deposit.setHorizontalAlignment(SwingConstants.LEFT);
		
		lb_car_condition = new JLabel("\u8F66\u8F86\u72B6\u51B5\uFF1A");
		lb_car_condition.setBounds(15, 101, 80, 18);
		panel_content.add(lb_car_condition);
		lb_car_condition.setHorizontalAlignment(SwingConstants.LEFT);
		lb_car_condition.setFont(new Font("宋体", Font.BOLD, 15));
		
		cb_car_site = new JComboBox();
		cb_car_site.setBounds(312, 97, 96, 24);
		panel_content.add(cb_car_site);
		
		lb_car_site = new JLabel("\u5EA7\u4F4D\u6570\uFF1A");
		lb_car_site.setBounds(238, 101, 64, 18);
		panel_content.add(lb_car_site);
		lb_car_site.setFont(new Font("宋体", Font.BOLD, 15));
		lb_car_site.setHorizontalAlignment(SwingConstants.LEFT);
		
		tf_car_id = new JTextField();
		tf_car_id.setBounds(312, 27, 96, 24);
		panel_content.add(tf_car_id);
		tf_car_id.setHorizontalAlignment(SwingConstants.LEFT);
		tf_car_id.setFont(new Font("宋体", Font.BOLD, 15));
		tf_car_id.setColumns(10);
		
		lb_car_id = new JLabel("\u8F66\u8F86ID\uFF1A");
		lb_car_id.setBounds(236, 30, 66, 18);
		panel_content.add(lb_car_id);
		lb_car_id.setHorizontalAlignment(SwingConstants.LEFT);
		lb_car_id.setFont(new Font("宋体", Font.BOLD, 15));
		
		btn_bar  = new JPanel();
		dialogPane.add(btn_bar, BorderLayout.SOUTH);
		GridBagLayout gbl_btn_bar = new GridBagLayout();
		gbl_btn_bar.columnWidths = new int[]{138, 97, 65, 0, 0, 0, 0, 0};
		gbl_btn_bar.rowHeights = new int[]{27, 0};
		gbl_btn_bar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_btn_bar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		btn_bar.setLayout(gbl_btn_bar);
		
		btn_save = new JButton("\u786E\u8BA4\u4FDD\u5B58");
		GridBagConstraints gbc_btn_save = new GridBagConstraints();
		gbc_btn_save.anchor = GridBagConstraints.NORTHWEST;
		gbc_btn_save.insets = new Insets(0, 0, 0, 5);
		gbc_btn_save.gridx = 2;
		gbc_btn_save.gridy = 0;
		btn_bar.add(btn_save, gbc_btn_save);
		btn_save.setFont(new Font("新宋体", Font.PLAIN, 14));
		
		btn_close = new JButton("\u53D6\u6D88");
		GridBagConstraints gbc_btn_close = new GridBagConstraints();
		gbc_btn_close.anchor = GridBagConstraints.NORTHWEST;
		gbc_btn_close.gridx = 3;
		gbc_btn_close.gridy = 0;
		btn_bar.add(btn_close, gbc_btn_close);
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btn_close.setFont(new Font("新宋体", Font.PLAIN, 14));
		setSize(450, 313);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}
}
