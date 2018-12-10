package com.java.mainView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.window.CarAdd;
import com.java.window.CarBack;
import com.java.window.CarDelete;
import com.java.window.CarQuery;
import com.java.window.CarUpdate;
import com.java.window.Main;
import com.java.window.ManageRent;
import com.java.window.ManageUser;

import javax.swing.border.EmptyBorder;

public class MainView extends JFrame implements InputMethodListener, MouseListener {

	Point pressedPoint;
	private Container conPanel;
	// 面板类
	private CustSkinPanel southPanel,  headerPanel1, headerPanel2, leftPanel, rightPanel;
	private JPanel nouthPanel;
	// 右上角关闭最小化按钮
	private ImageIcon sysMinIcon, sysMinIcon2, sysCloseIcon, sysCloseIcon2;
	private JLabel sysMinLabel, sysCloseLabel;
	// 总菜单
	private ImageIcon topMenuMesgMngIcon, topMenuMesgMngIcon2, topMenuRentMngIcon, topMenuRentMngIcon2,
	topMenuMesgRscIcon, topMenuMesgRscIcon2;
	private JLabel topMenuMesgMngLabel, topMenuRentMngLabel, topMenuMesgRscLabel;
	//左侧菜单
	private ImageIcon leftCarMngIcon, leftClientMngIcon,leftCarAddIcon,leftCarAddIcon2,leftCarDeleteIcon,
						leftCarDeleteIcon2,leftCarNotifyIcon,leftCarNotifyIcon2,
						leftClientAddIcon,leftClientAddIcon2,leftClientDeleteIcon,
						leftClientDeleteIcon2,leftClientNotifyIcon,leftClientNotifyIcon2,
						leftRentCarIcon,leftRentCarIcon2,leftReturnCarIcon,leftReturnCarIcon2,
						leftCarRscIcon,leftCarRscIcon2,leftClientRscIcon,leftClientRscIcon2,
						leftAllRscIcon,leftAllRscIcon2;
	private JPanel leftMesgMngPanel,leftMescRscPanel,leftRentMngPanel;
	private JLabel leftCarMngLabel, leftCarAddLabel,leftCarDeleteLabel,leftCarNotifyLabel,
					leftClientMngLabel,leftClientAddLabel,leftClientDeleteLabel,leftClientNotifyLabel,
					leftRentCarLabel,leftReturnCarLabel,
					leftCarRscLabel,leftClientRscLabel,leftAllRscLabel;
	private CarAdd carAdd;
	private CarDelete carDelete;
	private CarUpdate carUpdate;
	private CarQuery carQuery;
	private CarBack carBack;
	private ManageUser manageCar = null;
	private ManageUser manageUser = null;
	private ManageRent manageRent=null;
	
	public MainView() throws Exception {
		init();
		buildElems();
		fitTogether();
	}

