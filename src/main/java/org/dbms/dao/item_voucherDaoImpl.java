package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.item_voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class item_voucherDaoImpl implements item_voucherDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllitem_vouchers() {
		String sql="SELECT * From item_voucher order by vid desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new item_voucherMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(item_voucher item_voucher)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(item_voucher!= null)
		   {
			   paramSource.addValue("vid", item_voucher.getVid());
			   paramSource.addValue("itemId", item_voucher.getItemId());
			   paramSource.addValue("quantity", item_voucher.getQuantity());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class item_voucherMapper implements RowMapper<item_voucher>
	   {
		   public item_voucher mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   item_voucher item_voucher=new item_voucher();
			   item_voucher.setVid(rs.getInt("vid"));
			   item_voucher.setItemId(rs.getString("itemId"));
			   item_voucher.setQuantity(rs.getInt("quantity"));
			   
			   return item_voucher;
			   
		   }
	   }
	   
	@Override
	public void additem_voucher(item_voucher item_voucher) {
			String sql="INSERT INTO item_voucher values ("+item_voucher.getVid()+",:itemId,:quantity)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(item_voucher));
		}  
	@Override
	public void additem_voucher(int id) {
			String sql="INSERT INTO item_voucher(vid,quantity) values (:vid,0)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(new item_voucher(id)));
		} 
	@Override
	public void deleteitem_voucher(int id) {
		String sql="DELETE FROM item_voucher WHERE vid=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new item_voucher(id)));
	}
	@Override
	public item_voucher finditem_voucherbyId(int id) {
		String sql="SELECT * FROM item_voucher WHERE vid=:vid order by vid desc limit 1";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new item_voucher(id)),new item_voucherMapper());

	}

	@Override
	public void updateitem_voucher(item_voucher item_voucher) {
		// TODO Auto-generated method stub
		String sql = "UPDATE item_voucher SET itemId=:itemId,quantity=:quantity WHERE vid=:vid";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(item_voucher));
	}

	@Override
	public List listyitem_vouchers() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM item_voucher WHERE vid=(SELECT id FROM voucher order by id desc limit 1)";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new item_voucherMapper());
		return list;
	}
}
