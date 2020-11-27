package org.dbms.service;

import java.util.List;

import org.dbms.model.voucher;

public interface voucherService {
public List<voucher> listAllvouchers();

public List<voucher> listyvouchers();
	
	public void deletevoucher(int id);
	
	public void updatevoucher(voucher voucher);
	
	public void addvoucher(voucher voucher);
	
	public voucher findvoucherbyId(int id);
	
	public voucher findvoucherbycustId(int id);
		
	public voucher addvoucherbyId(int id);
}
