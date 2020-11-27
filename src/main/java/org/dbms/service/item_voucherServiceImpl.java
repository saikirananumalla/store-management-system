package org.dbms.service;

import java.util.List;

import org.dbms.dao.item_voucherDao;
import org.dbms.model.item_voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class item_voucherServiceImpl implements item_voucherService {

item_voucherDao item_voucherdao;
	
	@Autowired
	public void setitem_voucherdao(item_voucherDao item_voucherdao) {
		this.item_voucherdao = item_voucherdao;
	}

	@Override
	public List<item_voucher> listAllitem_vouchers() {
		// TODO Auto-generated method stub
		return item_voucherdao.listAllitem_vouchers();
	}

	@Override
	public void deleteitem_voucher(int id) {
		item_voucherdao.deleteitem_voucher(id);

	}

	@Override
	public void additem_voucher(item_voucher item_voucher) {
		// TODO Auto-generated method stub
		item_voucherdao.additem_voucher(item_voucher);

	}

	@Override
	public item_voucher finditem_voucherbyId(int id) {
		// TODO Auto-generated method stub
		return item_voucherdao.finditem_voucherbyId(id);
	}

	@Override
	public void additem_voucher(int id) {
		item_voucherdao.additem_voucher(id);
		
	}

	@Override
	public void updateitem_voucher(item_voucher item_voucher) {
		// TODO Auto-generated method stub
		item_voucherdao.updateitem_voucher(item_voucher);
	}

	@Override
	public List listyitem_vouchers() {
		// TODO Auto-generated method stub
		return item_voucherdao.listyitem_vouchers();
	}
}
