package com.java.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.java.model.Car;
import com.java.model.CarDAOImpl;
import com.java.model.Contract;
import com.java.model.ContractDAOImpl;
import com.java.model.SelectOnContractModel;
import com.java.model.User;
import com.java.model.UserDAOImpl;
import com.java.util.stringUtil;

public class ManageRent extends JPanel {

	private final String[] columnName = new String[] { "车ID", "\u8F66\u540D", "\u54C1\u724C", "\u7C7B\u578B",
			"\u5EA7\u578B", "\u5269\u4F59" };
	private final String[] columnName_on_orders = new String[] { "\u8F66\u540D", "\u5BA2\u6237\u59D3\u540D",
			"\u9A7E\u9A76\u8BC1", "\u5408\u540C\u751F\u6548\u65E5\u671F", "\u79DF\u91D1(/\u65E5)" };
	public static JPanel contentPane;
	private JTextField textField_on_rent_name;
	private JTextField textField_on_rent_phone;
	private JTextField textField_on_rent_license;
	private JTextField textField_on_rent_idcard;
	private JLabel label_err_message;
	private JComboBox comboBox_type;
	private JComboBox comboBox_blank;
	private JPanel panel_on_rent;
	private JPanel panel_on_rent2;
	private JTable table_on_chosecar;
	private static User currentUser;
	private List<Car> allCarlist;
	protected static Car currentcar;
	private JTable table_show_orders;
	private JPanel panel;
	private JPanel panel_ALLOrder;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ManageRent() {
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setType(Type.POPUP);
//		setBackground(Color.WHITE);
//		setAlwaysOnTop(true);
//		setResizable(false);
//		setBounds(100, 100, 748, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/app\u56FE\u6807.png")));
//		getContentPane().setBackground(Color.WHITE);
//		getContentPane().setForeground(Color.BLACK);
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new Dimension(740, 475));

		panel_on_rent2 = new JPanel();
		panel_on_rent2.setVisible(false);

		panel_ALLOrder = new JPanel();
		panel_ALLOrder.setVisible(false);

