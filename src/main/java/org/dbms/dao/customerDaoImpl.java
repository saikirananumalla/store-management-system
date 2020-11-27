package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class customerDaoImpl implements customerDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllcustomers() {
		String sql="SELECT * From customer order by id desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new customerMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(customer customer)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(customer!= null)
		   {
			   paramSource.addValue("id", customer.getId());
			   paramSource.addValue("name", customer.getName());
			   paramSource.addValue("phone", customer.getPhone());
			   paramSource.addValue("address", customer.getAddress());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class customerMapper implements RowMapper<customer>
	   {
		   public customer mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   customer customer=new customer();
			   customer.setId(rs.getInt("id"));
			   customer.setName(rs.getString("name"));
			   customer.setPhone(rs.getString("phone"));
			   customer.setAddress(rs.getString("address"));
			   
			   return customer;
			   
		   }
	   }
	   
	@Override
	public void addcustomer(customer customer) {
			String sql="INSERT INTO customer (name,phone,address) values (:name,:phone,:address)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(customer));
		}  
	@Override
	public void deletecustomer(int id) {
		String sql="DELETE FROM customer WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new customer(id)));
	}
	@Override
	public void updatecustomer(customer customer) {
		String sql="UPDATE customer set name=:name,phone=:phone,address=:address where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(customer));

	}

	@Override
	public customer findcustomerbyId(int id) {
		String sql="SELECT * FROM customer WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new customer(id)),new customerMapper());

	}

	@Override
	public List listycustomers() {
		// TODO Auto-generated method stub
		String sql="SELECT * From customer order by id desc limit 5";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new customerMapper());
		return list;
	}

}
