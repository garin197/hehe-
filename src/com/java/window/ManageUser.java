package com.java.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.java.dao.UserDAO;
import com.java.model.User;
import com.java.model.UserDAOImpl;
import com.java.util.stringUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageUser extends JPanel {
	@SuppressWarnings("unused")
	final static private String[] TABLE_COLUMN_NAME_ON_DEL_PANEL = new String[] { "id\u53F7", "\u59D3\u540D",
			"\u7535\u8BDD(\u624B\u673A)", "\u9A7E\u9A76\u8BC1", "\u8EAB\u4EFD\u8BC1", "\u662F\u5426\u79DF\u8F66",
			"\u9009\u62E9" };
	@SuppressWarnings("unused")
	final static private String[] TABLE_COLUMN_NAME_ON_UPD_PANEL = new String[] { "\u59D3\u540D",
			"\u7535\u8BDD\uFF08\u624B\u673A\uFF09", "\u9A7E\u9A76\u8BC1", "\u8EAB\u4EFD\u8BC1" };
	public static JPanel contentPane;
	private JTextField tf_userinfo_id;
	private JTextField tf_userinfo_name;
	private JTextField tf_userinfo_phone;
	private JTextField tf_userinfo_license;
	private JTextField tf_userinfo_idcard;
	private JLabel result_img;
	public static JPanel panel_updateuser;
	public static JPanel panel_adduser;
	public static JPanel panel_deleteuser;
	public static JPanel panel_queryall;
	public static JPanel panel_querybykey;
	private JTextField tf_add_name;
	private JTextField tf_add_phone;
	private JTextField tf_add_license;
	private JTextField tf_add_idcard;
	private JButton btn_submit;
	private JLabel lable_add_name;
	private JLabel lable_add_phone;
	private JLabel lable_add_license;
	private JLabel lable_add_idcard;
	private JLabel err_name;
	private JLabel err_phone;
	private JLabel err_license;
	private JLabel err_idcard;
	private JTable table_on_del_panel;
	private TableModel tableModelOnDelPanel;
	protected int tableChangeFlag = -1;
	private List<User> allUser = null;
	private JTable table_on_update_panel;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_1;
	private boolean[] UpdateFlag;
	private JPanel panel_show_update_fallback2;
	private JLabel label_9;
	private JLabel lblNewLabel_3;
	private JPanel panel_show_update_fallback;
	private JLabel label_6 = new JLabel("");
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public ManageUser() {
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setType(Type.POPUP);
//		setBackground(Color.WHITE);
//		setAlwaysOnTop(true);
//		setResizable(false);
//		setBounds(0, 0, 740, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/app\u56FE\u6807.png")));
//		this.setBackground(Color.WHITE);
//		this.setForeground(Color.BLACK);
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new Dimension(740, 475));

		panel_querybykey = new JPanel();
		panel_querybykey.setBounds(0, 0, 740, 475);
		panel_querybykey.setVisible(false);

		panel_updateuser = new JPanel();
		panel_updateuser.setBounds(0, 0, 740, 475);
		panel_updateuser.setVisible(true);

		panel_queryall = new JPanel();
		panel_queryall.setBounds(0, 0, 740, 475);
		panel_queryall.setVisible(false);

		panel_adduser = new JPanel();
		panel_adduser.setBounds(0, 0, 740, 475);
		panel_adduser.setVisible(false);

		panel_deleteuser = new JPanel();
		panel_deleteuser.setBounds(0, 0, 740, 475);
		panel_deleteuser.setVisible(false);
		// panel_deleteuser.setBackground(Color.WHITE);
		contentPane.add(panel_deleteuser);
		panel_deleteuser.setLayout(null);

		JButton btn_deleteOnePress = new JButton("\u4E00\u952E\u5220\u9664");
		btn_deleteOnePress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean[] bs=getUserListToDel();
				int row=bs.length;
				for(int i=0;i<bs.length;i++) {
					boolean b=bs[i];
					if(b) {
						TableModel tableModel=table_on_del_panel.getModel();
						if(tableModel.getValueAt(i, 5).equals("是")) {
							JOptionPane.showMessageDialog(null, "此用户还有订单未完成，无法删除信息！");
							return;
						}
							
					}
				}

			}
		});
		btn_deleteOnePress.setHorizontalAlignment(SwingConstants.CENTER);
		btn_deleteOnePress.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btn_deleteOnePress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {

//						label_6.setVisible(true);
//						label_6.update(label_6.getGraphics());

					}
				});
				thread.start();
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
						thread.stop();
