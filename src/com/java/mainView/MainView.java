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
	// �����
	private CustSkinPanel southPanel,  headerPanel1, headerPanel2, leftPanel, rightPanel;
	private JPanel nouthPanel;
	// ���Ͻǹر���С����ť
	private ImageIcon sysMinIcon, sysMinIcon2, sysCloseIcon, sysCloseIcon2;
	private JLabel sysMinLabel, sysCloseLabel;
	// �ܲ˵�
	private ImageIcon topMenuMesgMngIcon, topMenuMesgMngIcon2, topMenuRentMngIcon, topMenuRentMngIcon2,
	topMenuMesgRscIcon, topMenuMesgRscIcon2;
	private JLabel topMenuMesgMngLabel, topMenuRentMngLabel, topMenuMesgRscLabel;
	//���˵�
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
	 * ��ʼ������
	 */
	private void init() {
		// TODO �Զ����ɵķ������
		this.setTitle("Hehe �⳵");
		this.setSize(885, 560);
		this.setIconImage(ViewToolkit.createImageIcon("appͼ��.png").getImage());
		this.setLocationRelativeTo(null);// ��Ļ����
		this.setUndecorated(true);// �����˴��ڵ�װ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		/**
		 * ��������ƶ��¼�
		 */
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { // ��갴���¼�
				pressedPoint = e.getPoint(); // ��¼�������
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

	/**
	 * ��������Ԫ��
	 * @throws Exception 
	 */
	public void buildElems() throws Exception {
		/**
		 * ����ʼ��
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
		 * ͼ���ʼ��
		 */
		//��С���ر�ͼ��
		sysMinIcon = ViewToolkit.createImageIcon("min_btn.png");
		sysMinIcon2 = ViewToolkit.createImageIcon("min_btn2.png");
		sysCloseIcon = ViewToolkit.createImageIcon("close_btn.png");
		sysCloseIcon2 = ViewToolkit.createImageIcon("close_btn2.png");
		
		//topͼ��
		topMenuMesgMngIcon = ViewToolkit.createImageIcon("topMenuMesgMng.jpg");
		topMenuMesgMngIcon2 = ViewToolkit.createImageIcon("topMenuMesgMng2.jpg");

		topMenuRentMngIcon = ViewToolkit.createImageIcon("topMenuRentMng.jpg");
		topMenuRentMngIcon2 = ViewToolkit.createImageIcon("topMenuRentMng2.jpg");

		topMenuMesgRscIcon = ViewToolkit.createImageIcon("topMenuMesgRsc.jpg");
		topMenuMesgRscIcon2 = ViewToolkit.createImageIcon("topMenuMesgRsc2.jpg");
		
		//���͹���ͼ��
		leftCarMngIcon = ViewToolkit.createImageIcon("leftCarMng.jpg");
//		leftCarMngIcon2 = ViewToolkit.createImageIcon("leftCarMng2.jpg");
		leftCarAddIcon = ViewToolkit.createImageIcon("leftCarAdd.jpg");
		leftCarAddIcon2 = ViewToolkit.createImageIcon("leftCarAdd2.jpg");
		leftCarDeleteIcon = ViewToolkit.createImageIcon("leftCarDelete.jpg");
		leftCarDeleteIcon2 = ViewToolkit.createImageIcon("leftCarDelete2.jpg");
		leftCarNotifyIcon = ViewToolkit.createImageIcon("leftCarNotify.jpg");
		leftCarNotifyIcon2 = ViewToolkit.createImageIcon("leftCarNotify2.jpg");
		
		//�ͻ�����ͼ��
		leftClientMngIcon = ViewToolkit.createImageIcon("leftClientMng.jpg");
//		leftClientMngIcon2 = ViewToolkit.createImageIcon("leftClientMng2.jpg");
		leftClientAddIcon = ViewToolkit.createImageIcon("leftClientAdd.jpg");
		leftClientAddIcon2 = ViewToolkit.createImageIcon("leftClientAdd2.jpg");
		leftClientDeleteIcon = ViewToolkit.createImageIcon("leftClientDelete.jpg");
		leftClientDeleteIcon2 = ViewToolkit.createImageIcon("leftClientDelete2.jpg");
		leftClientNotifyIcon = ViewToolkit.createImageIcon("leftClientNotify.jpg");
		leftClientNotifyIcon2 = ViewToolkit.createImageIcon("leftClientNotify2.jpg");
		
		//�����⳵ͼ��
		leftRentCarIcon = ViewToolkit.createImageIcon("leftRentCar.jpg");
		leftRentCarIcon2 = ViewToolkit.createImageIcon("leftRentCar2.jpg");
		leftReturnCarIcon = ViewToolkit.createImageIcon("leftReturnCar.jpg");
		leftReturnCarIcon2 = ViewToolkit.createImageIcon("leftReturnCar2.jpg");
		
		//����/�ͻ�/������ѯͼ��
		leftCarRscIcon = ViewToolkit.createImageIcon("leftCarRsc.jpg");
		leftCarRscIcon2 = ViewToolkit.createImageIcon("leftCarRsc2.jpg");
		leftClientRscIcon = ViewToolkit.createImageIcon("leftClientRsc.jpg");
		leftClientRscIcon2 = ViewToolkit.createImageIcon("leftClientRsc2.jpg");
		leftAllRscIcon = ViewToolkit.createImageIcon("leftAllRsc.jpg");
		leftAllRscIcon2 = ViewToolkit.createImageIcon("leftAllRsc2.jpg");
		
		/**
		 * ��ǩ��ʼ��
		 */
		//��С���رձ�ǩ
		sysMinLabel = new JLabel(sysMinIcon);
		sysMinLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sysMinLabel.setToolTipText("��С������");
		sysMinLabel.addMouseListener(this);

		sysCloseLabel = new JLabel(sysCloseIcon);
		sysCloseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sysCloseLabel.setToolTipText("�رմ���");
		sysCloseLabel.addMouseListener(this);
		//��Ϣ����	
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
	 * ��װƴ�ӽ���
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

	// -------------------------------�¼�����

	/**
	 * ���ð�ťѡ��Ч��
	 */
	private void dealMouseOverAndOutEffect(JLabel selLabel, int type) {
		
		//���Ͻǰ�ť
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
		
		//������ť
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
		
		
		//��ఴť
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

				JLabel putInlb = new JLabel("�������ֻ��Ż������֤�ţ�");
				putInlb.setBounds(103, 30, 229, 33);
				panel_ClientRsc.add(putInlb);
				
				JTextField putIntxf = new JTextField();
				putIntxf.setBounds(103, 63, 225, 27);
				panel_ClientRsc.add(putIntxf);
				putIntxf.setColumns(16);
				
				JButton confirm = new JButton("ȷ��");
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
		// TODO �Զ����ɵķ������
		if (e.getSource() instanceof JLabel) {
			dealMouseOverAndOutEffect((JLabel) e.getSource(), 0);
		} else {
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getSource() instanceof JLabel) {
			dealMouseOverAndOutEffect((JLabel) e.getSource(), 1);
		} else {
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void caretPositionChanged(InputMethodEvent arg0) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void inputMethodTextChanged(InputMethodEvent arg0) {
		// TODO �Զ����ɵķ������

	}

	public void visterlogin(int flag) {
		switch (flag) {
		// һ���û���¼
		case 0:
			topMenuMesgMngLabel.setEnabled(false);
			topMenuRentMngLabel.setEnabled(false);
			// mi_orders_info.setEnabled(false);

			break;
		// ����Ա��¼
		case 1:
			break;

		default:
			break;
		}
	}
}
