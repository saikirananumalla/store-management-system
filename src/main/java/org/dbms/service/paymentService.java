package org.dbms.service;

import java.util.List;

import org.dbms.model.payment;

public interface paymentService {
public List<payment> listAllpayments();
	
	public void deletepayment(String id);
	
	public void updatepayment(payment payment);
	
	public void addpayment(payment payment);
	
	public payment findpaymentbyId(String id);
}
