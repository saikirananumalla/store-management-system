package org.dbms.dao;

import java.util.List;

import org.dbms.model.mechanic;

public interface mechanicDao {
public List<mechanic> listAllmechanics();
	
	public void addmechanic(mechanic mechanic);
	
	public void updatemechanic(mechanic mechanic);
	
	public void deletemechanic(int id);
	
	public mechanic findmechanicbyId(int id);
}
