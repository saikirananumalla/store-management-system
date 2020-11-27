package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Login {
	private String empId;
	private String password;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String empId) {
		super();
		this.empId = empId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
