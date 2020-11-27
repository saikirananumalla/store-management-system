package org.dbms.dao;

import java.util.List;

import org.dbms.model.items;

public interface itemsDao {
public List<items> listAllitemss();
	
	public void additems(items items);
	
	public void updateitems(items items);
	
	public void deleteitems(String id);
	
	public items finditemsbyId(String id);
}