	/**
	 * 初始化窗口
	 */
	private void init() {
		// TODO 自动生成的方法存根
		this.setTitle("Hehe 租车");
		this.setSize(885, 560);
		this.setIconImage(ViewToolkit.createImageIcon("app图标.png").getImage());
		this.setLocationRelativeTo(null);// 屏幕中央
		this.setUndecorated(true);// 启动此窗口的装饰
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		/**
		 * 窗体鼠标移动事件
		 */
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { // 鼠标按下事件
				pressedPoint = e.getPoint(); // 记录鼠标坐标
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

	/**
	 * 构建窗口元素
	 * @throws Exception 
	 */
	public void buildElems() throws Exception {
		/**
		 * 面板初始化
		 */
		conPanel = this.getContentPane();
		conPanel.setLayout(new BorderLayout(0, 0));
		
		carAdd = new CarAdd();
		carDelete = new CarDelete();
		carUpdate = new CarUpdate();
		carQuery  = new CarQuery();
		carBack = new CarBack();
		
		nouthPanel = new JPanel();
		nouthPanel.setPreferredSize(new Dimension(885, 65));
		nouthPanel.setLayout(new BorderLayout());

		headerPanel1 = new CustSkinPanel("/newImages/header_1.jpg", 885, 18);
		headerPanel1.setPreferredSize(new Dimension(885, 18));
		headerPanel1.setLayout(new FlowLayout(2, 0, 0));

		headerPanel2 = new CustSkinPanel("/newImages/header_2.jpg", 885, 47);
		headerPanel2.setPreferredSize(new Dimension(885, 47));
		headerPanel2.setLayout(new FlowLayout(0, 0, 0));

		southPanel = new CustSkinPanel("/newImages/footer.jpg", 885, 60);
		southPanel.setPreferredSize(new Dimension(885, 60));
		southPanel.setLayout(new FlowLayout(2, 1, 0));

		leftPanel = new CustSkinPanel("/newImages/main_left.png", 140, 475);
		leftPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		leftPanel.setLayout(new FlowLayout(0, 0, 0));
		leftPanel.setPreferredSize(new Dimension(140, 475));

		leftMesgMngPanel = new CustSkinPanel("/newImages/main_left.png", 140, 475);
		leftMesgMngPanel.setLayout(new FlowLayout(0, 0, 0));
		leftMesgMngPanel.setPreferredSize(new Dimension(140, 475));
		
		leftRentMngPanel = new CustSkinPanel("/newImages/main_left.png", 140, 475);
		leftRentMngPanel.setLayout(new FlowLayout(0, 0, 0));
		leftRentMngPanel.setPreferredSize(new Dimension(140, 475));

		leftMescRscPanel = new CustSkinPanel("/newImages/main_left.png", 140, 475);
		leftMescRscPanel.setLayout(new FlowLayout(0, 0, 0));
		leftMescRscPanel.setPreferredSize(new Dimension(140, 475));
		
		rightPanel = new CustSkinPanel(null, 740, 475);
		rightPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		rightPanel.setLayout(new FlowLayout(0, 0, 0));
		rightPanel.setPreferredSize(new Dimension(740, 475));
		
		/**
		 * 图标初始化
		 */
		//最小化关闭图标
		sysMinIcon = ViewToolkit.createImageIcon("min_btn.png");
		sysMinIcon2 = ViewToolkit.createImageIcon("min_btn2.png");
		sysCloseIcon = ViewToolkit.createImageIcon("close_btn.png");
		sysCloseIcon2 = ViewToolkit.createImageIcon("close_btn2.png");
		
		//top图标
		topMenuMesgMngIcon = ViewToolkit.createImageIcon("topMenuMesgMng.jpg");
		topMenuMesgMngIcon2 = ViewToolkit.createImageIcon("topMenuMesgMng2.jpg");

		topMenuRentMngIcon = ViewToolkit.createImageIcon("topMenuRentMng.jpg");
		topMenuRentMngIcon2 = ViewToolkit.createImageIcon("topMenuRentMng2.jpg");

		topMenuMesgRscIcon = ViewToolkit.createImageIcon("topMenuMesgRsc.jpg");
		topMenuMesgRscIcon2 = ViewToolkit.createImageIcon("topMenuMesgRsc2.jpg");
		
		//车型管理图标
		leftCarMngIcon = ViewToolkit.createImageIcon("leftCarMng.jpg");
//		leftCarMngIcon2 = ViewToolkit.createImageIcon("leftCarMng2.jpg");
		leftCarAddIcon = ViewToolkit.createImageIcon("leftCarAdd.jpg");
		leftCarAddIcon2 = ViewToolkit.createImageIcon("leftCarAdd2.jpg");
		leftCarDeleteIcon = ViewToolkit.createImageIcon("leftCarDelete.jpg");
		leftCarDeleteIcon2 = ViewToolkit.createImageIcon("leftCarDelete2.jpg");
		leftCarNotifyIcon = ViewToolkit.createImageIcon("leftCarNotify.jpg");
		leftCarNotifyIcon2 = ViewToolkit.createImageIcon("leftCarNotify2.jpg");
		
		//客户管理图标
		leftClientMngIcon = ViewToolkit.createImageIcon("leftClientMng.jpg");
//		leftClientMngIcon2 = ViewToolkit.createImageIcon("leftClientMng2.jpg");
		leftClientAddIcon = ViewToolkit.createImageIcon("leftClientAdd.jpg");
		leftClientAddIcon2 = ViewToolkit.createImageIcon("leftClientAdd2.jpg");
		leftClientDeleteIcon = ViewToolkit.createImageIcon("leftClientDelete.jpg");
		leftClientDeleteIcon2 = ViewToolkit.createImageIcon("leftClientDelete2.jpg");
		leftClientNotifyIcon = ViewToolkit.createImageIcon("leftClientNotify.jpg");
		leftClientNotifyIcon2 = ViewToolkit.createImageIcon("leftClientNotify2.jpg");
		
		//还车租车图标
		leftRentCarIcon = ViewToolkit.createImageIcon("leftRentCar.jpg");
		leftRentCarIcon2 = ViewToolkit.createImageIcon("leftRentCar2.jpg");
		leftReturnCarIcon = ViewToolkit.createImageIcon("leftReturnCar.jpg");
		leftReturnCarIcon2 = ViewToolkit.createImageIcon("leftReturnCar2.jpg");
		
		//车型/客户/订单查询图标
		leftCarRscIcon = ViewToolkit.createImageIcon("leftCarRsc.jpg");
		leftCarRscIcon2 = ViewToolkit.createImageIcon("leftCarRsc2.jpg");
		leftClientRscIcon = ViewToolkit.createImageIcon("leftClientRsc.jpg");
		leftClientRscIcon2 = ViewToolkit.createImageIcon("leftClientRsc2.jpg");
		leftAllRscIcon = ViewToolkit.createImageIcon("leftAllRsc.jpg");
		leftAllRscIcon2 = ViewToolkit.createImageIcon("leftAllRsc2.jpg");
		
		/**
		 * 标签初始化
		 */
		//最小化关闭标签
		sysMinLabel = new JLabel(sysMinIcon);
		sysMinLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sysMinLabel.setToolTipText("最小化窗口");
		sysMinLabel.addMouseListener(this);

		sysCloseLabel = new JLabel(sysCloseIcon);
		sysCloseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sysCloseLabel.setToolTipText("关闭窗口");
		sysCloseLabel.addMouseListener(this);
		//信息管理	
		leftCarMngLabel = new JLabel(leftCarMngIcon);
		leftCarMngLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftCarMngLabel.addMouseListener(this);
		
		leftCarAddLabel = new JLabel(leftCarAddIcon);
		leftCarAddLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftCarAddLabel.addMouseListener(this);
		
		leftCarDeleteLabel = new JLabel(leftCarDeleteIcon);
		leftCarDeleteLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftCarDeleteLabel.addMouseListener(this);
		
		leftCarNotifyLabel = new JLabel(leftCarNotifyIcon);
		leftCarNotifyLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftCarNotifyLabel.addMouseListener(this);
		
		leftClientMngLabel = new JLabel(leftClientMngIcon);
		leftClientMngLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftClientMngLabel.addMouseListener(this);
		
		leftClientAddLabel = new JLabel(leftClientAddIcon);
		leftClientAddLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftClientAddLabel.addMouseListener(this);
		
		leftClientDeleteLabel = new JLabel(leftClientDeleteIcon);
		leftClientDeleteLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftClientDeleteLabel.addMouseListener(this);
		
		leftClientNotifyLabel = new JLabel(leftClientNotifyIcon);
		leftClientNotifyLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftClientNotifyLabel.addMouseListener(this);
		
		leftRentCarLabel = new JLabel(leftRentCarIcon);
		leftRentCarLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftRentCarLabel.addMouseListener(this);
		
		leftReturnCarLabel = new JLabel(leftReturnCarIcon);
		leftReturnCarLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftReturnCarLabel.addMouseListener(this);
		
		leftCarRscLabel = new JLabel(leftCarRscIcon);
		leftCarRscLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftCarRscLabel.addMouseListener(this);
		
		leftClientRscLabel = new JLabel(leftClientRscIcon);
		leftClientRscLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftClientRscLabel.addMouseListener(this);
		
		leftAllRscLabel = new JLabel(leftAllRscIcon);
		leftAllRscLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		leftAllRscLabel.addMouseListener(this);
		
		topMenuMesgMngLabel = new JLabel(topMenuMesgMngIcon);
		topMenuMesgMngLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		topMenuMesgMngLabel.addMouseListener(this);

		topMenuRentMngLabel = new JLabel(topMenuRentMngIcon);
		topMenuRentMngLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		topMenuRentMngLabel.addMouseListener(this);

		topMenuMesgRscLabel = new JLabel(topMenuMesgRscIcon);
		topMenuMesgRscLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		topMenuMesgRscLabel.addMouseListener(this);
	}

	/**
	 * 组装拼接界面
	 */
	public void fitTogether() {

		headerPanel1.add(sysMinLabel);
		headerPanel1.add(sysCloseLabel);
		headerPanel1.add(Box.createHorizontalStrut(7));
		
		headerPanel2.add(Box.createHorizontalStrut(270));
		headerPanel2.add(topMenuMesgMngLabel);
		headerPanel2.add(topMenuRentMngLabel);
		headerPanel2.add(topMenuMesgRscLabel);

		nouthPanel.add(BorderLayout.NORTH, headerPanel1);
		nouthPanel.add(BorderLayout.CENTER, headerPanel2);
		
		leftMesgMngPanel.add(leftCarMngLabel);
		leftMesgMngPanel.add(leftCarAddLabel);
		leftMesgMngPanel.add(leftCarDeleteLabel);			
		leftMesgMngPanel.add(leftCarNotifyLabel);			
		leftMesgMngPanel.add(leftClientMngLabel);
		leftMesgMngPanel.add(leftClientAddLabel);
		leftMesgMngPanel.add(leftClientDeleteLabel);			
		leftMesgMngPanel.add(leftClientNotifyLabel);
		
		leftRentMngPanel.add(leftRentCarLabel);
		leftRentMngPanel.add(leftReturnCarLabel);
		
		leftMescRscPanel.add(leftCarRscLabel);
		leftMescRscPanel.add(leftClientRscLabel);
		leftMescRscPanel.add(leftAllRscLabel);
			
		conPanel.add(BorderLayout.NORTH, nouthPanel);
		conPanel.add(BorderLayout.WEST, leftPanel);
		conPanel.add(BorderLayout.CENTER,rightPanel);
		conPanel.add(BorderLayout.SOUTH, southPanel);
	}

	// -------------------------------事件处理

	/**
	 * 设置按钮选择效果
	 */
	private void dealMouseOverAndOutEffect(JLabel selLabel, int type) {
		
		//右上角按钮
		if (selLabel.equals(sysMinLabel)) {
			if (0 == type) {
				sysMinLabel.setIcon(sysMinIcon2);
			} else if (1 == type) {
				sysMinLabel.setIcon(sysMinIcon);
			} else if (2 == type) {
				this.setState(JFrame.ICONIFIED);
			}
		} else if (selLabel.equals(sysCloseLabel)) {
			if (0 == type) {
				sysCloseLabel.setIcon(sysCloseIcon2);
			} else if (1 == type) {
				sysCloseLabel.setIcon(sysCloseIcon);
			} else if (2 == type) {
				System.exit(0);
			}
		}
		
		//顶部按钮
		else if (selLabel.equals(topMenuMesgMngLabel)) {
			if (0 == type) {
				topMenuMesgMngLabel.setIcon(topMenuMesgMngIcon2);
			} else if (1 == type) {
				topMenuMesgMngLabel.setIcon(topMenuMesgMngIcon);
			} else if (2 == type) {	
//				leftPanel.setVisible(false);
//				conPanel.add(leftMesgMngPanel);
				rightPanel.removeAll();
				leftPanel.removeAll();
				leftPanel.add(leftMesgMngPanel);
				leftPanel.updateUI();
				rightPanel.updateUI();
			}
		} 
		else if (selLabel.equals(topMenuRentMngLabel)) {
			if (0 == type) {
				topMenuRentMngLabel.setIcon(topMenuRentMngIcon2);
			} else if (1 == type) {
				topMenuRentMngLabel.setIcon(topMenuRentMngIcon);
			}else if (2 == type) {
				rightPanel.removeAll();
				leftPanel.removeAll();
				leftPanel.add(leftRentMngPanel);
				leftPanel.updateUI();
				rightPanel.updateUI();
			}
		} else if (selLabel.equals(topMenuMesgRscLabel)) {
			if (0 == type) {
				topMenuMesgRscLabel.setIcon(topMenuMesgRscIcon2);
			} else if (1 == type) {
				topMenuMesgRscLabel.setIcon(topMenuMesgRscIcon);
			}else if (2 == type) {
				rightPanel.removeAll();
				leftPanel.removeAll();
				leftPanel.add(leftMescRscPanel);
				leftPanel.updateUI();
				rightPanel.updateUI();
			}
		}
		
		
		//左侧按钮
		else if (selLabel.equals(leftCarAddLabel)) {
			if (0 == type) {
				leftCarAddLabel.setIcon(leftCarAddIcon2);
			} else if (1 == type) {
				leftCarAddLabel.setIcon(leftCarAddIcon);
			}
			else if (2 == type) {				
				rightPanel.removeAll();		
				rightPanel.add(carAdd);				
				rightPanel.updateUI();		
			}
		}
		else if (selLabel.equals(leftCarDeleteLabel)) {
			if (0 == type) {
				leftCarDeleteLabel.setIcon(leftCarDeleteIcon2);
			} else if (1 == type) {
				leftCarDeleteLabel.setIcon(leftCarDeleteIcon);
			}
			else if (2 == type) {
				rightPanel.removeAll();		
				rightPanel.add(carDelete);
				rightPanel.updateUI();	
			}
		}
		else if (selLabel.equals(leftCarNotifyLabel)) {
			if (0 == type) {
				leftCarNotifyLabel.setIcon(leftCarNotifyIcon2);
			} else if (1 == type) {
				leftCarNotifyLabel.setIcon(leftCarNotifyIcon);
			}
			else if (2 == type) {
				rightPanel.removeAll();		
				rightPanel.add(carUpdate);
				rightPanel.updateUI();
			}
		}
		else if (selLabel.equals(leftClientAddLabel)) {
			if (0 == type) {
				leftClientAddLabel.setIcon(leftClientAddIcon2);
			} else if (1 == type) {
				leftClientAddLabel.setIcon(leftClientAddIcon);
			}
			else if (2 == type) {
				if (manageUser == null) {
					manageUser = new ManageUser();
				}
				rightPanel.removeAll();		
				rightPanel.add(manageUser.contentPane);
				manageUser.panel_adduser.setVisible(true);
				manageUser.panel_updateuser.setVisible(false);
				manageUser.panel_deleteuser.setVisible(false);
				manageUser.panel_queryall.setVisible(false);
				manageUser.panel_querybykey.setVisible(false);
				rightPanel.updateUI();
			}
		}
		else if (selLabel.equals(leftClientDeleteLabel)) {
			if (0 == type) {
				leftClientDeleteLabel.setIcon(leftClientDeleteIcon2);
			} else if (1 == type) {
				leftClientDeleteLabel.setIcon(leftClientDeleteIcon);
			}
			else if (2 == type) {
				if (manageUser == null) {
					manageUser = new ManageUser();
				}
				rightPanel.removeAll();		
				rightPanel.add(manageUser.contentPane);
				manageUser.panel_deleteuser.setVisible(true);
				manageUser.panel_adduser.setVisible(false);
				manageUser.panel_queryall.setVisible(false);
				manageUser.panel_querybykey.setVisible(false);
				manageUser.panel_updateuser.setVisible(false);
				manageUser.loadUserInfoInDel();
				rightPanel.updateUI();
			}
		}
		else if (selLabel.equals(leftClientNotifyLabel)) {
			if (0 == type) {
				leftClientNotifyLabel.setIcon(leftClientNotifyIcon2);
			} else if (1 == type) {
				leftClientNotifyLabel.setIcon(leftClientNotifyIcon);
			}
			else if (2 == type) {
				if (manageUser == null) {
					manageUser = new ManageUser();
				}
				rightPanel.removeAll();		
				rightPanel.add(manageUser.contentPane);
				manageUser.panel_deleteuser.setVisible(false);
				manageUser.panel_adduser.setVisible(false);
				manageUser.panel_queryall.setVisible(false);
				manageUser.panel_querybykey.setVisible(false);
				manageUser.panel_updateuser.setVisible(true);
				manageUser.loadUserInfoInUpd();
				rightPanel.updateUI();
			}
		}
		
		
		else if (selLabel.equals(leftRentCarLabel)) {
			if (0 == type) {
				leftRentCarLabel.setIcon(leftRentCarIcon2);
			} else if (1 == type) {
				leftRentCarLabel.setIcon(leftRentCarIcon);
			}
			else if (2 == type) {
				if (manageRent==null) {
					manageRent=new ManageRent();
				}
				rightPanel.removeAll();		
				rightPanel.add(manageRent.contentPane);
				manageRent.setVisible(true);
				rightPanel.updateUI();
			}
		}
		else if (selLabel.equals(leftReturnCarLabel)) {
			if (0 == type) {
				leftReturnCarLabel.setIcon(leftReturnCarIcon2);
			} else if (1 == type) {
				leftReturnCarLabel.setIcon(leftReturnCarIcon);
			}
			else if (2 == type) {
				rightPanel.removeAll();		
				rightPanel.add(carBack);
				rightPanel.updateUI();
			}
		}
		
		
		else if (selLabel.equals(leftCarRscLabel)) {
			if (0 == type) {
				leftCarRscLabel.setIcon(leftCarRscIcon2);
			} else if (1 == type) {
				leftCarRscLabel.setIcon(leftCarRscIcon);
			}
			else if (2 == type) {
				rightPanel.removeAll();		
				rightPanel.add(carQuery);
				rightPanel.updateUI();
			}
		}
		else if (selLabel.equals(leftClientRscLabel)) {
			if (0 == type) {
				leftClientRscLabel.setIcon(leftClientRscIcon2);
			} else if (1 == type) {
				leftClientRscLabel.setIcon(leftClientRscIcon);
			}
			else if (2 == type) {
				JPanel panel_ClientRsc = new JPanel();
//				panel_ClientRsc.setBounds(0, 181, 740, 475);
				panel_ClientRsc.setPreferredSize(new Dimension(740, 475));
				panel_ClientRsc.setLayout(null);

				JLabel putInlb = new JLabel("请输入手机号或者身份证号：");
				putInlb.setBounds(103, 30, 229, 33);
				panel_ClientRsc.add(putInlb);
				
				JTextField putIntxf = new JTextField();
				putIntxf.setBounds(103, 63, 225, 27);
				panel_ClientRsc.add(putIntxf);
				putIntxf.setColumns(16);
				
				JButton confirm = new JButton("确定");
				confirm.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (manageUser == null) {
							manageUser = new ManageUser();
						}		
						rightPanel.removeAll();		
					
						manageUser.panel_deleteuser.setVisible(false);
						manageUser.panel_adduser.setVisible(false);
						manageUser.panel_queryall.setVisible(false);
						manageUser.panel_updateuser.setVisible(false);
						manageUser.panel_querybykey.setVisible(true);
						rightPanel.add(manageRent.contentPane);
						manageUser.queryUsersInfo(putIntxf.getText());
//						manageUser.setVisible(true);
						rightPanel.updateUI();
					}
				});
				confirm.setBounds(169, 133, 70, 30);
				panel_ClientRsc.add(confirm);
				
				rightPanel.removeAll();		
				rightPanel.add(panel_ClientRsc);
				rightPanel.updateUI();
			}
		}
		else if (selLabel.equals(leftAllRscLabel)) {
			if (0 == type) {
				leftAllRscLabel.setIcon(leftAllRscIcon2);
			} else if (1 == type) {
				leftAllRscLabel.setIcon(leftAllRscIcon);
			}
			else if (2 == type) {
				if (manageRent==null) {
					manageRent=new ManageRent();
				}
	
				rightPanel.removeAll();					
				manageRent.showAllContract();
				rightPanel.add(manageRent.contentPane);
				manageRent.setVisible(true);
				rightPanel.updateUI();
			}
		}
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			dealMouseOverAndOutEffect((JLabel) e.getSource(), 2);
		} else {
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() instanceof JLabel) {
			dealMouseOverAndOutEffect((JLabel) e.getSource(), 0);
		} else {
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() instanceof JLabel) {
			dealMouseOverAndOutEffect((JLabel) e.getSource(), 1);
		} else {
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void caretPositionChanged(InputMethodEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void inputMethodTextChanged(InputMethodEvent arg0) {
		// TODO 自动生成的方法存根

	}

	public void visterlogin(int flag) {
		switch (flag) {
		// 一般用户登录
		case 0:
			topMenuMesgMngLabel.setEnabled(false);
			topMenuRentMngLabel.setEnabled(false);
			// mi_orders_info.setEnabled(false);

			break;
		// 管理员登录
		case 1:
			break;

		default:
			break;
		}
	}
}
