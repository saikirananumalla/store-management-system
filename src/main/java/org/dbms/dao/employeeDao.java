package org.dbms.dao;

import java.util.List;

import org.dbms.model.employee;

public interface employeeDao {
public List<employee> listAllemployees();
	
	public void addemployee(employee employee);
	
	public void updateemployee(employee employee);
	
	public void deleteemployee(String id);
	
	public employee findemployeebyId(String id);
}
