package com.java.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.java.mainView.CustSkinPanel;
import com.java.model.Car;
import com.java.model.CarDAOImpl;;

public class CarUpdate extends JPanel {
	CarDAOImpl carDAOImpl = new CarDAOImpl();
	ManageRent manageRent = new ManageRent();
	private JTable table;

	private String[] heads = { "车ID", "车名", "座位数", "品牌", "类型", "租金", "数量" };
	private JComboBox cb_car_brank;
	private JLabel lb_car_number;
	private JComboBox cb_car_number;
	private JPanel panel_table;
	private JButton button_1;
	private JLabel lb_car_brank;
	private JPanel panel_query;
	private JButton btn_update;
	private int flag_brank = 0;
	private int flag_num = 0;
	public static Car car;

	private Object[][] getResult(List list) {
		Object[][] results = new Object[list.size()][heads.length];
		for (int i = 0; i < list.size(); i++) {

			Car car = (Car) list.get(i);

			results[i][0] = car.getCarID();
			results[i][1] = car.getCarName();
			results[i][2] = car.getType();
			results[i][3] = car.getBrank();
			results[i][4] = car.getCarInfo();
			results[i][5] = car.getRent();
			results[i][6] = car.getNumber();

		}
		return results;
	}

	public CarUpdate() throws Exception {

//		super();
		final BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
//		setTitle("\u8F66\u8F86\u4FE1\u606F\u4FEE\u6539");
		this.setPreferredSize(new Dimension(740, 475));

		panel_query = new JPanel();
		this.add(panel_query, BorderLayout.NORTH);

		panel_query.setLayout(new GridLayout(1, 3));
		lb_car_brank = new JLabel("\u8F66\u8F86\u54C1\u724C\uFF1A");
		lb_car_brank.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_query.add(lb_car_brank);

		cb_car_brank = new JComboBox();
		cb_car_brank.addItem("全部");
		List brankList = carDAOImpl.getCarBrankList();
		for (int i = 0; i < brankList.size(); i++) {
			cb_car_brank.addItem(brankList.get(i));
		}
		cb_car_brank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List list = null;
				if (cb_car_brank.getSelectedItem().equals("全部")){
					flag_brank = 0;
				}else{
					flag_brank = 1;
				}
				if (flag_brank == 0&&flag_num == 0) {
					
					manageRent.loadCarInfo(table);
					
				} else if(flag_brank == 1&&flag_num == 0){
					
					try {
						list = new CarDAOImpl().queryByKey((String) cb_car_brank.getSelectedItem());
					} catch (Exception e1) {
					}
					manageRent.loadCarInfo(list, table);
					
				}else if(flag_brank == 0&&flag_num == 1){
					try {
						list = new CarDAOImpl().queryByKey((String) cb_car_number.getSelectedItem());
					} catch (Exception e1) {
					}
					manageRent.loadCarInfo(list, table);
				}
				else{  	//两个条件
					try {
						list = new CarDAOImpl().queryByKey((String) cb_car_brank.getSelectedItem(),(String) cb_car_number.getSelectedItem());
					} catch (Exception e1) {
					}
					manageRent.loadCarInfo(list, table);
					
				}
			}
		});
		panel_query.add(cb_car_brank);

		lb_car_number = new JLabel("\u5EA7\u4F4D\u6570\uFF1A");
		lb_car_number.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_query.add(lb_car_number);

		cb_car_number = new JComboBox();
		cb_car_number.addItem("全部");

		List numList = carDAOImpl.getCarTypeList();
		for (int i = 0; i < numList.size(); i++) {
			cb_car_number.addItem(numList.get(i));
		}
		cb_car_number.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List list = null;
				if (cb_car_number.getSelectedItem().equals("全部")){
					flag_num = 0;
				}else{
					flag_num = 1;
				}
				if (flag_brank == 0&&flag_num == 0) {
					
					manageRent.loadCarInfo(table);
					
				} else if(flag_brank == 0&&flag_num == 1){
					
					try {
						list = new CarDAOImpl().queryByKey((String) cb_car_number.getSelectedItem());
					} catch (Exception e1) {
					}
					manageRent.loadCarInfo(list, table);
					
				}else if(flag_brank == 1&&flag_num == 0){
					try {
						list = new CarDAOImpl().queryByKey((String) cb_car_brank.getSelectedItem());
					} catch (Exception e1) {
					}
					manageRent.loadCarInfo(list, table);
				}
				else{  	//两个条件
					try {
						list = new CarDAOImpl().queryByKey((String) cb_car_brank.getSelectedItem(),(String) cb_car_number.getSelectedItem());
					} catch (Exception e1) {
					}
					manageRent.loadCarInfo(list, table);
					
				}
			}
		});
		panel_query.add(cb_car_number);
		
		//		button_1 = new JButton();
		//		button_1.addActionListener(new ActionListener() {
		//			public void actionPerformed(final ActionEvent e) {
		//				dispose();
		//				Main.frame.setVisible(true);
		//			}
		//		});
		
				btn_update = new JButton("\u4FEE\u6539\u9009\u4E2D\u8F66\u578B");
				panel_query.add(btn_update);
				btn_update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							btn_updateActionPerformed(e);
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					}
				});

		panel_table = new JPanel();
		final BorderLayout bl_panel_table = new BorderLayout();
		bl_panel_table.setVgap(5);
		panel_table.setLayout(bl_panel_table);
		panel_table.setBorder(new EmptyBorder(5, 10, 5, 10));
		this.add(panel_table,BorderLayout.CENTER);

		final JScrollPane scrollPane = new JScrollPane();
		panel_table.add(scrollPane);

		Object[][] results = getResult(carDAOImpl.selectCarList("select *  from t_car"));
		table = new JTable(results, heads);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
//		button_1.setText("\u8FD4\u56DE");
//		panel_close.add(button_1);

//		setSize(564, 425);
//		setLocationRelativeTo(getOwner());
//		setVisible(true);
	}

	protected void btn_updateActionPerformed(ActionEvent e) throws Exception {
		
		int index =  table.getSelectedRow();
		int carID  = (int) table.getValueAt(index, 0);
		String sql = "select * from t_car where carID = "+carID;
		car = carDAOImpl.selectCar(sql);
		(new CarUpdate_change()).setVisible(true);
		
		
		
	}

}