//						label_6.setVisible(false);
//						JOptionPane.showMessageDialog(null, "此用户还有订单未完成，无法删除信息！");

					}
				}).start();

				boolean[] userlist = getUserListToDel();
				User user = null;
				for (int i = 0; i < allUser.size(); i++) {
					user = allUser.get(i);
					if (user.getCarID() == 0 && userlist[i]) {// 删除没有租车的
						try {
							new UserDAOImpl().delect(user);
						} catch (Exception e1) {
						}
						loadUserInfoInDel();
						JOptionPane.showMessageDialog(null, "删除成功！");
					}
				}
				// thread
			}
		});

		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(108, 95, 475, 238);
		panel_deleteuser.add(panel);
		label_6.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u4FEE\u6539\u6210\u529F.GIF")));
		panel.add(label_6);
		btn_deleteOnePress.setBounds(307, 357, 123, 27);
		panel_deleteuser.add(btn_deleteOnePress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 722, 337);
		panel_deleteuser.add(scrollPane);

		table_on_del_panel = new JTable();
		table_on_del_panel.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id\u53F7", "\u59D3\u540D", "\u7535\u8BDD(\u624B\u673A)", "\u9A7E\u9A76\u8BC1",
						"\u8EAB\u4EFD\u8BC1", "\u662F\u5426\u79DF\u8F66", "\u9009\u62E9" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_on_del_panel.getColumnModel().getColumn(0).setPreferredWidth(47);
		table_on_del_panel.getColumnModel().getColumn(1).setPreferredWidth(64);
		table_on_del_panel.getColumnModel().getColumn(2).setPreferredWidth(114);
		table_on_del_panel.getColumnModel().getColumn(3).setPreferredWidth(142);
		table_on_del_panel.getColumnModel().getColumn(4).setPreferredWidth(147);
		table_on_del_panel.getColumnModel().getColumn(5).setPreferredWidth(67);
		table_on_del_panel.getColumnModel().getColumn(6).setPreferredWidth(53);
		scrollPane.setViewportView(table_on_del_panel);
		// panel_adduser.setBackground(Color.WHITE);
		contentPane.add(panel_adduser);
		panel_adduser.setLayout(null);

		lable_add_name = new JLabel("\u59D3\u540D");
		lable_add_name.setToolTipText("");
		lable_add_name.setSize(new Dimension(3, 3));
		lable_add_name.setBounds(206, 137, 54, 15);
		panel_adduser.add(lable_add_name);

		lable_add_phone = new JLabel("\u624B\u673A");
		lable_add_phone.setSize(new Dimension(3, 3));
		lable_add_phone.setBounds(206, 171, 54, 15);
		panel_adduser.add(lable_add_phone);

		lable_add_license = new JLabel("\u8F66\u724C");
		lable_add_license.setSize(new Dimension(3, 3));
		lable_add_license.setBounds(206, 204, 54, 15);
		panel_adduser.add(lable_add_license);

		lable_add_idcard = new JLabel("\u8EAB\u4EFD\u8BC1");
		lable_add_idcard.setSize(new Dimension(3, 3));
		lable_add_idcard.setBounds(206, 239, 54, 15);
		panel_adduser.add(lable_add_idcard);

		tf_add_name = new JTextField();
		tf_add_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				err_name.setText("");
				err_name.update(err_name.getGraphics());
			}
		});

		tf_add_name.setColumns(10);
		tf_add_name.setBounds(270, 137, 286, 21);
		panel_adduser.add(tf_add_name);

		tf_add_phone = new JTextField();
		tf_add_phone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				err_phone.setText("");
				err_phone.update(err_phone.getGraphics());
			}
		});

		tf_add_phone.setColumns(12);
		tf_add_phone.setBounds(270, 171, 286, 21);
		panel_adduser.add(tf_add_phone);

		tf_add_license = new JTextField();
		tf_add_license.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				err_license.setText("");
				err_license.update(err_license.getGraphics());
			}
		});

		tf_add_license.setColumns(25);
		tf_add_license.setBounds(270, 204, 286, 21);
		panel_adduser.add(tf_add_license);

		tf_add_idcard = new JTextField();
		tf_add_idcard.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				err_idcard.setText("");
				err_idcard.update(err_idcard.getGraphics());
			}
		});

		tf_add_idcard.setColumns(10);
		tf_add_idcard.setBounds(270, 239, 286, 21);
		panel_adduser.add(tf_add_idcard);

		btn_submit = new JButton("提交");

		btn_submit.addMouseListener(new MouseAdapter() {
			// @Override
			// public void mouseEntered(MouseEvent e) {
			// btn_submit.setIcon(new
			// ImageIcon(ManageUser.class.getResource("/image/app/\u63D0\u4EA4enter.png")));
			// // label_submit.setBounds(347, 287, 92, 38);
			// label_submit.update(label_submit.getGraphics());
			// }
			//
			// @Override
			// public void mouseExited(MouseEvent e) {
			// label_submit.setIcon(new
			// ImageIcon(ManageUser.class.getResource("/image/app/\u63D0\u4EA4out.png")));
			// // label_submit.setBounds(347, 287, 92, 38);
			// label_submit.update(label_submit.getGraphics());
			// }

			@Override
			public void mouseClicked(MouseEvent e) {
				User user = isDataValidInAddUser();
				update(getGraphics());
				if (user != null) {
					UserDAO userDAO = new UserDAOImpl();
					try {
						userDAO.insert(user);
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		});
		// label_submit.setForeground(Color.WHITE);
		// label_submit.setIcon(new
		// ImageIcon(ManageUser.class.getResource("/image/app/\u63D0\u4EA4out.png")));
		btn_submit.setBounds(347, 287, 92, 30);
		panel_adduser.add(btn_submit);

		err_name = new JLabel("");
		err_name.setForeground(Color.RED);
		err_name.setBounds(566, 140, 168, 15);
		panel_adduser.add(err_name);

		err_phone = new JLabel("");
		err_phone.setForeground(Color.RED);
		err_phone.setBounds(566, 171, 54, 15);
		panel_adduser.add(err_phone);

		err_license = new JLabel("");
		err_license.setForeground(Color.RED);
		err_license.setBounds(566, 207, 54, 15);
		panel_adduser.add(err_license);

		err_idcard = new JLabel("");
		err_idcard.setForeground(Color.RED);
		err_idcard.setBounds(566, 239, 54, 15);
		panel_adduser.add(err_idcard);
		// panel_queryall.setBackground(Color.WHITE);
		contentPane.add(panel_queryall);

		JLabel lblP_3 = new JLabel("p4");
		panel_queryall.add(lblP_3);
//		panel_updateuser.setBackground(Color.WHITE);
		contentPane.add(panel_updateuser);
		panel_updateuser.setLayout(null);

		lblNewLabel_1 = new JLabel("\u4E00\u952E\u4FEE\u6539");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = null;
				TableModel tableModel = table_on_update_panel.getModel();
				for (int i = 0; i < allUser.size(); i++) {
					user = allUser.get(i);
					if (UpdateFlag[i]) {
						try {
							user.setName((String) tableModel.getValueAt(i, 0));
							user.setPhone((String) tableModel.getValueAt(i, 1));
							user.setLicense((String) tableModel.getValueAt(i, 2));
							user.setIDCard((String) tableModel.getValueAt(i, 3));
							if (!new UserDAOImpl().update(user)) {
//								panel_show_update_fallback2.setVisible(true);
								JOptionPane.showMessageDialog(null, "修改失败！");
								table_on_update_panel.setRowSelectionInterval(i, i);
								Thread thread = new Thread(new Runnable() {

									@Override
									public void run() {
										try {
											Thread.sleep(2000);
										} catch (InterruptedException e) {
										}
										panel_show_update_fallback2.setVisible(false);
										lblNewLabel_1.setVisible(false);
									}
								});
								thread.start();
								return;
							}
						} catch (Exception e1) {
						}
					}
				}
				loadUserInfoInUpd();
//				panel_show_update_fallback.setVisible(true);
				JOptionPane.showMessageDialog(null, "修改成功！");
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
						panel_show_update_fallback.setVisible(false);
						lblNewLabel_1.setVisible(false);
					}
				});
				thread.start();
			}
		});

		panel_show_update_fallback2 = new JPanel();
