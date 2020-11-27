package org.dbms.service;

import java.util.List;

import org.dbms.dao.distributorbrandDao;
import org.dbms.model.distributorbrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class distributorbrandServiceImpl implements distributorbrandService {
	distributorbrandDao distributorbranddao;
	@Autowired
	public void setDistributorbranddao(distributorbrandDao distributorbranddao) {
		this.distributorbranddao = distributorbranddao;
	}

	@Override
	public List<distributorbrand> listAlldistributorbrands() {
		// TODO Auto-generated method stub
		return distributorbranddao.listAlldistributorbrands();
	}

	@Override
	public void adddistributorbrand(distributorbrand distributorbrand) {
		// TODO Auto-generated method stub
		distributorbranddao.adddistributorbrand(distributorbrand);
	}

	@Override
	public void deletedistributorbrand(distributorbrand distributorbrand) {
		// TODO Auto-generated method stub
		distributorbranddao.deletedistributorbrand(distributorbrand);

	}

	@Override
	public List finddistributorbrandbybrandId(String brandId) {
		// TODO Auto-generated method stub
		return distributorbranddao.finddistributorbrandbybrandId(brandId);
	}

	@Override
	public List finddistributorbrandbydistrId(Integer distrId) {
		// TODO Auto-generated method stub
		return distributorbranddao.finddistributorbrandbydistrId(distrId);
	}

}
