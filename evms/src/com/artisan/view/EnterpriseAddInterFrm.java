package com.artisan.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.artisan.dao.EnterpriseDao;
import com.artisan.model.Enterprise;
import com.artisan.util.DbUtil;
import com.artisan.util.StringUtil;

public class EnterpriseAddInterFrm extends JInternalFrame {
	
	private JTextField enterpriseNameTxt;
	private JTextArea departmentTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private EnterpriseDao enterpriseDao =new EnterpriseDao();


	/**
	 * Create the frame.
	 */
	public EnterpriseAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("�����ҵ��Ϣ����");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("��ҵ��Ϣ����");
		
		JLabel lblNewLabel_1 = new JLabel("����");
		
		enterpriseNameTxt = new JTextField();
		enterpriseNameTxt.setColumns(10);
		
		departmentTxt = new JTextArea();
		departmentTxt.setLineWrap(true);
		departmentTxt.setWrapStyleWord(true);
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(EnterpriseAddInterFrm.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(EnterpriseAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(enterpriseNameTxt, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1)
								.addComponent(departmentTxt))))
					.addContainerGap(69, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(enterpriseNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(departmentTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);
		
		// �����ı���߿�
		departmentTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

	}
	
	/**
	 * ��ҵ��Ϣ����¼�����
	 * @param
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		String enterpriseName =this.enterpriseNameTxt.getText();
		String department =this.departmentTxt.getText();
		if(StringUtil.isEmpty(enterpriseName)){
			JOptionPane.showMessageDialog(null, "��ҵ��Ϣ���Ʋ���Ϊ�գ�");
			return;
		}
		Enterprise enterprise =new Enterprise(enterpriseName, department);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n= enterpriseDao.add(con, enterprise);
			if(n==1){
				JOptionPane.showMessageDialog(null, "��ҵ��Ϣ��ӳɹ���");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "��ҵ��Ϣ���ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��ҵ��Ϣ���ʧ�ܣ�");
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
	 * �����¼�����
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	/**
	 * ���ñ�
	 */
	private void resetValue(){
		this.enterpriseNameTxt.setText("");
		this.departmentTxt.setText("");
	}
}
