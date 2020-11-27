package org.dbms.service;

import java.util.List;

import org.dbms.model.expenses;

public interface expensesService {
public List<expenses> listAllexpensess();
	
	public void deleteexpenses(int id);
	
	public void updateexpenses(expenses expenses);
	
	public void addexpenses(expenses expenses);
	
	public expenses findexpensesbyId(int id);
}
