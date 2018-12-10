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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.java.model.Car;
import com.java.model.CarDAOImpl;


public class CarQuery extends JPanel {
	CarDAOImpl carDAOImpl = new CarDAOImpl();
	private JTable table;

	private JTextField tf_id;
	
	private String[] heads = { "车ID", "车名", "座位数", "品牌", "类型", "租金","数量"};

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

	public CarQuery() throws Exception {
		
//		super();
		this.setPreferredSize(new Dimension(740, 475));
		final BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
//		setTitle("车辆信息查询");
//		setBounds(100, 100, 593, 406);

		final JPanel panel_cx = new JPanel();
		this.add(panel_cx, BorderLayout.NORTH);

		panel_cx.setLayout(new GridLayout(1, 3));
		JLabel lb_name = new JLabel("车辆编号：");
		lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id = new JTextField();
		JButton btn_cx = new JButton("查询");
		btn_cx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btn_cxActionPerformed(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		panel_cx.add(lb_name);
		panel_cx.add(tf_id);
		panel_cx.add(btn_cx);

		final JPanel panel_2 = new JPanel();
		final BorderLayout borderLayout_1 = new BorderLayout();
		borderLayout_1.setVgap(5);
		panel_2.setLayout(borderLayout_1);
		panel_2.setBorder(new EmptyBorder(5, 10, 5, 10));
		this.add(panel_2);

		final JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		Object[][] results = getResult(carDAOImpl.selectCarList("select *  from t_car"));
		table = new JTable(results, heads);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);

//		setSize(564, 425);
//		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	private void btn_cxActionPerformed(ActionEvent e) throws Exception {
		String carid = tf_id.getText(); // 获取车辆编号

		// 根据查询条件构建sql
		String sql = "select *  from t_car";
		if (carid != null && carid.length() > 0) {
			
			sql = "select *  from t_car where carID like '%" + carid + "%'";
		}

		// 执行查询操作，将查询结果显示到界面
		Object[][] results = getResult(carDAOImpl.selectCarList(sql));
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setDataVector(results, heads);
	}
}

