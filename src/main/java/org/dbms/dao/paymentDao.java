package org.dbms.dao;

import java.util.List;

import org.dbms.model.payment;

public interface paymentDao {
public List<payment> listAllpayments();
	
	public void addpayment(payment payment);
	
	public void updatepayment(payment payment);
	
	public void deletepayment(String id);
	
	public payment findpaymentbyId(String id);
}
