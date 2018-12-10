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
	
	public static final String LOG_TITLE="HeHe�⳵";
	public static final int WINDOW_WIDTH=430;
	public static final int WINDOW_HEIGHT=330;
	Point pressedPoint;
	CreatePanel createPanel = new CreatePanel();
	static Login login;
	
	
	public Login(){
		
		this.setTitle(LOG_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLocationRelativeTo(null);
 
		this.setUndecorated(true);   //����frame�߿򲻿ɼ�   
		this.setResizable(false);    //��ֹ�ı䴰�ڴ�С
 
		BorderLayout border_layout=new BorderLayout();
		this.setLayout(border_layout);
 
		/**
		 * �������
		 */
		JPanel panel_north=createPanel.CreateNorthPanel();
		this.add(panel_north,BorderLayout.NORTH);
 
		/**
		 * �в����
		 */
		JPanel panel_center=createPanel.CrateCenterPanel();
		this.add(panel_center,BorderLayout.CENTER);
 
 
		/**
		 * �ϲ����
		 */
		JPanel panel_south=createPanel.CreateSouthPanel();
		this.add(panel_south,BorderLayout.SOUTH);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		/**
		 * ��������ƶ��¼�
		 */
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { //��갴���¼�
				pressedPoint = e.getPoint(); //��¼�������
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { // �����ק�¼�
				Point point = e.getPoint();// ��ȡ��ǰ����
				Point locationPoint = getLocation();// ��ȡ��������
				int x = locationPoint.x + point.x - pressedPoint.x;// �����ƶ����������
				int y = locationPoint.y + point.y - pressedPoint.y;
				setLocation(x, y);// �ı䴰��λ��
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
