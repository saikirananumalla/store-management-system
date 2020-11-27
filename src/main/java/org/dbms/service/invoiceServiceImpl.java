package org.dbms.service;

import java.util.List;

import org.dbms.dao.invoiceDao;
import org.dbms.model.invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class invoiceServiceImpl implements invoiceService {

invoiceDao invoicedao;
	
	@Autowired
	public void setinvoicedao(invoiceDao invoicedao) {
		this.invoicedao = invoicedao;
	}

	@Override
	public List<invoice> listAllinvoices() {
		// TODO Auto-generated method stub
		return invoicedao.listAllinvoices();
	}

	@Override
	public void deleteinvoice(int id) {
		invoicedao.deleteinvoice(id);

	}

	@Override
	public void updateinvoice(invoice invoice) {
		invoicedao.updateinvoice(invoice);

	}

	@Override
	public void addinvoice(invoice invoice) {
		// TODO Auto-generated method stub
		invoicedao.addinvoice(invoice);

	}

	@Override
	public invoice findinvoicebyId(int id) {
		// TODO Auto-generated method stub
		return invoicedao.findinvoicebyId(id);
	}


}
