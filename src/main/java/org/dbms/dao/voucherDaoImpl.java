package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class voucherDaoImpl implements voucherDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllvouchers() {
		String sql="SELECT * From voucher order by id desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new voucherMapper());
		return list;
	}
	public List listyvouchers() {
		String sql="SELECT * From voucher order by id desc limit 1";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new voucherMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(voucher voucher)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(voucher!= null)
		   {
			   paramSource.addValue("id", voucher.getId());
			   paramSource.addValue("date", voucher.getDate());
			   paramSource.addValue("total", voucher.getTotal());
			   paramSource.addValue("discount", voucher.getDiscount());
			   paramSource.addValue("netamount", voucher.getNetamount());
			   paramSource.addValue("custId", voucher.getCustId());
			   paramSource.addValue("mechId", voucher.getMechId());
			   paramSource.addValue("empId", voucher.getEmpId());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class voucherMapper implements RowMapper<voucher>
	   {
		   public voucher mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   voucher voucher=new voucher();
			   voucher.setId(rs.getInt("id"));
			   voucher.setDate(rs.getString("date"));
			   voucher.setTotal(rs.getInt("total"));
			   voucher.setDiscount(rs.getInt("discount"));
			   voucher.setNetamount(rs.getInt("netamount"));
			   voucher.setCustId(rs.getInt("custId"));
			   voucher.setMechId(rs.getInt("mechId"));
			   voucher.setEmpId(rs.getString("empId"));
			   
			   return voucher;
			   
		   }
	   }
	   
	@Override
	public void addvoucher(voucher voucher) {
			String sql="INSERT INTO voucher (date,total,discount,netamount,custId,mechId,empId) values (curdate(),0,0,0,:custId,:mechId,:empId)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(voucher));
		}  
	@Override
	public void deletevoucher(int id) {
		String sql="DELETE FROM voucher WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new voucher(id)));
	}
	@Override
	public void updatevoucher(voucher voucher) {
		String sql="UPDATE voucher set date=:date,total=:total,discount=:discount,netamount=:netamount,custId=:custId,mechId=:mechId,empId=:empId where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(voucher));

	}

	@Override
	public voucher findvoucherbyId(int id) {
		String sql="SELECT * FROM voucher WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new voucher(id)),new voucherMapper());

	}
	@Override
	public voucher findvoucherbycustId(int id) {
		String sql="SELECT * FROM voucher WHERE custId=:custId order by id desc limit 1";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new voucher(id)),new voucherMapper());

	}

	@Override
	public voucher addvoucherbyId(int id) {
		String sql1="INSERT INTO voucher (date,total,discount,netamount,custId) values (curdate(),0,0,0,:custId)";
		namedparameterjdbctemplate
		.update(sql1,getSqlParameterByModel(new voucher(id)));
		String sql2="SELECT * FROM voucher WHERE id=:id";
		return namedparameterjdbctemplate.queryForObject(sql2,getSqlParameterByModel(new voucher(id)),new voucherMapper());
	}
}
