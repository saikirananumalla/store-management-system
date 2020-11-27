package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.dbms.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class LoginDaoImpl implements LoginDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllLogins() {
		String sql="SELECT * From Login";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new LoginMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(Login Login)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Login!= null)
		   {
			   paramSource.addValue("empId", Login.getEmpId());
			   paramSource.addValue("password", Login.getPassword());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class LoginMapper implements RowMapper<Login>
	   {
		   public Login mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Login Login=new Login();
			   Login.setEmpId(rs.getString("empId"));
			   Login.setPassword(rs.getString("password"));
			   
			   return Login;
			   
		   }
	   }
	   
	@Override
	public void addLogin(Login Login) {
			String sql="INSERT INTO Login values (:empId,SHA1(:password))";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(Login));
		}  
	@Override
	public void deleteLogin(String empId) {
		String sql="DELETE FROM Login WHERE empId=:empId";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new Login(empId)));
	}
	@Override
	public void updateLogin(Login Login) {
		String sql="UPDATE Login set password=SHA1(:password) where empId=:empId";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(Login));

	}

	@Override
	public Login findLoginbyId(String empId) {
		String sql="SELECT * FROM Login WHERE empId=:empId";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new Login(empId)),new LoginMapper());

	}

}
