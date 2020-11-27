package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class expensesDaoImpl implements expensesDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllexpensess() {
		String sql="SELECT * From Expenses order by id desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new expensesMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(expenses expenses)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(expenses!= null)
		   {
			   paramSource.addValue("id", expenses.getId());
			   paramSource.addValue("type", expenses.getType());
			   paramSource.addValue("date", expenses.getDate());
			   paramSource.addValue("amount", expenses.getAmount());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class expensesMapper implements RowMapper<expenses>
	   {
		   public expenses mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   expenses expenses=new expenses();
			   expenses.setId(rs.getInt("id"));
			   expenses.setType(rs.getString("type"));
			   expenses.setDate(rs.getString("date"));
			   expenses.setAmount(rs.getInt("amount"));
			   
			   return expenses;
			   
		   }
	   }
	   
	@Override
	public void addexpenses(expenses expenses) {
			String sql="INSERT INTO Expenses (type,date,amount) values (:type,curdate(),:amount)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(expenses));
		}  
	@Override
	public void deleteexpenses(int id) {
		String sql="DELETE FROM Expenses WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new expenses(id)));
	}
	@Override
	public void updateexpenses(expenses expenses) {
		String sql="UPDATE Expenses set type=:type,date=:date,amount=:amount where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(expenses));

	}

	@Override
	public expenses findexpensesbyId(int id) {
		String sql="SELECT * FROM Expenses WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new expenses(id)),new expensesMapper());

	}

	
}