		panel = new JPanel();
		panel.setVisible(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(-2, 0, 742, 488);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_7 = new JLabel("\u786E\u8BA4\u8BA2\u5355");
		label_7.setBounds(10, 10, 54, 15);
		panel.add(label_7);

		JLabel lblname = new JLabel("New label");
		lblname.setBounds(10, 35, 173, 15);
		panel.add(lblname);

		JLabel lblcar = new JLabel("New label");
		lblcar.setBounds(10, 60, 173, 15);
		panel.add(lblcar);

		JLabel lbllicense = new JLabel("New label");
		lbllicense.setBounds(10, 85, 173, 15);
		panel.add(lbllicense);

		JLabel lblrent = new JLabel("New label");
		lblrent.setBounds(10, 110, 173, 15);
		panel.add(lblrent);

		JButton comformbutton = new JButton("\u786E\u8BA4");
		comformbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDAOImpl userDAOImpl = null;
				User user = currentUser;
				try {
					userDAOImpl = new UserDAOImpl();
					// userDAOImpl.insert(user);
				} catch (Exception e1) {
				}
				try {
					if (userDAOImpl.queryByKeyword(user.getIDCard()) == null) {
						userDAOImpl.insert(user);
						
						user = userDAOImpl.queryByKeyword(user.getIDCard());
					} else {
						user = userDAOImpl.queryByKeyword(user.getIDCard());
					}
					currentcar.setUserID(user.getUserID());
					currentUser.setUserID(user.getUserID());

				} catch (Exception e1) {
				}
				Contract contract = new Contract();
				contract.setCarID(currentcar.getCarID());
				contract.setName(currentUser.getName());
				contract.setLicense(currentUser.getLicense());
				contract.setRent(currentcar.getRent());
				contract.setUserID(currentUser.getUserID());

				try {
					new ContractDAOImpl().addContract(contract);
					currentcar.setNumber(currentcar.getNumber()-1);
					new CarDAOImpl().update(currentcar);
				} catch (Exception e1) {
				}
				JOptionPane.showMessageDialog(null, "预定成功！");
				panel.setVisible(false);
				panel_on_rent2.setVisible(false);
				panel_on_rent.setVisible(true);
				textField_on_rent_name.setText("");
				textField_on_rent_idcard.setText("");
				textField_on_rent_license.setText("");
				textField_on_rent_phone.setText("");
//				new ManageRent().setVisible(true);
			}
		});
		comformbutton.setBounds(639, 304, 93, 23);
		panel.add(comformbutton);

		JButton button_1 = new JButton("\u4E0A\u4E00\u6B65");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_on_rent2.setVisible(true);
			}
		});
		button_1.setBounds(536, 304, 93, 23);
		panel.add(button_1);
		panel_ALLOrder.setBackground(Color.WHITE);
		panel_ALLOrder.setBounds(-2, 0, 742, 488);
		contentPane.add(panel_ALLOrder);
		panel_ALLOrder.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 722, 317);
		panel_ALLOrder.add(scrollPane_1);

		table_show_orders = new JTable();
		table_show_orders.setModel(new DefaultTableModel(new Object[][] {}, columnName_on_orders) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_show_orders.getColumnModel().getColumn(2).setPreferredWidth(143);
		table_show_orders.getColumnModel().getColumn(3).setPreferredWidth(133);
		table_show_orders.getColumnModel().getColumn(4).setPreferredWidth(107);
		scrollPane_1.setViewportView(table_show_orders);
		// panel_on_rent2.
		panel_on_rent2.setBackground(Color.LIGHT_GRAY);
		panel_on_rent2.setBounds(0, 0, 742, 488);
		contentPane.add(panel_on_rent2);
		panel_on_rent2.setLayout(null);

		JLabel label_5 = new JLabel("\u54C1\u724C");
		label_5.setBounds(10, 10, 34, 15);
		panel_on_rent2.add(label_5);

		comboBox_blank = new JComboBox();
		comboBox_blank.setFocusTraversalKeysEnabled(false);
		comboBox_blank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List list = null;
				if (!comboBox_blank.getSelectedItem().equals("全部")) {
					comboBox_type.setEnabled(false);
					try {
						list = new CarDAOImpl().queryByKey((String) comboBox_blank.getSelectedItem());
					} catch (Exception e1) {
					}
					loadCarInfo(list, table_on_chosecar);
				} else {
					loadCarInfo(table_on_chosecar);
					comboBox_type.setEnabled(true);
				}

			}
		});
		comboBox_blank.setBounds(39, 7, 93, 21);
		panel_on_rent2.add(comboBox_blank);

		JLabel label_6 = new JLabel("\u7C7B\u578B");
		label_6.setBounds(168, 10, 34, 15);
		panel_on_rent2.add(label_6);

		comboBox_type = new JComboBox();
		comboBox_type.setFocusTraversalKeysEnabled(false);
		comboBox_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List list = null;
				if (!comboBox_type.getSelectedItem().equals("全部")) {
					comboBox_blank.setEnabled(false);
					try {
						list = new CarDAOImpl().queryByKey((String) comboBox_type.getSelectedItem());
					} catch (Exception e1) {
					}
					loadCarInfo(list, table_on_chosecar);
				} else {
					loadCarInfo(table_on_chosecar);
					comboBox_blank.setEnabled(true);
				}
			}
		});
		comboBox_type.setBounds(195, 7, 93, 21);
		panel_on_rent2.add(comboBox_type);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 722, 292);
		panel_on_rent2.add(scrollPane);

		table_on_chosecar = new JTable();
		table_on_chosecar.setModel(new DefaultTableModel(new Object[][] {}, columnName) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_on_chosecar.getColumnModel().getColumn(0).setPreferredWidth(74);
		scrollPane.setViewportView(table_on_chosecar);

		JButton btnNewButton_1 = new JButton("\u9009\u62E9");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TableModel tableModel = table_on_chosecar.getModel();
				currentcar = null;
				User user = currentUser;
				int selected = table_on_chosecar.getSelectedRow();
				String carName = (String) tableModel.getValueAt(selected, 1);
				String brank = (String) tableModel.getValueAt(selected, 2);
				String type = (String) tableModel.getValueAt(selected, 3);
				String carInfo = (String) tableModel.getValueAt(selected, 4);
				int number = Integer.parseInt(tableModel.getValueAt(selected, 5).toString());
				if (number > 0) {

					for (Car car2 : allCarlist) {
						if (car2.getBrank().equals(brank) && car2.getCarName().equals(carName)
								&& car2.getCarInfo().equals(carInfo) && car2.getType().equals(type)) {
							currentcar = car2;
							break;
						}
					}
					user.setCarID(currentcar.getCarID());
					currentUser = user;

					panel.setVisible(true);
					panel_on_rent.setVisible(false);
					panel_on_rent2.setVisible(false);

					lblname.setText("姓名：" + user.getName());
					lbllicense.setText("身份证：" + user.getLicense());
					lblcar.setText(currentcar.getBrank() + currentcar.getCarName());
					lblrent.setText("租金标准：" + currentcar.getRent() + "/日");
				} else {

				}

				// comformbutton.addActionListener(new ActionListener() {
				//
				// @Override
				// public void actionPerformed(ActionEvent e) {
				//
				// }
				// });
			}
		});
		btnNewButton_1.setBounds(639, 6, 93, 23);
		panel_on_rent2.add(btnNewButton_1);

		JButton button = new JButton("\u4E0A\u4E00\u6B65");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_on_rent.setVisible(true);
				panel_on_rent2.setVisible(false);
			}
		});
		button.setBounds(536, 6, 93, 23);
		panel_on_rent2.add(button);

		panel_on_rent = new JPanel();
		panel_on_rent.setBounds(0, 0, 740, 488);
		contentPane.add(panel_on_rent);
		panel_on_rent.setBackground(Color.WHITE);
		panel_on_rent.setLayout(null);

		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(203, 103, 54, 15);
		panel_on_rent.add(label_1);

		JLabel label_2 = new JLabel("\u9A7E\u9A76\u8BC1\uFF1A");
		label_2.setBounds(203, 182, 54, 15);
		panel_on_rent.add(label_2);

		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1\uFF1A");
		label_3.setBounds(203, 222, 54, 15);
		panel_on_rent.add(label_3);

		JLabel label_4 = new JLabel("\u624B\u673A\uFF1A");
		label_4.setBounds(203, 142, 54, 15);
		panel_on_rent.add(label_4);

		textField_on_rent_name = new JTextField();
		textField_on_rent_name.setBounds(267, 100, 186, 21);
		panel_on_rent.add(textField_on_rent_name);
		textField_on_rent_name.setColumns(10);

		textField_on_rent_phone = new JTextField();
		textField_on_rent_phone.setColumns(10);
		textField_on_rent_phone.setBounds(267, 139, 186, 21);
		panel_on_rent.add(textField_on_rent_phone);

		textField_on_rent_license = new JTextField();
		textField_on_rent_license.setColumns(10);
		textField_on_rent_license.setBounds(267, 179, 186, 21);
		panel_on_rent.add(textField_on_rent_license);

		textField_on_rent_idcard = new JTextField();
		textField_on_rent_idcard.setColumns(10);
		textField_on_rent_idcard.setBounds(267, 219, 186, 21);
		panel_on_rent.add(textField_on_rent_idcard);

		label_err_message = new JLabel("");
		label_err_message.setBounds(406, 196, 136, 15);
		panel_on_rent.add(label_err_message);

		JButton btnNewButton = new JButton("\u9009\u8F66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vailddate();
			}
		});
		btnNewButton.setBounds(283, 338, 93, 23);
		panel_on_rent.add(btnNewButton);

