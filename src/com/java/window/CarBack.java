package com.java.window;

import java.awt.BorderLayout;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import com.java.model.Car;
import com.java.model.CarDAOImpl;
import com.java.model.ContractDAOImpl;
import com.java.model.SelectOnContractModel;


public class CarBack extends JFrame {
	CarDAOImpl carDAOImpl = new CarDAOImpl();
	ManageRent manageRent = new ManageRent();
	private JTable table;

	private String[] heads = { "车名", "客户姓名", "驾驶证", "合同日期", "租金" };
	private JPanel panel_table;
	private JPanel panel_close;
	private JButton btn_close;
	private JPanel panel_query;
	private JButton btn_update;
	private ContractDAOImpl contractDAOImpl = new ContractDAOImpl();

	public static Car car;
	private JLabel lb_queryByLicense;
	private JTextField tf_queryByLicense;

	private Object[][] getResult(List list) {
		Object[][] results = new Object[list.size()][heads.length];
		for (int i = 0; i < list.size(); i++) {

			SelectOnContractModel selectOnContractModel = (SelectOnContractModel) list.get(i);

			results[i][0] = selectOnContractModel.getCarName();
			results[i][1] = selectOnContractModel.getName();
			results[i][2] = selectOnContractModel.getLicense();
			results[i][3] = selectOnContractModel.getDate();
			results[i][4] = selectOnContractModel.getRent();
			

		}
		return results;
	}

	public CarBack() throws Exception {

		super();
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setTitle("\u8FD8\u8F66");
		setBounds(100, 100, 593, 406);

		panel_query = new JPanel();
		getContentPane().add(panel_query, BorderLayout.NORTH);

		panel_query.setLayout(new GridLayout(1, 3));
		
		lb_queryByLicense = new JLabel("\u6309\u9A7E\u9A76\u8BC1\u67E5\u627E\uFF1A");
		lb_queryByLicense.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_query.add(lb_queryByLicense);
		
		tf_queryByLicense = new JTextField();
		tf_queryByLicense.setColumns(10);
		Document dt = tf_queryByLicense.getDocument();
		dt.addDocumentListener(new DocumentListener() {
			
			private String license;

			@Override
			public void removeUpdate(DocumentEvent e) {
				license = tf_queryByLicense.getText();

			

				// 执行查询操作，将查询结果显示到界面
				Object[][] results = null;
				try {
					results = getResult(contractDAOImpl.queryByLicense(license));
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				DefaultTableModel model = new DefaultTableModel();
				table.setModel(model);
				model.setDataVector(results, heads);
			
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		panel_query.add(tf_queryByLicense);

		panel_table = new JPanel();
		final BorderLayout bl_panel_table = new BorderLayout();
		bl_panel_table.setVgap(5);
		panel_table.setLayout(bl_panel_table);
		panel_table.setBorder(new EmptyBorder(5, 10, 5, 10));
		getContentPane().add(panel_table);

		final JScrollPane scrollPane = new JScrollPane();
		panel_table.add(scrollPane);

		Object[][] results = getResult(contractDAOImpl.queryall());
		table = new JTable(results, heads);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);

		panel_close = new JPanel();
		panel_close.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		getContentPane().add(panel_close, BorderLayout.SOUTH);
		final FlowLayout fl_panel_close = new FlowLayout();
		fl_panel_close.setVgap(2);
		fl_panel_close.setHgap(10);
		fl_panel_close.setAlignment(FlowLayout.RIGHT);
		panel_close.setLayout(fl_panel_close);

		btn_close = new JButton();
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
				Main.frame.setVisible(true);
			}
		});

		btn_update = new JButton("\u786E\u8BA4\u8FD8\u8F66");
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
		panel_close.add(btn_update);
		btn_close.setText("\u8FD4\u56DE");
		panel_close.add(btn_close);

		setSize(564, 425);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	protected void btn_updateActionPerformed(ActionEvent e) throws Exception {
		
	
		
		
	}

}
