package org.dbms.dao;

import java.util.List;

import org.dbms.model.brand;

public interface brandDao {
public List<brand> listAllBrands();
	
	public void addBrand(brand brand);
	
	public void updateBrand(brand brand);
	
	public void deleteBrand(String id);
	
	public brand findBrandbyId(String id);
}
