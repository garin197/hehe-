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
import javax.swing.JOptionPane;
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


public class CarBack extends JPanel {
	CarDAOImpl carDAOImpl = new CarDAOImpl();
	ManageRent manageRent = new ManageRent();
	private JTable table;

	private String[] heads = { "车名", "客户姓名", "驾驶证", "合同日期", "租金" };
	private JPanel panel_table;
	private JPanel panel_query;
	private JButton btn_update;
	private ContractDAOImpl contractDAOImpl = new ContractDAOImpl();

	public static Car car;
	private JLabel lb_queryByLicense;
	private JTextField tf_queryByLicense;
	private Object[][] results;

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

//		super();
		final BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setPreferredSize(new Dimension(740, 475));
//		setTitle("\u8FD8\u8F66");
//		setBounds(100, 100, 593, 406);

		panel_query = new JPanel();
		this.add(panel_query, BorderLayout.NORTH);

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
				
				if(license == null){
				
					try {
						results = getResult(contractDAOImpl.queryall());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					table = new JTable(results, heads);
				}else{
				// 执行查询操作，将查询结果显示到界面
				 results = null;
				try {
					results = getResult(contractDAOImpl.queryByLicense(license));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				DefaultTableModel model = new DefaultTableModel();
				table.setModel(model);
				model.setDataVector(results, heads);
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				license = tf_queryByLicense.getText();

				if(license == null){
					
					try {
						results = getResult(contractDAOImpl.queryall());
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					table = new JTable(results, heads);
				}else{
					
				// 执行查询操作，将查询结果显示到界面
				results = null;
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
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		panel_query.add(tf_queryByLicense);
		
				btn_update = new JButton("\u786E\u8BA4\u8FD8\u8F66");
				panel_query.add(btn_update);
				btn_update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							btn_delActionPerformed(e);
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
		this.add(panel_table);

		final JScrollPane scrollPane = new JScrollPane();
		panel_table.add(scrollPane);
		
		results = getResult(contractDAOImpl.queryall());
		table = new JTable(results, heads);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
//
//		setSize(564, 425);
//		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	protected void btn_delActionPerformed(ActionEvent e) throws Exception {
		int fin = 0;
		int i = table.getSelectedRow();
		String license =  (String) table.getValueAt(i, 2);
		
		fin = contractDAOImpl.delContract(license);
		
		if (fin ==1 ) {
			JOptionPane.showMessageDialog(null, "还车成功");
			try {
				results = getResult(contractDAOImpl.queryall());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
//			DefaultTableModel DefaultTableModel
			table = new JTable(results, heads);
			update(getGraphics());
//			this.dispose();
//			Main.frame.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "还车失败");
		}
	
		
		
	}

}
