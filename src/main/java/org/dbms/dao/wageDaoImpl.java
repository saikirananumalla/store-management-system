package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.dbms.model.wage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class wageDaoImpl implements wageDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllwages() {
		String sql="SELECT * From wage order by id desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new wageMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(wage wage)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(wage!= null)
		   {
			   paramSource.addValue("id", wage.getId());
			   paramSource.addValue("amount", wage.getAmount());
			   paramSource.addValue("date", wage.getDate());
			   paramSource.addValue("empId", wage.getEmpId());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class wageMapper implements RowMapper<wage>
	   {
		   public wage mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   wage wage=new wage();
			   wage.setId(rs.getInt("id"));
			   wage.setAmount(rs.getInt("amount"));
			   wage.setDate(rs.getString("date"));
			   wage.setEmpId(rs.getString("empId"));

			   
			   return wage;
			   
		   }
	   }
	   
	@Override
	public void addwage(wage wage) {
			String sql="INSERT INTO wage (amount,date,empId) values (:amount,curdate(),:empId)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(wage));
		}  
	@Override
	public void deletewage(int id) {
		String sql="DELETE FROM wage WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new wage(id)));
	}
	@Override
	public void updatewage(wage wage) {
		String sql="UPDATE wage set amount=:amount,date=:date,empId=:empId where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(wage));

	}

	@Override
	public wage findwagebyId(int id) {
		String sql="SELECT * FROM wage WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new wage(id)),new wageMapper());

	}

	
}
