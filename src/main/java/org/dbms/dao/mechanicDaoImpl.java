package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.mechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class mechanicDaoImpl implements mechanicDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllmechanics() {
		String sql="SELECT * From mechanic";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new mechanicMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(mechanic mechanic)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(mechanic!= null)
		   {
			   paramSource.addValue("id", mechanic.getId());
			   paramSource.addValue("name", mechanic.getName());
			   paramSource.addValue("aadhar", mechanic.getAadhar());
			   paramSource.addValue("phone", mechanic.getPhone());
			   paramSource.addValue("payment_left", mechanic.getPayment_left());
			   paramSource.addValue("address", mechanic.getAddress());
			   paramSource.addValue("shopname", mechanic.getShopname());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class mechanicMapper implements RowMapper<mechanic>
	   {
		   public mechanic mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   mechanic mechanic=new mechanic();
			   mechanic.setId(rs.getInt("id"));
			   mechanic.setName(rs.getString("name"));
			   mechanic.setAadhar(rs.getString("aadhar"));
			   mechanic.setPhone(rs.getString("phone"));
			   mechanic.setPayment_left(rs.getString("payment_left"));
			   mechanic.setAddress(rs.getString("address"));
			   mechanic.setShopname(rs.getString("shopname"));
			   
			   return mechanic;
			   
		   }
	   }
	   
	@Override
	public void addmechanic(mechanic mechanic) {
			String sql="INSERT INTO mechanic (name,aadhar,phone,payment_left,address,shopname) values (:name,:aadhar,:phone,:payment_left,:address,:shopname)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(mechanic));
		}  
	@Override
	public void deletemechanic(int id) {
		String sql="DELETE FROM mechanic WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new mechanic(id)));
	}
	@Override
	public void updatemechanic(mechanic mechanic) {
		String sql="UPDATE mechanic set name=:name,aadhar=:aadhar,phone=:phone,payment_left=:payment_left,address=:address,shopname=:shopname where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(mechanic));

	}

	@Override
	public mechanic findmechanicbyId(int id) {
		String sql="SELECT * FROM mechanic WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new mechanic(id)),new mechanicMapper());

	}
}
