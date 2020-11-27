package org.dbms.service;

import org.dbms.dao.LoginDao;
import org.dbms.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginDao Logindao;
	@Override
	public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
		
		Login Login = Logindao.findLoginbyId(empId);
		if(Login == null) {
			throw new UsernameNotFoundException("User 404");
		}
		return new userprinciple(Login);
	}

}
