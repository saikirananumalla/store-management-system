package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class payment {
	private String pid;
	private String bank_name;
	private Integer amount;
	private String date;
	private String mode;
	private Integer distrId;
	public payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public payment(String pid) {
		super();
		this.pid = pid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Integer getDistrId() {
		return distrId;
	}
	public void setDistrId(Integer distrId) {
		this.distrId = distrId;
	}
	
}
