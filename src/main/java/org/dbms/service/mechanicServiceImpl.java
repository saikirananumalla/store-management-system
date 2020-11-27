package org.dbms.service;

import java.util.List;

import org.dbms.dao.mechanicDao;
import org.dbms.model.mechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component

public class mechanicServiceImpl implements mechanicService {

mechanicDao mechanicdao;
	
	@Autowired
	public void setmechanicdao(mechanicDao mechanicdao) {
		this.mechanicdao = mechanicdao;
	}

	@Override
	public List<mechanic> listAllmechanics() {
		// TODO Auto-generated method stub
		return mechanicdao.listAllmechanics();
	}

	@Override
	public void deletemechanic(int id) {
		mechanicdao.deletemechanic(id);

	}

	@Override
	public void updatemechanic(mechanic mechanic) {
		mechanicdao.updatemechanic(mechanic);

	}

	@Override
	public void addmechanic(mechanic mechanic) {
		// TODO Auto-generated method stub
		mechanicdao.addmechanic(mechanic);

	}

	@Override
	public mechanic findmechanicbyId(int id) {
		// TODO Auto-generated method stub
		return mechanicdao.findmechanicbyId(id);
	}


}
