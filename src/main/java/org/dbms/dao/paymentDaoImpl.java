package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.dbms.model.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class paymentDaoImpl implements paymentDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllpayments() {
		String sql="SELECT * From payment order by pid desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new paymentMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(payment payment)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(payment!= null)
		   {
			   paramSource.addValue("pid", payment.getPid());
			   paramSource.addValue("bank_name", payment.getBank_name());
			   paramSource.addValue("amount", payment.getAmount());
			   paramSource.addValue("date", payment.getDate());
			   paramSource.addValue("mode", payment.getMode());
			   paramSource.addValue("distrId", payment.getDistrId());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class paymentMapper implements RowMapper<payment>
	   {
		   public payment mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   payment payment=new payment();
			   payment.setPid(rs.getString("pid"));
			   payment.setBank_name(rs.getString("bank_name"));
			   payment.setAmount(rs.getInt("amount"));
			   payment.setDate(rs.getString("date"));
			   payment.setMode(rs.getString("mode"));
			   payment.setDistrId(rs.getInt("distrId"));
			   
			   return payment;
			   
		   }
	   }
	   
	@Override
	public void addpayment(payment payment) {
			String sql="INSERT INTO payment values (:pid,:bank_name,:amount,:date,:mode,:distrId)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(payment));
		}  
	@Override
	public void deletepayment(String id) {
		String sql="DELETE FROM payment WHERE pid=:pid";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new payment(id)));
	}
	@Override
	public void updatepayment(payment payment) {
		String sql="UPDATE payment set bank_name=:bank_name,amount=:amount,date=:date,mode=:mode,distrId=:distrId where pid=:pid";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(payment));

	}

	@Override
	public payment findpaymentbyId(String id) {
		String sql="SELECT * FROM payment WHERE pid=:pid";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new payment(id)),new paymentMapper());

	}
}
