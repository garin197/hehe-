package com.java.window;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
 
 
public class Login extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String LOG_TITLE="HeHe租车";
	public static final int WINDOW_WIDTH=430;
	public static final int WINDOW_HEIGHT=330;
	Point pressedPoint;
	CreatePanel createPanel = new CreatePanel();
	static Login login;
	
	
	public Login(){
		
		this.setTitle(LOG_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLocationRelativeTo(null);
 
		this.setUndecorated(true);   //设置frame边框不可见   
		this.setResizable(false);    //禁止改变窗口大小
 
		BorderLayout border_layout=new BorderLayout();
		this.setLayout(border_layout);
 
		/**
		 * 北部面板
		 */
		JPanel panel_north=createPanel.CreateNorthPanel();
		this.add(panel_north,BorderLayout.NORTH);
 
		/**
		 * 中部面板
		 */
		JPanel panel_center=createPanel.CrateCenterPanel();
		this.add(panel_center,BorderLayout.CENTER);
 
 
		/**
		 * 南部面板
		 */
		JPanel panel_south=createPanel.CreateSouthPanel();
		this.add(panel_south,BorderLayout.SOUTH);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		/**
		 * 窗体鼠标移动事件
		 */
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { //鼠标按下事件
				pressedPoint = e.getPoint(); //记录鼠标坐标
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { // 鼠标拖拽事件
				Point point = e.getPoint();// 获取当前坐标
				Point locationPoint = getLocation();// 获取窗体坐标
				int x = locationPoint.x + point.x - pressedPoint.x;// 计算移动后的新坐标
				int y = locationPoint.y + point.y - pressedPoint.y;
				setLocation(x, y);// 改变窗体位置
			}
		});
	}
 
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 login =new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
