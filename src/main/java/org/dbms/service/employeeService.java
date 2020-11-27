package org.dbms.service;

import java.util.List;

import org.dbms.model.employee;

public interface employeeService {
public List<employee> listAllemployees();
	
	public void deleteemployee(String id);
	
	public void updateemployee(employee employee);
	
	public void addemployee(employee employee);
	
	public employee findemployeebyId(String id);
}
