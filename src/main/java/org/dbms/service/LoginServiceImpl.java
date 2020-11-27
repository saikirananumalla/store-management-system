package org.dbms.service;

import java.util.List;

import org.dbms.dao.LoginDao;
import org.dbms.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class LoginServiceImpl implements LoginService {

LoginDao Logindao;
	
	@Autowired
	public void setLogindao(LoginDao Logindao) {
		this.Logindao = Logindao;
	}

	@Override
	public List<Login> listAllLogins() {
		// TODO Auto-generated method stub
		return Logindao.listAllLogins();
	}

	@Override
	public void deleteLogin(String empId) {
		Logindao.deleteLogin(empId);

	}

	@Override
	public void updateLogin(Login Login) {
		Logindao.updateLogin(Login);

	}

	@Override
	public void addLogin(Login Login) {
		// TODO Auto-generated method stub
		Logindao.addLogin(Login);

	}

	@Override
	public Login findLoginbyId(String empId) {
		// TODO Auto-generated method stub
		return Logindao.findLoginbyId(empId);
	}


}
