package com.artisan.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import com.artisan.model.Visitor;
import com.artisan.model.Enterprise;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;

public class VisitorManageInterFrm extends JInternalFrame {
	private JTable visitorTable;
	private JTextField v_nameTxt;
	private JTextField v_numberTxt;
	private JComboBox v_enterpriseJcb;
	private JRadioButton manJrb ;
	private JRadioButton femaleJrb ;
	private JTextArea addressTxt;
	private JComboBox enterpriseJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private EnterpriseDao enterpriseDao =new EnterpriseDao();
	private VisitorDao visitorDao =new VisitorDao();
	private JTextField idTxt;
	private JTextField nameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField reasonTxt;
	private JTextField numberTxt;


	/**
	 * Create the frame.
	 */
	public VisitorManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("企业访客管理主界面");
		setBounds(100, 100, 677, 487);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane)))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("访客姓名");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("访客性别");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_4 = new JLabel("来访缘由");
		
		reasonTxt = new JTextField();
		reasonTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("访客电话号码");
		
		numberTxt = new JTextField();
		numberTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("所属企业");
		
		enterpriseJcb = new JComboBox();
		
		JLabel label_6 = new JLabel("地址");
		
		addressTxt = new JTextArea();
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				visitorUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(VisitorManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				visitorDeleteActionPerformed(evt);
			}
		});
		button_2.setIcon(new ImageIcon(VisitorManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button_1)
							.addGap(18)
							.addComponent(button_2)
							.addGap(386))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(addressTxt))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(reasonTxt))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
									.addGap(26)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(numberTxt)))
									.addGap(26)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(manJrb)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(femaleJrb))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(enterpriseJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
							.addContainerGap(86, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(reasonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(enterpriseJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2)))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("访客姓名");
		
		v_nameTxt = new JTextField();
		v_nameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("访客编号");
		
		v_numberTxt = new JTextField();
		v_numberTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("所属企业");
		
		v_enterpriseJcb = new JComboBox();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(VisitorManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(v_nameTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(v_numberTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(v_enterpriseJcb, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(v_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(v_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(v_enterpriseJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(16))
		);
		panel.setLayout(gl_panel);
		
		visitorTable = new JTable();
		visitorTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				studentTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(visitorTable);
		visitorTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "访客姓名", "访客电话号码", "访客性别", "所属部门", "地址", "所属企业"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		visitorTable.getColumnModel().getColumn(5).setPreferredWidth(119);
		getContentPane().setLayout(groupLayout);

		// 设置文本域边框
	    addressTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

				
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Visitor());
	}
	
	/**
	 * 访客信息删除事件处理
	 * @param evt
	 */
	private void visitorDeleteActionPerformed(ActionEvent evt) {
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
				int deleteNum= visitorDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Visitor());
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
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 访客信息修改事件处理
	 * @param evt
	 */
	private void visitorUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		
		String vname =this.nameTxt.getText();
		String number =this.numberTxt.getText();
		String reason =this.reasonTxt.getText();
		String address=this.addressTxt.getText();
		
		if(StringUtil.isEmpty(vname)){
			JOptionPane.showMessageDialog(null, "访客信息姓名不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(number)){
			JOptionPane.showMessageDialog(null, "访客信息电话号码不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(reason)){
			JOptionPane.showMessageDialog(null, "学生信息来访缘由不能为空！");
			return;
		}
		
		String sex="";
		if(manJrb.isSelected()){
			sex="男";
		}else if(femaleJrb.isSelected()){
			sex="女";
		}
		
		Enterprise enterpriseTmp =(Enterprise) enterpriseJcb.getSelectedItem();
		int eId = enterpriseTmp.getId();
		
		Visitor book=new Visitor(Integer.parseInt(id), vname, number, sex, reason, eId,  address);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum= visitorDao.update(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "访客信息修改成功！");
				resetValue();
				this.fillTable(new Visitor());
			}else{
				JOptionPane.showMessageDialog(null, "访客信息修改失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "访客信息修改失败！");
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
		this.nameTxt.setText("");
		this.numberTxt.setText("");
		this.reasonTxt.setText("");
		this.manJrb.setSelected(true);
		this.addressTxt.setText("");
		if(this.enterpriseJcb.getItemCount()>0){
			this.enterpriseJcb.setSelectedIndex(0);
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param met
	 */
	private void studentTableMousePressed(MouseEvent met) {
		int row=this.visitorTable.getSelectedRow();
		this.idTxt.setText((String) visitorTable.getValueAt(row, 0));
		this.nameTxt.setText((String) visitorTable.getValueAt(row, 1));
		this.numberTxt.setText((String) visitorTable.getValueAt(row, 2));
		String sex=(String) visitorTable.getValueAt(row, 3);
		if("男".equals(sex)){
			this.manJrb.setSelected(true);
		}else if("女".equals(sex)){
			this.femaleJrb.setSelected(true);
		}
		this.reasonTxt.setText(visitorTable.getValueAt(row, 4)+"");
		this.addressTxt.setText((String) visitorTable.getValueAt(row, 5));
		String className=(String)this.visitorTable.getValueAt(row, 6);
		int n=this.enterpriseJcb.getItemCount();
		for(int i=0;i<n;i++){
			Enterprise item=(Enterprise)this.enterpriseJcb.getItemAt(i);
			if(item.getEnterpriseName().equals(className)){
				this.enterpriseJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 访客信息查询事件处理
	 * @param
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		String bookName=this.v_nameTxt.getText();
		String author=this.v_numberTxt.getText();
		Enterprise bookType=(Enterprise) this.v_enterpriseJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Visitor book=new Visitor(bookName,author,bookTypeId);
		this.fillTable(book);
	}

	/**
	 * 初始化下拉框
	 * @param type 下拉框类型 
	 */
	private void fillBookType(String type){
		Connection con=null;
		Enterprise enterprise =null;
		try{
			con=dbUtil.getCon();
			ResultSet rs= enterpriseDao.list(con, new Enterprise());
			if("search".equals(type)){
				enterprise =new Enterprise();
				enterprise.setEnterpriseName("请选择...");
				enterprise.setId(-1);
				this.v_enterpriseJcb.addItem(enterprise);
			}
			while(rs.next()){
				enterprise =new Enterprise();
				enterprise.setEnterpriseName(rs.getString("enterpriseName"));
				enterprise.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.v_enterpriseJcb.addItem(enterprise);
				}else if("modify".equals(type)){
					this.enterpriseJcb.addItem(enterprise);
				}
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
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Visitor book){
		DefaultTableModel dtm=(DefaultTableModel) visitorTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs= visitorDao.list(con, book);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("number"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("reason"));
				v.add(rs.getString("address"));
				v.add(rs.getString("enterpriseName"));
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
}
