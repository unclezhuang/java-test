package com.artisan.model;

/**
 * 访客实体
 * @author llq-artisan
 *
 */
public class Visitor {
	private int id; // 编号
	private String name; // 姓名
	private String number; // 电话号码
	private String sex; // 性别
	private String reason; // 来访缘由
	private Integer enterpriseId; // 企业邮编
	private String enterpriseName; // 企业名称
	private String address; // 地址

	public Visitor() {
		super();
	}
	
	public Visitor(String name, String number, String sex, String reason, Integer enterpriseId, String address) {
		super();
		this.name = name;
		this.number = number;
		this.sex = sex;
		this.reason = reason;
		this.enterpriseId = enterpriseId;
		this.address = address;
	}

	public Visitor(int id, String name, String number, String sex, String reason, Integer enterpriseId, String address) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.sex = sex;
		this.reason = reason;
		this.enterpriseId = enterpriseId;
		this.address = address;
	}

	public Visitor(String name, String number, Integer enterpriseId) {
		super();
		this.name = name;
		this.number = number;
		this.enterpriseId = enterpriseId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
