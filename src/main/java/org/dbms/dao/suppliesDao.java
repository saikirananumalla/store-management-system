package org.dbms.dao;

import java.util.List;

import org.dbms.model.supplies;

public interface suppliesDao {
public List<supplies> listAllsuppliess();
	
	public void addsupplies(supplies supplies);
	
	public void updatesupplies(supplies supplies);
	
	public void deletesupplies(int id);
	
	public supplies findsuppliesbyId(int id);

	public List listysuppliess();
}
