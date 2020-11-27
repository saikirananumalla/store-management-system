package org.dbms.service;

import java.util.List;

import org.dbms.dao.itemsDao;
import org.dbms.model.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class itemsServiceImpl implements itemsService {
itemsDao itemsdao;
	
	@Autowired
	public void setitemsdao(itemsDao itemsdao) {
		this.itemsdao = itemsdao;
	}

	@Override
	public List<items> listAllitemss() {
		// TODO Auto-generated method stub
		return itemsdao.listAllitemss();
	}

	@Override
	public void deleteitems(String id) {
		itemsdao.deleteitems(id);

	}

	@Override
	public void updateitems(items items) {
		itemsdao.updateitems(items);

	}

	@Override
	public void additems(items items) {
		// TODO Auto-generated method stub
		itemsdao.additems(items);

	}

	@Override
	public items finditemsbyId(String id) {
		// TODO Auto-generated method stub
		return itemsdao.finditemsbyId(id);
	}

}
