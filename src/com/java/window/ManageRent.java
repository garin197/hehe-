package com.java.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.model.User;
import com.java.model.UserDAOImpl;
import com.java.util.stringUtil;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageRent extends JFrame {

	private JPanel contentPane;
	private JTextField textField_on_rent_name;
	private JTextField textField_on_rent_phone;
	private JTextField textField_on_rent_license;
	private JTextField textField_on_rent_idcard;
	private JLabel label_err_message;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ManageRent() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setType(Type.POPUP);
		setBackground(Color.WHITE);
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(100, 100, 748, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/app\u56FE\u6807.png")));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		contentPane.setLayout(null);

		JPanel panel_on_rent = new JPanel();
		panel_on_rent.setBounds(0, 151, 740, 337);
		contentPane.add(panel_on_rent);
		panel_on_rent.setBackground(Color.WHITE);
		panel_on_rent.setLayout(null);

		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(329, 27, 54, 15);
		panel_on_rent.add(label_1);

		JLabel label_2 = new JLabel("\u9A7E\u9A76\u8BC1\uFF1A");
		label_2.setBounds(329, 106, 54, 15);
		panel_on_rent.add(label_2);

		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1\uFF1A");
		label_3.setBounds(329, 146, 54, 15);
		panel_on_rent.add(label_3);

		JLabel label_4 = new JLabel("\u624B\u673A\uFF1A");
		label_4.setBounds(329, 66, 54, 15);
		panel_on_rent.add(label_4);

		textField_on_rent_name = new JTextField();
		textField_on_rent_name.setBounds(372, 24, 186, 21);
		panel_on_rent.add(textField_on_rent_name);
		textField_on_rent_name.setColumns(10);

		textField_on_rent_phone = new JTextField();
		textField_on_rent_phone.setColumns(10);
		textField_on_rent_phone.setBounds(372, 63, 186, 21);
		panel_on_rent.add(textField_on_rent_phone);

		textField_on_rent_license = new JTextField();
		textField_on_rent_license.setColumns(10);
		textField_on_rent_license.setBounds(372, 103, 186, 21);
		panel_on_rent.add(textField_on_rent_license);

		textField_on_rent_idcard = new JTextField();
		textField_on_rent_idcard.setColumns(10);
		textField_on_rent_idcard.setBounds(372, 143, 186, 21);
		panel_on_rent.add(textField_on_rent_idcard);

		label_err_message = new JLabel("");
		label_err_message.setBounds(406, 196, 54, 15);
		panel_on_rent.add(label_err_message);

		JButton btnNewButton = new JButton("\u9009\u8F66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vailddate();
			}
		});
		btnNewButton.setBounds(637, 304, 93, 23);
		panel_on_rent.add(btnNewButton);

		JPanel panel_on_rent2 = new JPanel();
		panel_on_rent2.setBackground(Color.WHITE);
		panel_on_rent2.setBounds(0, 151, 742, 337);
		contentPane.add(panel_on_rent2);
		panel_on_rent2.setLayout(null);

		JLabel label_5 = new JLabel("\u54C1\u724C");
		label_5.setBounds(10, 10, 34, 15);
		panel_on_rent2.add(label_5);

		JComboBox comboBox_blank = new JComboBox();
		comboBox_blank.setBounds(39, 7, 70, 21);
		panel_on_rent2.add(comboBox_blank);

		JLabel label_6 = new JLabel("\u7C7B\u578B");
		label_6.setBounds(168, 10, 34, 15);
		panel_on_rent2.add(label_6);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(195, 7, 70, 21);
		panel_on_rent2.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#ffff00"));
		panel_1.setBounds(0, 0, 742, 153);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8FD4\u56DE");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setBounds(10, 0, 31, 42);
		panel_1.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManageRent.class.getResource("/image/app/timg.jpg")));
		label.setBounds(20, 0, 643, 153);
		panel_1.add(label);
		setLocationRelativeTo(null);

	}

	protected void vailddate() {
		User user = null;
		boolean flag = false;
		String name = textField_on_rent_name.getText();
		String phone = textField_on_rent_phone.getText();
		String license = textField_on_rent_license.getText();
		String idcard = textField_on_rent_idcard.getText();
		try {
			user = new UserDAOImpl().queryByKeyword(idcard);
			if (user == null) {
				user = new UserDAOImpl().queryByKeyword(phone);
			} else {
				//判断其他信息是否一致 是使用 否新建一个
				
			}

		} catch (Exception e) {
		}
		if (stringUtil.isEmpty(name)) {
			label_err_message.setText("*");
			flag = true;
		}
	}
}
