package org.dbms.service;

import java.util.List;

import org.dbms.dao.wageDao;
import org.dbms.model.wage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class wageServiceImpl implements wageService {

wageDao wagedao;
	
	@Autowired
	public void setwagedao(wageDao wagedao) {
		this.wagedao = wagedao;
	}

	@Override
	public List<wage> listAllwages() {
		// TODO Auto-generated method stub
		return wagedao.listAllwages();
	}

	@Override
	public void deletewage(int id) {
		wagedao.deletewage(id);

	}

	@Override
	public void updatewage(wage wage) {
		wagedao.updatewage(wage);

	}

	@Override
	public void addwage(wage wage) {
		// TODO Auto-generated method stub
		wagedao.addwage(wage);

	}

	@Override
	public wage findwagebyId(int id) {
		// TODO Auto-generated method stub
		return wagedao.findwagebyId(id);
	}


}
