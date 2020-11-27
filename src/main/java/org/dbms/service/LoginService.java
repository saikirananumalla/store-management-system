package org.dbms.service;

import java.util.List;

import org.dbms.model.Login;

public interface LoginService {
public List<Login> listAllLogins();
	
	public void deleteLogin(String empId);
	
	public void updateLogin(Login Login);
	
	public void addLogin(Login Login);
	
	public Login findLoginbyId(String empId);
}
