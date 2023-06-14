package com.artisan.model;

/**
 * 企业实体
 * @author llq-artisan
 *
 */
public class Enterprise {
	private int id; // 编号
	private String enterpriseName; // 企业名称
	private String department; // 部门

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
