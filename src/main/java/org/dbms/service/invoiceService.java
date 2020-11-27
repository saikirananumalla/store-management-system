package org.dbms.service;

import java.util.List;

import org.dbms.model.invoice;

public interface invoiceService {
public List<invoice> listAllinvoices();
	
	public void deleteinvoice(int id);
	
	public void updateinvoice(invoice invoice);
	
	public void addinvoice(invoice invoice);
	
	public invoice findinvoicebyId(int id);
}
