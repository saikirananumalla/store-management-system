package org.dbms.dao;

import java.util.List;

import org.dbms.model.voucher;

public interface voucherDao {
public List<voucher> listAllvouchers();

public List<voucher> listyvouchers();
	
	public void addvoucher(voucher voucher);
	
	public void updatevoucher(voucher voucher);
	
	public void deletevoucher(int id);
	
	public voucher findvoucherbyId(int id);
	
	public voucher findvoucherbycustId(int id);
	
	public voucher addvoucherbyId(int id);
}
