package org.dbms.service;

import java.util.List;

import org.dbms.model.mechanic;

public interface mechanicService {
public List<mechanic> listAllmechanics();
	
	public void deletemechanic(int id);
	
	public void updatemechanic(mechanic mechanic);
	
	public void addmechanic(mechanic mechanic);
	
	public mechanic findmechanicbyId(int id);
}
