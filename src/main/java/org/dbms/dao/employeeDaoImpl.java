package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class employeeDaoImpl implements employeeDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllemployees() {
		String sql="SELECT * From employee order by id desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new employeeMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(employee employee)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(employee!= null)
		   {
			   paramSource.addValue("id", employee.getId());
			   paramSource.addValue("name", employee.getName());
			   paramSource.addValue("dob", employee.getDob());
			   paramSource.addValue("address", employee.getAddress());
			   paramSource.addValue("aadhar", employee.getAadhar());
			   paramSource.addValue("wagepermonth", employee.getWagepermonth());
			   paramSource.addValue("phone", employee.getPhone());
			   paramSource.addValue("type", employee.getType());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class employeeMapper implements RowMapper<employee>
	   {
		   public employee mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   employee employee=new employee();
			   employee.setId(rs.getString("id"));
			   employee.setName(rs.getString("name"));
			   employee.setDob(rs.getString("dob"));
			   employee.setAddress(rs.getString("address"));
			   employee.setAadhar(rs.getString("aadhar"));
			   employee.setWagepermonth(rs.getInt("wagepermonth"));
			   employee.setPhone(rs.getString("phone"));
			   employee.setType(rs.getString("type"));
			   
			   return employee;
			   
		   }
	   }
	   
	@Override
	public void addemployee(employee employee) {
			String sql="INSERT INTO employee values (:id,:name,:dob,:address,:aadhar,:wagepermonth,phone,:type)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(employee));
		}  
	@Override
	public void deleteemployee(String id) {
		String sql="DELETE FROM employee WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new employee(id)));
	}
	@Override
	public void updateemployee(employee employee) {
		String sql="UPDATE employee set name=:name,dob=:dob,address=:address,aadhar=:aadhar,wagepermonth=:wagepermonth,phone=:phone,type=:type where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(employee));

	}

	@Override
	public employee findemployeebyId(String id) {
		String sql="SELECT * FROM employee WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new employee(id)),new employeeMapper());

	}

}
