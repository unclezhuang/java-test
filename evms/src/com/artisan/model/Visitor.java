package com.artisan.model;

/**
 * �ÿ�ʵ��
 * @author llq-artisan
 *
 */
public class Visitor {
	private int id; // ���
	private String name; // ����
	private String number; // �绰����
	private String sex; // �Ա�
	private String reason; // ����Ե��
	private Integer enterpriseId; // ��ҵ�ʱ�
	private String enterpriseName; // ��ҵ����
	private String address; // ��ַ

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
