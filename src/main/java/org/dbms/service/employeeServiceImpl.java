package org.dbms.service;

import java.util.List;

import org.dbms.dao.employeeDao;
import org.dbms.model.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class employeeServiceImpl implements employeeService {
	employeeDao employeedao;
	
	@Autowired
	public void setemployeedao(employeeDao employeedao) {
		this.employeedao = employeedao;
	}

	@Override
	public List<employee> listAllemployees() {
		// TODO Auto-generated method stub
		return employeedao.listAllemployees();
	}

	@Override
	public void deleteemployee(String id) {
		employeedao.deleteemployee(id);

	}

	@Override
	public void updateemployee(employee employee) {
		employeedao.updateemployee(employee);

	}

	@Override
	public void addemployee(employee employee) {
		// TODO Auto-generated method stub
		employeedao.addemployee(employee);

	}

	@Override
	public employee findemployeebyId(String id) {
		// TODO Auto-generated method stub
		return employeedao.findemployeebyId(id);
	}

}
