package org.dbms.service;

import java.util.List;

import org.dbms.model.customer;

public interface customerService {
public List<customer> listAllcustomers();
	
	public void deletecustomer(int id);
	
	public void updatecustomer(customer customer);
	
	public void addcustomer(customer customer);
	
	public customer findcustomerbyId(int id);

	public List listycustomers();
}
