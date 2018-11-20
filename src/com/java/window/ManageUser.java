package com.java.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.UserDAO;
import com.java.model.User;
import com.java.model.UserDAOImpl;
import com.java.util.stringUtil;

import sun.security.provider.certpath.Vertex;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ManageUser extends JFrame {
	final static private String[] TABLE_COLUMN_NAME = new String[] { "id\u53F7", "\u59D3\u540D",
			"\u7535\u8BDD(\u624B\u673A)", "\u9A7E\u9A76\u8BC1", "\u8EAB\u4EFD\u8BC1", "\u662F\u5426\u79DF\u8F66",
			"\u9009\u62E9" };
	private JPanel contentPane;
	private JTextField tf_userinfo_id;
	private JTextField tf_userinfo_name;
	private JTextField tf_userinfo_phone;
	private JTextField tf_userinfo_license;
	private JTextField tf_userinfo_idcard;
	public JPanel panel_welcomeinmanageruser;
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
	private JLabel label_5;
	private JLabel label_submit;
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

	/**
	 * Create the frame.
	 */
	public ManageUser() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setType(Type.POPUP);
		setBackground(Color.WHITE);
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(100, 100, 748, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/app\u56FE\u6807.png")));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);

		panel_querybykey = new JPanel();
		panel_querybykey.setVisible(false);

		panel_adduser = new JPanel();
		panel_adduser.setVisible(false);

		panel_deleteuser = new JPanel();
		panel_deleteuser.setVisible(false);
		panel_deleteuser.setBackground(Color.WHITE);
		panel_deleteuser.setBounds(0, 131, 742, 357);
		contentPane.add(panel_deleteuser);
		panel_deleteuser.setLayout(null);

		JLabel lable_delete_user_return = new JLabel("\u8FD4\u56DE");
		lable_delete_user_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.frame.setVisible(true);
				dispose();
			}
		});
		lable_delete_user_return.setBounds(636, 30, 54, 15);
		panel_deleteuser.add(lable_delete_user_return);

		JLabel lable_deleteOnePress = new JLabel("\u4E00\u952E\u5220\u9664");
		lable_deleteOnePress.setBounds(539, 30, 64, 15);
		panel_deleteuser.add(lable_deleteOnePress);

		JLabel lblP_1 = new JLabel("");
		lblP_1.setBounds(17, 5, 708, 59);
		lblP_1.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u5220\u9664\u5BA2\u6237.png")));
		panel_deleteuser.add(lblP_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 722, 273);
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
		panel_adduser.setBackground(Color.WHITE);
		panel_adduser.setBounds(0, 131, 742, 357);
		contentPane.add(panel_adduser);
		panel_adduser.setLayout(null);

		JLabel lblP = new JLabel("");
		lblP.setBounds(8, 5, 726, 38);
		lblP.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u589E\u52A0user.png")));
		panel_adduser.add(lblP);

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
				err_name.update(getGraphics());
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
				err_phone.update(getGraphics());
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
				err_license.update(getGraphics());
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
				err_idcard.update(getGraphics());
			}
		});

		tf_add_idcard.setColumns(10);
		tf_add_idcard.setBounds(270, 239, 286, 21);
		panel_adduser.add(tf_add_idcard);

		label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.frame.setVisible(true);
				dispose();
			}
		});
		label_5.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/return.png")));
		label_5.setBounds(631, 287, 73, 48);
		panel_adduser.add(label_5);

		label_submit = new JLabel("");

		label_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_submit.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u63D0\u4EA4enter.png")));
				// label_submit.setBounds(347, 287, 92, 38);
				label_submit.update(label_submit.getGraphics());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_submit.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u63D0\u4EA4out.png")));
				// label_submit.setBounds(347, 287, 92, 38);
				label_submit.update(label_submit.getGraphics());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				User user = isDataValidInAddUser();
				update(getGraphics());
				if (user != null) {
					UserDAO userDAO = new UserDAOImpl();
					try {
						userDAO.insert(user);
					} catch (Exception e1) {
					}
				}
			}
		});
		label_submit.setForeground(Color.WHITE);
		label_submit.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u63D0\u4EA4out.png")));
		label_submit.setBounds(347, 287, 92, 38);
		panel_adduser.add(label_submit);

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
		panel_querybykey.setBackground(Color.WHITE);
		panel_querybykey.setBounds(0, 131, 742, 357);
		contentPane.add(panel_querybykey);
		panel_querybykey.setLayout(null);

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

		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.frame.setVisible(true);
				dispose();
			}
		});
		label_4.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/return.png")));
		label_4.setBounds(639, 281, 73, 48);
		panel_querybykey.add(label_4);

		result_img = new JLabel("");
		panel_querybykey.add(result_img);

		panel_queryall = new JPanel();
		panel_queryall.setVisible(false);
		panel_queryall.setBackground(Color.WHITE);
		panel_queryall.setBounds(0, 131, 742, 357);
		contentPane.add(panel_queryall);

		JLabel lblP_3 = new JLabel("p4");
		panel_queryall.add(lblP_3);

		panel_updateuser = new JPanel();
		panel_updateuser.setVisible(false);
		panel_updateuser.setBackground(Color.WHITE);
		panel_updateuser.setBounds(0, 131, 742, 357);
		contentPane.add(panel_updateuser);

		JLabel lblP_2 = new JLabel("p3");
		panel_updateuser.add(lblP_2);

		panel_welcomeinmanageruser = new JPanel();
		panel_welcomeinmanageruser.setBackground(Color.WHITE);
		panel_welcomeinmanageruser.setBounds(0, 0, 742, 132);
		contentPane.add(panel_welcomeinmanageruser);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/welcomeInManagerUser.png")));
		panel_welcomeinmanageruser.add(lblNewLabel);
		setFont(new Font("Dialog", Font.BOLD, 16));
		setTitle("\u79DF\u8F66\u7CFB\u7EDF");
		setLocationRelativeTo(null);
		// panel_welcomeinmanageruser.setVisible(true);
		// panel_updateuser.setVisible(false);
		// panel_adduser.setVisible(false);
		// panel_deleteuser.setVisible(false);;
		// panel_queryall.setVisible(false);
		// panel_querybykey.setVisible(false);
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
				err_name.update(getGraphics());
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
	public void loadUserInfo() {
		// 行向量
		Vector<Vector<Object>> rowData = new Vector<>();
		// 行向量元素
		Vector<Object> data;
		// 列向量
		Vector<String> columnNames = new Vector<>();
		for (String string : TABLE_COLUMN_NAME) {
			columnNames.add(string);
		}
		List<User> allUser = null;
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

//					data.add(choose);
				} else {
					data.add("否");
//					JCheckBox choose = new JCheckBox();
//					choose.setEnabled(false);
//					choose.setVisible(true);
//					data.add(choose);
				}
				rowData.add(data);
			}
		} else {

		}
//		for(Vector<Object> vertex:rowData) {
//			if(((String)vertex.lastElement()).equals("是")) {
//				JCheckBox choose = new JCheckBox();
//				choose.setEnabled(true);
//				choose.setVisible(true);
//			}
//		}
		DefaultTableModel currentModel = new DefaultTableModel(rowData, columnNames);
		table_on_del_panel.setModel(currentModel);
		table_on_del_panel.getColumnModel().getColumn(0).setPreferredWidth(47);
		table_on_del_panel.getColumnModel().getColumn(1).setPreferredWidth(64);
		table_on_del_panel.getColumnModel().getColumn(2).setPreferredWidth(114);
		table_on_del_panel.getColumnModel().getColumn(3).setPreferredWidth(142);
		table_on_del_panel.getColumnModel().getColumn(4).setPreferredWidth(147);
		table_on_del_panel.getColumnModel().getColumn(5).setPreferredWidth(67);
		table_on_del_panel.getColumnModel().getColumn(6).setPreferredWidth(53);
		TableColumnModel tcModel=table_on_del_panel.getColumnModel();
		tcModel.getColumn(6).setCellEditor(new DefaultCellEditor(new JCheckBox("111", true)));
		
	}
}
