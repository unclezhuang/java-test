package com.artisan.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.artisan.dao.VisitorDao;
import com.artisan.dao.EnterpriseDao;
import com.artisan.model.Visitor;
import com.artisan.model.Enterprise;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;

public class VisitorAddInterFrm extends JInternalFrame {
	private JTextField visitorTxt;
	private JTextField numberTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField reasonTxt;
	private JComboBox enterpriseJcb;
	private JTextArea addressTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	
	private DbUtil dbUtil=new DbUtil();
	private EnterpriseDao enterpriseDao =new EnterpriseDao();
	private VisitorDao visitorDao =new VisitorDao();

	

	/**
	 * Create the frame.
	 */
	public VisitorAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("添加访客信息");
		setBounds(100, 100, 500, 467);
		
		JLabel label = new JLabel("访客姓名");
		
		visitorTxt = new JTextField();
		visitorTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("访客电话号码");
		
		numberTxt = new JTextField();
		numberTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("访客性别");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_3 = new JLabel("来访缘由");
		
		reasonTxt = new JTextField();
		reasonTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("地址");
		
		addressTxt = new JTextArea();
		
		JLabel label_5 = new JLabel("企业名称");
		
	    enterpriseJcb = new JComboBox();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(VisitorAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(VisitorAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1)
							.addGap(232))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(label_5)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_4)
									.addComponent(label_2)
									.addComponent(label))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(visitorTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(manJrb)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(femaleJrb))
											.addComponent(enterpriseJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(35)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(numberTxt, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_3)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(reasonTxt))))
									.addComponent(addressTxt))
								.addContainerGap(44, Short.MAX_VALUE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(visitorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(label_3)
						.addComponent(reasonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(enterpriseJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(42))
		);
		getContentPane().setLayout(groupLayout);

		// 设置文本域边框
		addressTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

		
		fillBookType();
	}
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * 访客添加事件处理
	 * @param
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		String bookName=this.visitorTxt.getText();
		String author=this.numberTxt.getText();
		String price=this.reasonTxt.getText();
		String bookDesc=this.addressTxt.getText();
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "访客姓名不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "访客电话号码不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "访客来访缘由不能为空！");
			return;
		}
		
		String sex="";
		if(manJrb.isSelected()){
			sex="男";
		}else if(femaleJrb.isSelected()){
			sex="女";
		}
		
		Enterprise bookType=(Enterprise) enterpriseJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Visitor book=new Visitor(bookName,author, sex, price , bookTypeId,  bookDesc);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum= visitorDao.add(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "访客添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "访客添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "访客添加失败！");
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
		this.visitorTxt.setText("");
		this.numberTxt.setText("");
		this.reasonTxt.setText("");
		this.manJrb.setSelected(true);
		this.addressTxt.setText("");
		if(this.enterpriseJcb.getItemCount()>0){
			this.enterpriseJcb.setSelectedIndex(0);
		}
	}

	/**
	 * 初始化访客类别下拉框
	 */
	private void fillBookType(){
		Connection con=null;
		Enterprise bookType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs= enterpriseDao.list(con, new Enterprise());
			while(rs.next()){
				bookType=new Enterprise();
				bookType.setId(rs.getInt("id"));
				bookType.setEnterpriseName(rs.getString("enterpriseName"));
				this.enterpriseJcb.addItem(bookType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
}
