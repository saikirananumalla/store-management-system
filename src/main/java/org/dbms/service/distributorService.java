package org.dbms.service;

import java.util.List;

import org.dbms.model.distributor;

public interface distributorService {
public List<distributor> listAlldistributors();
	
	public void deletedistributor(int id);
	
	public void updatedistributor(distributor distributor);
	
	public void adddistributor(distributor distributor);
	
	public distributor finddistributorbyId(int id);
}
