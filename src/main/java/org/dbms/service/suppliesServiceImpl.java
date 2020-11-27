package org.dbms.service;

import java.util.List;

import org.dbms.dao.suppliesDao;
import org.dbms.model.supplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class suppliesServiceImpl implements suppliesService {

suppliesDao suppliesdao;
	
	@Autowired
	public void setsuppliesdao(suppliesDao suppliesdao) {
		this.suppliesdao = suppliesdao;
	}

	@Override
	public List<supplies> listAllsuppliess() {
		// TODO Auto-generated method stub
		return suppliesdao.listAllsuppliess();
	}

	@Override
	public void deletesupplies(int id) {
		suppliesdao.deletesupplies(id);

	}

	@Override
	public void updatesupplies(supplies supplies) {
		suppliesdao.updatesupplies(supplies);

	}

	@Override
	public void addsupplies(supplies supplies) {
		// TODO Auto-generated method stub
		suppliesdao.addsupplies(supplies);

	}

	@Override
	public supplies findsuppliesbyId(int id) {
		// TODO Auto-generated method stub
		return suppliesdao.findsuppliesbyId(id);
	}

	@Override
	public List listysuppliess() {
		// TODO Auto-generated method stub
		return suppliesdao.listysuppliess();
	}

}