//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.decode("#ffff00"));
//		panel_1.setBounds(0, 0, 742, 153);
//		contentPane.add(panel_1);
//		panel_1.setLayout(null);

//		JLabel lblNewLabel = new JLabel("\u8FD4\u56DE");
//		lblNewLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Main.frame.setVisible(true);
//				dispose();
//			}
//		});
//		lblNewLabel.setBounds(10, 0, 31, 42);
//		panel_1.add(lblNewLabel);
//
//		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(ManageRent.class.getResource("/image/app/timg.jpg")));
//		label.setBounds(20, 0, 643, 153);
//		panel_1.add(label);
//		setLocationRelativeTo(null);
		initPanel();
	}

	protected void vailddate() {
		currentUser = null;
		boolean flag = false;
		String name = textField_on_rent_name.getText();
		String phone = textField_on_rent_phone.getText();
		String license = textField_on_rent_license.getText();
		String idcard = textField_on_rent_idcard.getText();
		if (stringUtil.isEmpty(name) || stringUtil.isEmpty(phone) || stringUtil.isEmpty(license)
				|| stringUtil.isEmpty(idcard)) {
			label_err_message.setText("信息不能为空");
			flag = true;
		}
		if (!flag) {
			try {
				if (new UserDAOImpl().queryByKeyword(idcard) != null) {
					currentUser = new UserDAOImpl().queryByKeyword(idcard);
				} else if (new UserDAOImpl().queryByKeyword(phone) != null) {
					currentUser = new UserDAOImpl().queryByKeyword(phone);
				} else {
					// 判断其他信息是否一致 是使用 否新建一个
					currentUser = new User();
					currentUser.setName(name);
					currentUser.setPhone(phone);
					currentUser.setLicense(license);
					currentUser.setIDCard(idcard);
				}
			} catch (Exception e) {
			}
			panel_on_rent.setVisible(false);
			panel_on_rent2.setVisible(true);
			loadCarInfo(table_on_chosecar);
		}
	}

	public void loadCarInfo(JTable table) {
		allCarlist = null;
		Vector<String> vector_columnName = new Vector<>();
		Vector<Object> vector_cells = null;
		Vector<Vector<Object>> rowdata = new Vector<>();
		try {
			allCarlist = new CarDAOImpl().queryALL();
		} catch (Exception e) {
		}
		if (allCarlist != null) {
			// 表头
			for (String string : columnName) {
				vector_columnName.add(string);
			}
			// 内容
			for (Car car : allCarlist) {
				vector_cells = new Vector<>();
				vector_cells.add(car.getCarID());
				vector_cells.add(car.getCarName());
				vector_cells.add(car.getBrank());
				vector_cells.add(car.getType());
				vector_cells.add(car.getCarInfo());
				vector_cells.add(car.getNumber());
				rowdata.add(vector_cells);
			}
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowdata, vector_columnName);
		table.setModel(defaultTableModel);
	}

	public void loadCarInfo(List<Car> list, JTable table) {
		Vector<String> vector_columnName = new Vector<>();
		Vector<Object> vector_cells = null;
		Vector<Vector<Object>> rowdata = new Vector<>();
		if (list != null) {
			// 表头
			for (String string : columnName) {
				vector_columnName.add(string);
			}
			// 内容
			for (Car car : list) {
				vector_cells = new Vector<>();
				vector_cells.add(car.getCarID());
				vector_cells.add(car.getCarName());
				vector_cells.add(car.getBrank());
				vector_cells.add(car.getType());
				vector_cells.add(car.getCarInfo());
				vector_cells.add(car.getNumber());
				rowdata.add(vector_cells);
			}
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowdata, vector_columnName);
		table.setModel(defaultTableModel);
	}

	public void initPanel() {
		List<String> list = null;
		List<String> listtype = null;
		List<String> listcarinfo = null;
		comboBox_blank.addItem("全部");
		comboBox_type.addItem("全部");
		try {
			list = new CarDAOImpl().getCarBrankList();
			listcarinfo = new CarDAOImpl().getCarInfo();
			listtype = new CarDAOImpl().getCarTypeList();
		} catch (Exception e) {
		}
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				comboBox_blank.addItem(list.get(i));
			}
		}
		if (listcarinfo != null || listtype != null) {
			for (int i = 0; i < listcarinfo.size(); i++) {
				comboBox_type.addItem(listcarinfo.get(i));
			}
			for (int i = 0; i < listtype.size(); i++) {
				comboBox_type.addItem(listtype.get(i));
			}
		}
	}

	public void showAllContract() {
		panel_on_rent.setVisible(false);
		panel_on_rent2.setVisible(false);
		panel.setVisible(false);
		panel_ALLOrder.setVisible(true);
		List<SelectOnContractModel> list = null;
		Vector<String> vector_columnName = new Vector<>();
		Vector<Object> vector_cells = new Vector<>();
		Vector<Vector<Object>> rowdata = new Vector<>();
		try {
			list = new ContractDAOImpl().queryall();
		} catch (Exception e) {
		}
		if (allCarlist != null) {
			// 表头
			for (String string : columnName_on_orders) {
				vector_columnName.add(string);
			}
			// 内容
			for (SelectOnContractModel s : list) {
				vector_cells = new Vector<>();
				vector_cells.add(s.getCarName());
				vector_cells.add(s.getName());
				vector_cells.add(s.getLicense());
				vector_cells.add(s.getDate());
				vector_cells.add(s.getRent());
				rowdata.add(vector_cells);
			}
		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowdata, vector_columnName);
		table_show_orders.setModel(defaultTableModel);

	}
}
