package com.java.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.java.model.Car;
import com.java.model.CarDAOImpl;
import com.java.model.ContractDAOImpl;


public class CarDelete extends JFrame {
	private ContractDAOImpl contractDAOImpl = new ContractDAOImpl();
	private CarDAOImpl carDAOImpl = new CarDAOImpl();
	private JTable table;


	private String[] heads = { "车ID", "车名", "座位数", "品牌", "类型", "租金", "数量", "是否租出" };

	private int[] carid;
	private int[] exist;

	private Object[][] del_getResult(List list) {
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

	@SuppressWarnings("serial")
	public CarDelete() throws Exception {

		super();
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setTitle("车辆信息查询");
		setBounds(100, 100, 593, 406);

		final JPanel panel_2 = new JPanel();
		final BorderLayout borderLayout_1 = new BorderLayout();
		borderLayout_1.setVgap(5);
		panel_2.setLayout(borderLayout_1);
		panel_2.setBorder(new EmptyBorder(5, 10, 5, 10));
		getContentPane().add(panel_2);

		final JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		Object[][] results = del_getResult(carDAOImpl.selectCarList("select *  from t_car"));
		table = new JTable();
		table.setModel(new DefaultTableModel(results,heads) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		carid = new int[table.getRowCount() + 1];
		exist = new int[table.getRowCount() + 1];
		for (int i = 0; i < table.getRowCount(); i++) {
			carid[i] = (int) table.getValueAt(i, 0);
			exist[i] = contractDAOImpl.exist_carId_in_contract(carid[i]);
			if (exist[i] == 1) {
				table.setValueAt("是", i, 7);
			}else
				table.setValueAt("否", i, 7);
				
		}
		scrollPane.setViewportView(table);

		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setLayout(flowLayout);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
				Main.frame.setVisible(true);
			}
		});

		JLabel lb_del_choose = new JLabel("\u522A\u9664\u9078\u4E2D\u7684\u8ECA\u578B");
		lb_del_choose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					lb_del_chooseMouseClicked(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(lb_del_choose);
		button_1.setText("\u8FD4\u56DE");
		panel_1.add(button_1);

		setSize(564, 425);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	protected void lb_del_chooseMouseClicked(MouseEvent e) throws Exception {

		int fin = 0;
		int i = table.getSelectedRow();
		int carID = (int) table.getValueAt(i, 0);
		if (table.getValueAt(i, 7).equals("是")) {
			JOptionPane.showMessageDialog(null, "此车型正在出租，无法删除信息，请重试！！");
		} else{			
			fin = carDAOImpl.delete(carID);
		}

		if (fin == 1) {
			JOptionPane.showMessageDialog(null, "删除成功");
			dispose();
			Main.frame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "删除失败");
		}

	}

}
