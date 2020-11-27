package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class supplies {
	private Integer sid;
	private String itemId;
	private Integer quantity;
	private Integer InvoiceId;
	public supplies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public supplies(Integer sid) {
		super();
		this.sid = sid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getInvoiceId() {
		return InvoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.InvoiceId = invoiceId;
	}
	
}
