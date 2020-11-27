package org.dbms.service;

import java.util.List;

import org.dbms.dao.expensesDao;
import org.dbms.model.expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class expensesServiceImpl implements expensesService {
	expensesDao expensesdao;
	
	@Autowired
	public void setexpensesdao(expensesDao expensesdao) {
		this.expensesdao = expensesdao;
	}

	@Override
	public List<expenses> listAllexpensess() {
		// TODO Auto-generated method stub
		return expensesdao.listAllexpensess();
	}

	@Override
	public void deleteexpenses(int id) {
		expensesdao.deleteexpenses(id);

	}

	@Override
	public void updateexpenses(expenses expenses) {
		expensesdao.updateexpenses(expenses);

	}

	@Override
	public void addexpenses(expenses expenses) {
		// TODO Auto-generated method stub
		expensesdao.addexpenses(expenses);

	}

	@Override
	public expenses findexpensesbyId(int id) {
		// TODO Auto-generated method stub
		return expensesdao.findexpensesbyId(id);
	}



}
