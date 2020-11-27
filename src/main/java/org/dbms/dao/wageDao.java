package org.dbms.dao;

import java.util.List;

import org.dbms.model.wage;

public interface wageDao {
public List<wage> listAllwages();
	
	public void addwage(wage wage);
	
	public void updatewage(wage wage);
	
	public void deletewage(int id);
	
	public wage findwagebyId(int id);
}
