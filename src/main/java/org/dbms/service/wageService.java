package org.dbms.service;

import java.util.List;

import org.dbms.model.wage;

public interface wageService {
public List<wage> listAllwages();
	
	public void deletewage(int id);
	
	public void updatewage(wage wage);
	
	public void addwage(wage wage);
	
	public wage findwagebyId(int id);
}
