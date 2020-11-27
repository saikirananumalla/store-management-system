package org.dbms.service;

import java.util.List;

import org.dbms.dao.distributorDao;
import org.dbms.model.distributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class distributorServiceImpl implements distributorService {
distributorDao distributordao;
	
	@Autowired
	public void setdistributordao(distributorDao distributordao) {
		this.distributordao = distributordao;
	}

	@Override
	public List<distributor> listAlldistributors() {
		// TODO Auto-generated method stub
		return distributordao.listAlldistributors();
	}

	@Override
	public void deletedistributor(int id) {
		distributordao.deletedistributor(id);

	}

	@Override
	public void updatedistributor(distributor distributor) {
		distributordao.updatedistributor(distributor);

	}

	@Override
	public void adddistributor(distributor distributor) {
		// TODO Auto-generated method stub
		distributordao.adddistributor(distributor);

	}

	@Override
	public distributor finddistributorbyId(int id) {
		// TODO Auto-generated method stub
		return distributordao.finddistributorbyId(id);
	}

}
