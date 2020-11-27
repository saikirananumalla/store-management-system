package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class itemsDaoImpl implements itemsDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllitemss() {
		String sql="SELECT * From items";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new itemsMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(items items)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(items!= null)
		   {
			   paramSource.addValue("id", items.getId());
			   paramSource.addValue("name", items.getName());
			   paramSource.addValue("color", items.getColor());
			   paramSource.addValue("MRP", items.getMRP());
			   paramSource.addValue("quantity", items.getQuantity());
			   paramSource.addValue("mech_discount", items.getMech_discount());
			   paramSource.addValue("brandId", items.getBrandId());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class itemsMapper implements RowMapper<items>
	   {
		   public items mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   items items=new items();
			   items.setId(rs.getString("id"));
			   items.setName(rs.getString("name"));
			   items.setColor(rs.getString("color"));
			   items.setMRP(rs.getInt("MRP"));
			   items.setQuantity(rs.getInt("quantity"));
			   items.setMech_discount(rs.getInt("mech_discount"));
			   items.setBrandId(rs.getString("brandId"));
			   
			   return items;
			   
		   }
	   }
	   
	@Override
	public void additems(items items) {
			String sql="INSERT INTO items values (:id,:name,:color,:MRP,:quantity,:mech_discount,:brandId)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(items));
		}  
	@Override
	public void deleteitems(String id) {
		String sql="DELETE FROM items WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new items(id)));
	}
	@Override
	public void updateitems(items items) {
		String sql="UPDATE items set name=:name,color=:color,MRP=:MRP,quantity=:quantity,mech_discount=:mech_discount,brandId=:brandId where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(items));

	}

	@Override
	public items finditemsbyId(String id) {
		String sql="SELECT * FROM items WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new items(id)),new itemsMapper());

	}
}
