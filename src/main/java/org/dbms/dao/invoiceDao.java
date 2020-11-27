package org.dbms.dao;

import java.util.List;

import org.dbms.model.invoice;

public interface invoiceDao {
public List<invoice> listAllinvoices();
	
	public void addinvoice(invoice invoice);
	
	public void updateinvoice(invoice invoice);
	
	public void deleteinvoice(int id);
	
	public invoice findinvoicebyId(int id);
}