//		panel_show_update_fallback2.setBackground(Color.WHITE);
		panel_show_update_fallback2.setBounds(24, 99, 695, 234);
		panel_updateuser.add(panel_show_update_fallback2);
		panel_show_update_fallback2.setVisible(false);
		panel_show_update_fallback2.setLayout(null);

		label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u7FFB\u8F66.gif")));
		label_9.setBounds(10, 10, 390, 205);
		panel_show_update_fallback2.add(label_9);

		lblNewLabel_3 = new JLabel("\u4FEE\u6539\u5931\u8D25");
		lblNewLabel_3.setFont(new Font("华文琥珀", Font.PLAIN, 39));
		lblNewLabel_3.setBounds(412, 48, 255, 133);
		panel_show_update_fallback2.add(lblNewLabel_3);

		panel_show_update_fallback = new JPanel();
//		panel_show_update_fallback.setBackground(Color.WHITE);
		panel_show_update_fallback.setBounds(24, 99, 695, 235);
		panel_updateuser.add(panel_show_update_fallback);
		panel_show_update_fallback.setLayout(null);
		panel_show_update_fallback.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u6210\u529F");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("黑体", Font.BOLD, 39));
		lblNewLabel_2.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u4FEE\u6539\u6210\u529F.GIF")));
		lblNewLabel_2.setBounds(10, 10, 685, 200);
		panel_show_update_fallback.add(lblNewLabel_2);
		lblNewLabel_1.setBounds(469, 35, 54, 15);
		panel_updateuser.add(lblNewLabel_1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 73, 722, 392);
		panel_updateuser.add(scrollPane_1);

		table_on_update_panel = new JTable();
		table_on_update_panel.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u59D3\u540D",
				"\u7535\u8BDD\uFF08\u624B\u673A\uFF09", "\u9A7E\u9A76\u8BC1", "\u8EAB\u4EFD\u8BC1" }));
		table_on_update_panel.getColumnModel().getColumn(1).setPreferredWidth(108);
		table_on_update_panel.getColumnModel().getColumn(2).setPreferredWidth(158);
		table_on_update_panel.getColumnModel().getColumn(3).setPreferredWidth(205);
		scrollPane_1.setViewportView(table_on_update_panel);
