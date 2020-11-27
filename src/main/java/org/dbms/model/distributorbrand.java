package org.dbms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class distributorbrand {
	private String brandId;
	private Integer distrId;
	public distributorbrand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public distributorbrand(String brandId) {
		super();
		this.brandId = brandId;
	}
	public distributorbrand(Integer distrId) {
		super();
		this.distrId = distrId;
	}
	
	public distributorbrand(String brandId, Integer distrId) {
		super();
		this.brandId = brandId;
		this.distrId = distrId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public Integer getDistrId() {
		return distrId;
	}
	public void setDistrId(Integer distrId) {
		this.distrId = distrId;
	}
	
	
}
