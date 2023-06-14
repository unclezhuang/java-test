package com.artisan.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.VisitorDao;
import com.artisan.dao.EnterpriseDao;
import com.artisan.model.Enterprise;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;

public class EnterpriseManageInterFrm extends JInternalFrame {
	private JTable enterpriseTable;
	private JTextArea departmentTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private EnterpriseDao enterpriseDao =new EnterpriseDao();
	private VisitorDao visitorDao =new VisitorDao();
	private JTextField v_enterpriseNameTxt;
	private JTextField idTxt;
	private JTextField enterpriseNameTxt;


	/**
	 * Create the frame.
	 */
	public EnterpriseManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("企业信息管理界面");
		setBounds(100, 100, 507, 481);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("企业信息名称");
		
		v_enterpriseNameTxt = new JTextField();
		v_enterpriseNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterpriseSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(EnterpriseManageInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(v_enterpriseNameTxt, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(v_enterpriseNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(39)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("企业信息名称");
		
		enterpriseNameTxt = new JTextField();
		enterpriseNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		departmentTxt = new JTextArea();
		departmentTxt.setLineWrap(true);
		departmentTxt.setWrapStyleWord(true);
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterpriseUpdateActionEvent(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(EnterpriseManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterpriseDeleteActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(EnterpriseManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(enterpriseNameTxt, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(departmentTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(26)
							.addComponent(btnNewButton_1)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(enterpriseNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(departmentTxt, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		enterpriseTable = new JTable();
		enterpriseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				enterpriseTableMousePressed(e);
			}
		});
		enterpriseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "企业信息名称", "部门"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		enterpriseTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		enterpriseTable.getColumnModel().getColumn(2).setPreferredWidth(123);
		scrollPane.setViewportView(enterpriseTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Enterprise());

		// 设置文本域边框
	    departmentTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	}
	
	/**
	 * 企业信息删除事件处理
	 * @param
	 */
	private void enterpriseDeleteActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				boolean flag= visitorDao.existVisitorByenterpriseId(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "当前企业信息不能删除");
					return;
				}
				int deleteNum= enterpriseDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Enterprise());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 企业信息修改事件处理
	 * @param evt
	 */
	private void enterpriseUpdateActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		String enterpriseName = enterpriseNameTxt.getText();
		String department = departmentTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(enterpriseName)){
			JOptionPane.showMessageDialog(null, "企业信息名称不能为空");
			return;
		}
		Enterprise bookType=new Enterprise(Integer.parseInt(id), enterpriseName, department);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int modifyNum= enterpriseDao.update(con, bookType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new Enterprise());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param
	 */
	private void enterpriseTableMousePressed(MouseEvent evt) {
		int row= enterpriseTable.getSelectedRow();
		idTxt.setText((String) enterpriseTable.getValueAt(row, 0));
		enterpriseNameTxt.setText((String) enterpriseTable.getValueAt(row, 1));
		departmentTxt.setText((String) enterpriseTable.getValueAt(row, 2));
	}

	/**
	 * 企业信息搜索事件处理
	 * @param evt
	 */
	private void enterpriseSearchActionPerformed(ActionEvent evt) {
		String v_enterpriseName =this.v_enterpriseNameTxt.getText();
		Enterprise enterprise =new Enterprise();
		enterprise.setEnterpriseName(v_enterpriseName);
		this.fillTable(enterprise);
	}

	/**
	 * 初始化表格
	 * @param enterprise
	 */
	private void fillTable(Enterprise enterprise){
		DefaultTableModel dtm=(DefaultTableModel) enterpriseTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs= enterpriseDao.list(con, enterprise);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("enterpriseName"));
				v.add(rs.getString("department"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.idTxt.setText("");
		this.enterpriseNameTxt.setText("");
		this.departmentTxt.setText("");
	}
}