//		panel_querybykey.setBackground(Color.WHITE);
		contentPane.add(panel_querybykey);
		panel_querybykey.setLayout(null);

		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.frame.setVisible(true);
//				dispose();
			}
		});
		label_4.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/return.png")));
		label_4.setBounds(639, 281, 73, 48);
		panel_querybykey.add(label_4);

		JLabel lblP_4 = new JLabel("");
		lblP_4.setBounds(306, 5, 129, 39);
		lblP_4.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u5BA2\u6237\u4FE1\u606F.png")));
		panel_querybykey.add(lblP_4);

		JLabel id = new JLabel("\u5BA2\u6237ID");
		id.setSize(new Dimension(3, 3));
		id.setBounds(242, 79, 54, 15);
		panel_querybykey.add(id);

		JLabel label = new JLabel("\u59D3\u540D");
		label.setSize(new Dimension(3, 3));
		label.setBounds(242, 115, 54, 15);
		panel_querybykey.add(label);

		JLabel label_1 = new JLabel("\u624B\u673A");
		label_1.setSize(new Dimension(3, 3));
		label_1.setBounds(242, 149, 54, 15);
		panel_querybykey.add(label_1);

		JLabel label_2 = new JLabel("\u8F66\u724C");
		label_2.setSize(new Dimension(3, 3));
		label_2.setBounds(242, 182, 54, 15);
		panel_querybykey.add(label_2);

		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_3.setSize(new Dimension(3, 3));
		label_3.setBounds(242, 217, 54, 15);
		panel_querybykey.add(label_3);

		tf_userinfo_id = new JTextField();
		tf_userinfo_id.setForeground(UIManager.getColor("Button.foreground"));
		tf_userinfo_id.setBackground(UIManager.getColor("Button.highlight"));
		tf_userinfo_id.setEditable(false);
		tf_userinfo_id.setBounds(299, 76, 433, 21);
		panel_querybykey.add(tf_userinfo_id);
		tf_userinfo_id.setColumns(10);

		tf_userinfo_name = new JTextField();
		tf_userinfo_name.setEditable(false);
		tf_userinfo_name.setColumns(10);
		tf_userinfo_name.setBounds(299, 112, 433, 21);
		panel_querybykey.add(tf_userinfo_name);

		tf_userinfo_phone = new JTextField();
		tf_userinfo_phone.setEditable(false);
		tf_userinfo_phone.setColumns(12);
		tf_userinfo_phone.setBounds(299, 146, 433, 21);
		panel_querybykey.add(tf_userinfo_phone);

		tf_userinfo_license = new JTextField();
		tf_userinfo_license.setEditable(false);
		tf_userinfo_license.setColumns(25);
		tf_userinfo_license.setBounds(299, 179, 433, 21);
		panel_querybykey.add(tf_userinfo_license);

		tf_userinfo_idcard = new JTextField();
		tf_userinfo_idcard.setEditable(false);
		tf_userinfo_idcard.setColumns(10);
		tf_userinfo_idcard.setBounds(299, 214, 433, 21);
		panel_querybykey.add(tf_userinfo_idcard);

		result_img = new JLabel("");
		panel_querybykey.add(result_img);
		setFont(new Font("Dialog", Font.BOLD, 16));
