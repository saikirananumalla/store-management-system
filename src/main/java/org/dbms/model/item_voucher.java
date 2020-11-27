package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class item_voucher {
	private Integer vid;
	private String itemId;
	private Integer quantity;
	public item_voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public item_voucher(Integer vid) {
		super();
		this.vid = vid;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
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
	
}
