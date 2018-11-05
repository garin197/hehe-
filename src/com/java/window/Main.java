package com.java.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JMenuBar menuBar;
	private JMenu menu_info_manage;
	private JMenu menu_rentback;
	private JMenu menu_info_query;
	private JMenu menu_client_manage;
	private JMenu menu_car_manage;
	private JMenuItem mi_car_add;
	private JMenuItem mi_car_del;
	private JMenuItem mi_car_update;
	private JMenuItem mi_client_add;
	private JMenuItem mi_client_del;
	private JMenuItem mi_client_update;
	private JMenuItem mi_car_rent;
	private JMenuItem mi_car_back;
	private JMenuItem mi_car_info;
	private JMenuItem mi_client_info;
	
	
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.setTitle("\u79DF\u8F66\u7CFB\u7EDF");
		frame.setBounds(100, 100, 479, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.WHITE);
		menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		frame.setJMenuBar(menuBar);
		
		menu_info_manage = new JMenu("\u4FE1\u606F\u7BA1\u7406");
		menu_info_manage.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuBar.add(menu_info_manage);
		
		menu_car_manage = new JMenu("\u8F66\u578B\u7BA1\u7406");
		menu_car_manage.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_manage.add(menu_car_manage);
		//车型管理
		mi_car_add = new JMenuItem("\u8F66\u578B\u589E\u52A0");
		mi_car_add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mi_car_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mi_car_addActionPerformed(e);
			}
		});
		
		menu_car_manage.add(mi_car_add);
		
		mi_car_del = new JMenuItem("\u8F66\u578B\u5220\u9664");
		mi_car_del.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_car_manage.add(mi_car_del);
		
		mi_car_update = new JMenuItem("\u8F66\u578B\u4FEE\u6539");
		mi_car_update.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_car_manage.add(mi_car_update);
		
		menu_client_manage= new JMenu("\u5BA2\u6237\u7BA1\u7406");
		menu_client_manage.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_manage.add(menu_client_manage);
		//客户管理
		mi_client_add = new JMenuItem("\u5BA2\u6237\u589E\u52A0");
		mi_client_add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_client_manage.add(mi_client_add);
		
		mi_client_del = new JMenuItem("\u5BA2\u6237\u5220\u9664");
		mi_client_del.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_client_manage.add(mi_client_del);
		
		mi_client_update = new JMenuItem("\u5BA2\u6237\u4FEE\u6539");
		mi_client_update.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_client_manage.add(mi_client_update);
		
		menu_rentback = new JMenu("\u79DF\u8FD8\u7BA1\u7406");
		menu_rentback.setHorizontalAlignment(SwingConstants.CENTER);
		menu_rentback.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuBar.add(menu_rentback);
		
		mi_car_rent = new JMenuItem("\u79DF\u8F66");
		mi_car_rent.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_rentback.add(mi_car_rent);
		
		mi_car_back= new JMenuItem("\u8FD8\u8F66");
		mi_car_back.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_rentback.add(mi_car_back);
		
		menu_info_query = new JMenu("\u4FE1\u606F\u67E5\u8BE2");
		menu_info_query.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuBar.add(menu_info_query);
		
		mi_car_info = new JMenuItem("\u8F66\u578B\u67E5\u8BE2");
		mi_car_info.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_query.add(mi_car_info);
		
		mi_client_info= new JMenuItem("\u5BA2\u6237\u67E5\u8BE2");
		mi_client_info.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_query.add(mi_client_info);
	}

	private void mi_car_addActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new CarAdd();
	}

}
