package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class voucher {
	private Integer id;
	private String date;
	private Integer total;
	private Integer discount;
	private Integer netamount;
	private Integer custId;
	private Integer mechId;
	private String empId;
	public voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public voucher(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getNetamount() {
		return netamount;
	}
	public void setNetamount(Integer netamount) {
		this.netamount = netamount;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getMechId() {
		return mechId;
	}
	public void setMechId(Integer mechId) {
		this.mechId = mechId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
}
