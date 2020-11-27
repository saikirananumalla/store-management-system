package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class invoice {
	private Integer id;
	private String date;
	@NotNull
	private Integer amount;
	private Integer delivery_charge;
	private String delivery_by;
	@NotNull
	private Integer distrId;
	public invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public invoice(Integer id) {
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getDelivery_charge() {
		return delivery_charge;
	}
	public void setDelivery_charge(Integer delivery_charge) {
		this.delivery_charge = delivery_charge;
	}
	public String getDelivery_by() {
		return delivery_by;
	}
	public void setDelivery_by(String delivery_by) {
		this.delivery_by = delivery_by;
	}
	public Integer getDistrId() {
		return distrId;
	}
	public void setDistrId(Integer distrId) {
		this.distrId = distrId;
	}
	
}
