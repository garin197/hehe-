package com.java.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.UserDAO;
import com.java.model.User;
import com.java.model.UserDAOImpl;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageUser extends JFrame {

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
		
		panel_deleteuser = new JPanel();
		panel_deleteuser.setVisible(false);
		panel_deleteuser.setBackground(Color.WHITE);
		panel_deleteuser.setBounds(0, 131, 742, 357);
		contentPane.add(panel_deleteuser);
		
		JLabel lblP_1 = new JLabel("p2");
		panel_deleteuser.add(lblP_1);
		
		panel_adduser = new JPanel();
		panel_adduser.setVisible(false);
		panel_adduser.setBackground(Color.WHITE);
		panel_adduser.setBounds(0, 131, 742, 357);
		contentPane.add(panel_adduser);
		
		JLabel lblP = new JLabel("");
		lblP.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u589E\u52A0user.png")));
		panel_adduser.add(lblP);
		
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
//		panel_welcomeinmanageruser.setVisible(true);
//		panel_updateuser.setVisible(false);
//		panel_adduser.setVisible(false);
//		panel_deleteuser.setVisible(false);;
//		panel_queryall.setVisible(false);
//		panel_querybykey.setVisible(false);
	}
	
	public void queryUsersInfo(String key) {
		
		UserDAO userDAO=new UserDAOImpl();
		User user=null;
		try {
		user=userDAO.queryByKeyword(key);
		if (user==null) {
			result_img.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u6CA1\u627E\u5230.jpg")));
			result_img.setBounds(0, 5, 778, 441);
		}else {
			result_img.setSize(212, 282);
			result_img.setLocation(10, 10);
			result_img.setIcon(new ImageIcon(ManageUser.class.getResource("/image/app/\u5934\u50CF.jpg")));
		}
		tf_userinfo_id.setText(""+user.getUserID());
		tf_userinfo_license.setText(""+user.getLicense());
		tf_userinfo_name.setText(""+user.getName());
		tf_userinfo_phone.setText(""+user.getPhone());
		StringBuffer string=new StringBuffer(user.getIDCard());
		string.replace(0+6, 0+6+6, "******");
		tf_userinfo_idcard.setText(""+string);
		//440782 xxxxxx 111111
		} catch (Exception e) {
		}
	}
	private void doDispise() {
		this.dispose();
	}
}
