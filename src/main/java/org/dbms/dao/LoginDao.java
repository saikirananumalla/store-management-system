package org.dbms.dao;

import java.util.List;

import org.dbms.model.Login;

public interface LoginDao {
public List<Login> listAllLogins();
	
	public void addLogin(Login Login);
	
	public void updateLogin(Login Login);
	
	public void deleteLogin(String empId);
	
	public Login findLoginbyId(String empId);
}
