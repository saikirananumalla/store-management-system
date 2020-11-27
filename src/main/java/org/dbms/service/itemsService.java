package org.dbms.service;

import java.util.List;

import org.dbms.model.items;

public interface itemsService {
public List<items> listAllitemss();
	
	public void deleteitems(String empId);
	
	public void updateitems(items items);
	
	public void additems(items items);
	
	public items finditemsbyId(String empId);
}
