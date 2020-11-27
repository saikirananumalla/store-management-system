package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class feedbackDaoImpl implements feedbackDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllfeedbacks() {
		String sql="SELECT * From feedback order by id desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new feedbackMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(feedback feedback)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(feedback!= null)
		   {
			   paramSource.addValue("id", feedback.getId());
			   paramSource.addValue("custId", feedback.getCustId());
			   paramSource.addValue("date", feedback.getDate());
			   paramSource.addValue("remarks", feedback.getRemarks());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class feedbackMapper implements RowMapper<feedback>
	   {
		   public feedback mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   feedback feedback=new feedback();
			   feedback.setId(rs.getInt("id"));
			   feedback.setCustId(rs.getInt("custId"));
			   feedback.setDate(rs.getString("date"));
			   feedback.setRemarks(rs.getString("remarks"));
			   
			   return feedback;
			   
		   }
	   }
	   
	@Override
	public void addfeedback(feedback feedback) {
			String sql="INSERT INTO feedback (custId,date,remarks) values (:custId,curdate(),:remarks)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(feedback));
		}  
	@Override
	public void deletefeedback(int id) {
		String sql="DELETE FROM feedback WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new feedback(id)));
	}
	@Override
	public void updatefeedback(feedback feedback) {
		String sql="UPDATE feedback set custId=custId,date=:date,remarks=:remarks where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(feedback));

	}

	@Override
	public feedback findfeedbackbyId(int id) {
		String sql="SELECT * FROM feedback WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new feedback(id)),new feedbackMapper());

	}
	
}
