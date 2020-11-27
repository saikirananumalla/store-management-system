package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class employee {
	private String id;
	private String name;
	private String dob;
	private String address;
	private String aadhar;
	private Integer wagepermonth;
	private String phone;
	private String type;
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employee(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public Integer getWagepermonth() {
		return wagepermonth;
	}
	public void setWagepermonth(Integer wagepermonth) {
		this.wagepermonth = wagepermonth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
