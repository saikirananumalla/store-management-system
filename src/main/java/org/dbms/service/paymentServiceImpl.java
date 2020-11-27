package org.dbms.service;

import java.util.List;

import org.dbms.dao.paymentDao;
import org.dbms.model.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class paymentServiceImpl implements paymentService {

paymentDao paymentdao;
	
	@Autowired
	public void setpaymentdao(paymentDao paymentdao) {
		this.paymentdao = paymentdao;
	}

	@Override
	public List<payment> listAllpayments() {
		// TODO Auto-generated method stub
		return paymentdao.listAllpayments();
	}

	@Override
	public void deletepayment(String id) {
		paymentdao.deletepayment(id);

	}

	@Override
	public void updatepayment(payment payment) {
		paymentdao.updatepayment(payment);

	}

	@Override
	public void addpayment(payment payment) {
		// TODO Auto-generated method stub
		paymentdao.addpayment(payment);

	}

	@Override
	public payment findpaymentbyId(String id) {
		// TODO Auto-generated method stub
		return paymentdao.findpaymentbyId(id);
	}
}
