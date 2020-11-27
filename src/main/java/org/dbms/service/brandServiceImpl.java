package org.dbms.service;

import java.util.List;

import org.dbms.dao.brandDao;
import org.dbms.model.brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class brandServiceImpl implements brandService {
	brandDao branddao;
	
	@Autowired
	public void setBranddao(brandDao branddao) {
		this.branddao = branddao;
	}

	@Override
	public List<brand> listAllBrands() {
		// TODO Auto-generated method stub
		return branddao.listAllBrands();
	}

	@Override
	public void deleteBrand(String id) {
		branddao.deleteBrand(id);

	}

	@Override
	public void updateBrand(brand brand) {
		branddao.updateBrand(brand);

	}

	@Override
	public void addBrand(brand brand) {
		// TODO Auto-generated method stub
		branddao.addBrand(brand);

	}

	@Override
	public brand findBrandbyId(String id) {
		// TODO Auto-generated method stub
		return branddao.findBrandbyId(id);
	}

}
