package org.dbms.service;

import java.util.List;

import org.dbms.dao.customerDao;
import org.dbms.model.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class customerServiceImpl implements customerService {
customerDao customerdao;
	
	@Autowired
	public void setcustomerdao(customerDao customerdao) {
		this.customerdao = customerdao;
	}

	@Override
	public List<customer> listAllcustomers() {
		// TODO Auto-generated method stub
		return customerdao.listAllcustomers();
	}

	@Override
	public void deletecustomer(int id) {
		customerdao.deletecustomer(id);

	}

	@Override
	public void updatecustomer(customer customer) {
		customerdao.updatecustomer(customer);

	}

	@Override
	public void addcustomer(customer customer) {
		// TODO Auto-generated method stub
		customerdao.addcustomer(customer);

	}

	@Override
	public customer findcustomerbyId(int id) {
		// TODO Auto-generated method stub
		return customerdao.findcustomerbyId(id);
	}

	@Override
	public List listycustomers() {
		// TODO Auto-generated method stub
		return customerdao.listycustomers();
	}

	
}
