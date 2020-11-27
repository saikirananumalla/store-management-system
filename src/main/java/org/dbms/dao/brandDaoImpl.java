package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class brandDaoImpl implements brandDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllBrands() {
		String sql="SELECT id,type,name From Brand";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new brandMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(brand brand)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(brand!= null)
		   {
			   paramSource.addValue("id", brand.getId());
			   paramSource.addValue("type", brand.getType());
			   paramSource.addValue("name", brand.getName());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class brandMapper implements RowMapper<brand>
	   {
		   public brand mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   brand brand=new brand();
			   brand.setId(rs.getString("id"));
			   brand.setType(rs.getString("type"));
			   brand.setName(rs.getString("name"));
			   
			   return brand;
			   
		   }
	   }
	   
	@Override
	public void addBrand(brand brand) {
			String sql="INSERT INTO Brand values (:id,:type,:name)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(brand));
		}  
	@Override
	public void deleteBrand(String id) {
		String sql="DELETE FROM Brand WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new brand(id)));
	}
	@Override
	public void updateBrand(brand brand) {
		String sql="UPDATE Brand set type= :type,name= :name where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(brand));

	}

	@Override
	public brand findBrandbyId(String id) {
		String sql="SELECT * FROM Brand WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new brand(id)),new brandMapper());

	}
}


