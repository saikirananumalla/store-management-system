package org.dbms.dao;

import java.util.List;

import org.dbms.model.distributor;

public interface distributorDao {
public List<distributor> listAlldistributors();
	
	public void adddistributor(distributor distributor);
	
	public void updatedistributor(distributor distributor);
	
	public void deletedistributor(int id);
	
	public distributor finddistributorbyId(int id);
}
