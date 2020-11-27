package org.dbms.dao;

import java.util.List;

import org.dbms.model.expenses;

public interface expensesDao {
public List<expenses> listAllexpensess();
	
	public void addexpenses(expenses expenses);
	
	public void updateexpenses(expenses expenses);
	
	public void deleteexpenses(int id);
	
	public expenses findexpensesbyId(int id);
}	
