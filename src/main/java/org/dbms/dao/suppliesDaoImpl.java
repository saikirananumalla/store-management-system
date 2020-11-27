package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.supplies;
import org.dbms.model.supplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class suppliesDaoImpl implements suppliesDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllsuppliess() {
		String sql="SELECT * From supplies order by sid desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new suppliesMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(supplies supplies)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(supplies!= null)
		   {
			   paramSource.addValue("sid", supplies.getSid());
			   paramSource.addValue("itemId", supplies.getItemId());
			   paramSource.addValue("quantity", supplies.getQuantity());
			   paramSource.addValue("InvoiceId", supplies.getInvoiceId());
			   
		   }
		   
		   
		   return paramSource;
	   }
	 private static final class suppliesMapper implements RowMapper<supplies>
	   {
		   public supplies mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   supplies supplies=new supplies();
			   supplies.setSid(rs.getInt("sid"));
			   supplies.setItemId(rs.getString("itemId"));
			   supplies.setQuantity(rs.getInt("quantity"));
			   supplies.setInvoiceId(rs.getInt("InvoiceId"));
			   
			   return supplies;
			   
		   }
	   }
	@Override
	public void addsupplies(supplies supplies) {
			String sql="INSERT INTO supplies (itemId,quantity,InvoiceId) values (:itemId,:quantity,"+supplies.getInvoiceId()+")";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(supplies));
		}  
	@Override
	public void deletesupplies(int id) {
		String sql="DELETE FROM supplies WHERE sid=:sid";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new supplies(id)));
	}
	@Override
	public void updatesupplies(supplies supplies) {
		String sql="UPDATE supplies set itemId=:itemId,quantity=:quantity,InvoiceId=:InvoiceId where sid=:sid";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(supplies));

	}

	@Override
	public supplies findsuppliesbyId(int id) {
		String sql="SELECT * FROM supplies WHERE sid=:sid";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new supplies(id)),new suppliesMapper());

	}

	@Override
	public List listysuppliess() {
		// TODO Auto-generated method stub
		String sql="SELECT * From supplies where InvoiceId=(select InvoiceId from supplies order by sid desc limit 1);";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new suppliesMapper());
		return list;
	}
}
