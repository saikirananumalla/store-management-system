package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class items {
	private String id;
	private String name;
	private String color;
	private Integer MRP;
	private Integer quantity;
	private Integer mech_discount;
	private String brandId;
	public items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public items(String id) {
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getMRP() {
		return MRP;
	}
	public void setMRP(Integer mRP) {
		MRP = mRP;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getMech_discount() {
		return mech_discount;
	}
	public void setMech_discount(Integer mech_discount) {
		this.mech_discount = mech_discount;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
}
