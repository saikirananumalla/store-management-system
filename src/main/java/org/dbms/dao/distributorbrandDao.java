package org.dbms.dao;

import java.util.List;

import org.dbms.model.distributorbrand;

public interface distributorbrandDao {
public List<distributorbrand> listAlldistributorbrands();
	
	public void adddistributorbrand(distributorbrand distributorbrand);
	
	public void deletedistributorbrand(distributorbrand distributorbrand);
	
	public List finddistributorbrandbybrandId(String brandId);
	
	public List finddistributorbrandbydistrId(Integer distrId);


	
}
