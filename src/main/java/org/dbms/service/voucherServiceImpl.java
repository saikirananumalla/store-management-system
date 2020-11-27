package org.dbms.service;

import java.util.List;

import org.dbms.dao.voucherDao;
import org.dbms.model.voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class voucherServiceImpl implements voucherService {

voucherDao voucherdao;
	
	@Autowired
	public void setvoucherdao(voucherDao voucherdao) {
		this.voucherdao = voucherdao;
	}

	@Override
	public List<voucher> listAllvouchers() {
		// TODO Auto-generated method stub
		return voucherdao.listAllvouchers();
	}

	@Override
	public void deletevoucher(int id) {
		voucherdao.deletevoucher(id);

	}

	@Override
	public void updatevoucher(voucher voucher) {
		voucherdao.updatevoucher(voucher);

	}

	@Override
	public void addvoucher(voucher voucher) {
		// TODO Auto-generated method stub
		voucherdao.addvoucher(voucher);

	}

	@Override
	public voucher findvoucherbyId(int id) {
		// TODO Auto-generated method stub
		return voucherdao.findvoucherbyId(id);
	}

	@Override
	public voucher addvoucherbyId(int id) {
		// TODO Auto-generated method stub
		return voucherdao.addvoucherbyId(id);
	}

	@Override
	public voucher findvoucherbycustId(int id) {
		// TODO Auto-generated method stub
		return voucherdao.findvoucherbycustId(id);
	}

	@Override
	public List<voucher> listyvouchers() {
		// TODO Auto-generated method stub
		return voucherdao.listyvouchers();
	}


}
