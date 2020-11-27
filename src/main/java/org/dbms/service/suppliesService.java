package org.dbms.service;

import java.util.List;

import org.dbms.model.supplies;

public interface suppliesService {
public List<supplies> listAllsuppliess();
	
	public void deletesupplies(int id);
	
	public void updatesupplies(supplies supplies);
	
	public void addsupplies(supplies supplies);
	
	public supplies findsuppliesbyId(int id);

	public List listysuppliess();
}
