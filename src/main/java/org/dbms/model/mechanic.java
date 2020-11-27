package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class mechanic {
	private Integer id;
	private String name;
	private String aadhar;
	private String phone;
	private String payment_left;
	private String address;
	private String shopname;
	public mechanic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mechanic(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPayment_left() {
		return payment_left;
	}
	public void setPayment_left(String payment_left) {
		this.payment_left = payment_left;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	

}