//		setTitle("\u79DF\u8F66\u7CFB\u7EDF");
//		setLocationRelativeTo(null);
		// panel_welcomeinmanageruser.setVisible(true);
		// panel_updateuser.setVisible(false);
		// panel_adduser.setVisible(false);
		// panel_deleteuser.setVisible(false);;
		// panel_queryall.setVisible(false);
		// panel_querybykey.setVisible(false);
	}

	protected boolean[] getUserListToDel() {
		int rows = table_on_del_panel.getModel().getRowCount();
		boolean[] bs = new boolean[rows];
		TableModel tableModel = table_on_del_panel.getModel();
		for (int i = 0; i < rows; i++) {
			if (tableModel.getValueAt(i, 6) == Boolean.TRUE) {
				bs[i] = true;
			} else {
				bs[i] = false;
			}
		}
		return bs;
	}
	
	public void queryUsersInfo(String key) {

		UserDAO userDAO = new UserDAOImpl();
		User user = null;
		try {
			user = userDAO.queryByKeyword(key);
			if (user == null) {
				result_img.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u6CA1\u627E\u5230.jpg")));
				result_img.setBounds(0, 5, 778, 441);
			} else {
				result_img.setSize(212, 282);
				result_img.setLocation(10, 10);
				result_img.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u5934\u50CF.jpg")));
			}
			tf_userinfo_id.setText("" + user.getUserID());
			tf_userinfo_license.setText("" + user.getLicense());
			tf_userinfo_name.setText("" + user.getName());
			tf_userinfo_phone.setText("" + user.getPhone());
			StringBuffer string = new StringBuffer(user.getIDCard());
			string.replace(0 + 6, 0 + 6 + 6, "******");
			tf_userinfo_idcard.setText("" + string);
			// 440782 xxxxxx 111111
		} catch (Exception e) {
		}
	}

	/**
	 * 检查是否输入合法 ·合法 返回user实体
	 * 
	 * @return
	 */
	private User isDataValidInAddUser() {
		User user = null;
		boolean flag = false;
		String name = tf_add_name.getText();
		String phone = tf_add_phone.getText();
		String license = tf_add_license.getText();
		String idcard = tf_add_idcard.getText();
		try {
			if (new UserDAOImpl().queryByKeyword(idcard) != null || new UserDAOImpl().queryByKeyword(phone) != null) {
				err_name.setText("用户已存在！");
				err_name.update(err_name.getGraphics());
				return null;
			}
		} catch (Exception e) {
		}
		if (stringUtil.isEmpty(name)) {
			err_name.setText("*");
			flag = true;
		}
		if (stringUtil.isEmpty(phone)) {
			err_phone.setText("*");
			flag = true;
		}
		if (stringUtil.isEmpty(license)) {
			err_license.setText("*");
			flag = true;
		}
		if (stringUtil.isEmpty(idcard)) {
			err_idcard.setText("*");
			flag = true;
		}
		char[] phonecharr = phone.toCharArray();
		for (char c : phonecharr) {
			if (c > '9' || c < '0') {
				err_phone.setText("**");
				flag = true;
			}
		}
		char[] idcardecharr = idcard.toCharArray();
		for (char c : idcardecharr) {
			if (c > '9' || c < '0') {
				err_idcard.setText("**");
				flag = true;
			}
		}
		if (!flag) {
			user = new User();
			user.setName(name);
			user.setPhone(phone);
			user.setLicense(license);
			user.setIDCard(idcard);
		}
		return user;
	}

	/**
	 * 在删除客户画板上加载用户信息
	 */
	public void loadUserInfoInDel() {
		// 行向量
		Vector<Vector<Object>> rowData = new Vector<>();
		// 行向量元素
		Vector<Object> data;
		// 列向量
		Vector<String> columnNames = new Vector<>();
		for (String string : TABLE_COLUMN_NAME_ON_DEL_PANEL) {
			columnNames.add(string);
		}

		try {
			// 数据库拉数据
			allUser = new UserDAOImpl().queryALL();
		} catch (Exception e) {
		}
		if (allUser != null) {
			for (User user : allUser) {
				data = new Vector<>();
				data.add(user.getUserID());
				data.add(user.getName());
				data.add(user.getPhone());
				data.add(user.getLicense());
				data.add(user.getIDCard());
				if (user.getCarID() != 0) {
					data.add("是");
				} else {
					data.add("否");
				}
				rowData.add(data);
			}
		} else {

		}
		DefaultTableModel currentModel = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				if (column == 6) {
					return true;
				}
				return false;
			}
		};
		table_on_del_panel.setModel(currentModel);
		table_on_del_panel.getColumnModel().getColumn(0).setPreferredWidth(47);
		table_on_del_panel.getColumnModel().getColumn(1).setPreferredWidth(64);
		table_on_del_panel.getColumnModel().getColumn(2).setPreferredWidth(114);
		table_on_del_panel.getColumnModel().getColumn(3).setPreferredWidth(142);
		table_on_del_panel.getColumnModel().getColumn(4).setPreferredWidth(147);
		table_on_del_panel.getColumnModel().getColumn(5).setPreferredWidth(67);
		table_on_del_panel.getColumnModel().getColumn(6).setPreferredWidth(53);
		TableColumn tc = table_on_del_panel.getColumnModel().getColumn(6);
		tc.setCellEditor(table_on_del_panel.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(table_on_del_panel.getDefaultRenderer(Boolean.class));
		tc.getCellEditor().cancelCellEditing();
		for (int i = 0; i < allUser.size(); i++) {
			User user = allUser.get(i);
			table_on_del_panel.getModel().setValueAt(Boolean.FALSE, i, 6);
			if (user.getCarID() != 0) {
				table_on_del_panel.getModel().setValueAt(Boolean.FALSE, i, 6);
			}
		}
		table_on_del_panel.update(table_on_del_panel.getGraphics());
	}


	public void loadUserInfoInUpd() {
		// 行向量
		Vector<Vector<Object>> rowData = new Vector<>();
		// 行向量元素
		Vector<Object> data;
		// 列向量
		Vector<String> columnNames = new Vector<>();
		for (String string : TABLE_COLUMN_NAME_ON_UPD_PANEL) {
			columnNames.add(string);
		}

		try {
			// 数据库拉数据
			allUser = new UserDAOImpl().queryALL();
		} catch (Exception e) {
		}
		if (allUser != null) {
			for (User user : allUser) {
				data = new Vector<>();
				data.add(user.getName());
				data.add(user.getPhone());
				data.add(user.getLicense());
				data.add(user.getIDCard());
				rowData.add(data);
			}
		} else {

		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);
		table_on_update_panel.getColumnModel().getColumn(1).setPreferredWidth(108);
		table_on_update_panel.getColumnModel().getColumn(2).setPreferredWidth(158);
		table_on_update_panel.getColumnModel().getColumn(3).setPreferredWidth(205);
		table_on_update_panel.setModel(defaultTableModel);
		// table_on_update_panel.update(table_on_update_panel.getGraphics());
		setUpdateMode();
	}

	public void setUpdateMode() {
		TableModel tableModel = table_on_update_panel.getModel();
		UpdateFlag = new boolean[allUser.size()];
		tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				lblNewLabel_1.setVisible(true);
				int row = e.getFirstRow();
				if (stringUtil.isEmpty((String) tableModel.getValueAt(row, 0))) {
					tableModel.setValueAt(allUser.get(row).getName(), row, 0);
				}
				if (stringUtil.isEmpty((String) tableModel.getValueAt(row, 1))) {
					tableModel.setValueAt(allUser.get(row).getName(), row, 0);

				}
				if (stringUtil.isEmpty((String) tableModel.getValueAt(row, 2))) {
					tableModel.setValueAt(allUser.get(row).getName(), row, 0);
				}
				if (stringUtil.isEmpty((String) tableModel.getValueAt(row, 3))) {
					tableModel.setValueAt(allUser.get(row).getName(), row, 0);
				}

				UpdateFlag[e.getFirstRow()] = true;
				lblNewLabel_1.setEnabled(true);
			}
		});
		TableCellEditor tEditor = table_on_update_panel.getCellEditor();
		// tEditor.addCellEditorListener(new CellEditorListener() {
		//
		// @Override
		// public void editingStopped(ChangeEvent e) {
		// lblNewLabel_1.setEnabled(true);
		// }
		//
		// @Override
		// public void editingCanceled(ChangeEvent e) {
		// // TODO 自动生成的方法存根
		//
		// }
		// });
	}
}
