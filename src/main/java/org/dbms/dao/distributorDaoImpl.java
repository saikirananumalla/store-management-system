package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.distributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class distributorDaoImpl implements distributorDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAlldistributors() {
		String sql="SELECT * From distributor";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new distributorMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(distributor distributor)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(distributor!= null)
		   {
			   paramSource.addValue("id", distributor.getId());
			   paramSource.addValue("GSTIN", distributor.getGSTIN());
			   paramSource.addValue("name", distributor.getName());
			   paramSource.addValue("payment_pending", distributor.getPayment_pending());
			   paramSource.addValue("firm_name", distributor.getFirm_name());
			   paramSource.addValue("phone", distributor.getPhone());
			   paramSource.addValue("address", distributor.getAddress());
			   paramSource.addValue("startdate", distributor.getStartdate());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class distributorMapper implements RowMapper<distributor>
	   {
		   public distributor mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   distributor distributor=new distributor();
			   distributor.setId(rs.getInt("id"));
			   distributor.setGSTIN(rs.getString("GSTIN"));
			   distributor.setName(rs.getString("name"));
			   distributor.setPayment_pending(rs.getString("payment_pending"));
			   distributor.setFirm_name(rs.getString("firm_name"));
			   distributor.setPhone(rs.getString("phone"));
			   distributor.setAddress(rs.getString("address"));
			   distributor.setStartdate(rs.getString("startdate"));
			   
			   return distributor;
			   
		   }
	   }
	   
	@Override
	public void adddistributor(distributor distributor) {
			String sql="INSERT INTO distributor (GSTIN,name,payment_pending,firm_name,phone,address,startdate) values (:GSTIN,:name,:payment_pending,firm_name=:firm_name,:phone,:address,:startdate)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(distributor));
		}  
	@Override
	public void deletedistributor(int id) {
		String sql="DELETE FROM distributor WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new distributor(id)));
	}
	@Override
	public void updatedistributor(distributor distributor) {
		String sql="UPDATE distributor set GSTIN=:GSTIN,name=:name,payment_pending=:payment_pending,firm_name=:firm_name,phone=:phone,address=:address,startdate=:startdate where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(distributor));

	}

	@Override
	public distributor finddistributorbyId(int id) {
		String sql="SELECT * FROM distributor WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new distributor(id)),new distributorMapper());

	}
}
