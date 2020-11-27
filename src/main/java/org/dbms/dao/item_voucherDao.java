package org.dbms.dao;

import java.util.List;

import org.dbms.model.item_voucher;

public interface item_voucherDao {
public List<item_voucher> listAllitem_vouchers();
	
	public void additem_voucher(item_voucher item_voucher);
	
	public void deleteitem_voucher(int id);
	
	public item_voucher finditem_voucherbyId(int id);

	public void additem_voucher(int id);
	
	public void updateitem_voucher(item_voucher item_voucher);

	public List listyitem_vouchers();
}
