package com.artisan.model;

/**
 * ��ҵʵ��
 * @author llq-artisan
 *
 */
public class Enterprise {
	private int id; // ���
	private String enterpriseName; // ��ҵ����
	private String department; // ����

	public Enterprise() {
		super();
	}

	public Enterprise(String enterpriseName, String department) {
		super();
		this.enterpriseName = enterpriseName;
		this.department = department;
	}

	public Enterprise(int id, String enterpriseName, String department) {
		super();
		this.id = id;
		this.enterpriseName = enterpriseName;
		this.department = department;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return enterpriseName;
	}

	
}
