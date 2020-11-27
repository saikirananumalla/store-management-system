package org.dbms.dao;

import java.util.List;

import org.dbms.model.customer;

public interface customerDao {
public List<customer> listAllcustomers();
	
	public void addcustomer(customer customer);
	
	public void updatecustomer(customer customer);
	
	public void deletecustomer(int id);
	
	public customer findcustomerbyId(int id);

	public List listycustomers();
}
