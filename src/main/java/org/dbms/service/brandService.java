package org.dbms.service;

import java.util.List;

import org.dbms.model.brand;

public interface brandService {
public List<brand> listAllBrands();
	
	public void deleteBrand(String id);
	
	public void updateBrand(brand brand);
	
	public void addBrand(brand brand);
	
	public brand findBrandbyId(String id);
}
