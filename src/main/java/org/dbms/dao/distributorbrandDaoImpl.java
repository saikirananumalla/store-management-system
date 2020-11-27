package org.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbms.model.distributorbrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class distributorbrandDaoImpl implements distributorbrandDao {
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAlldistributorbrands() {
		String sql="SELECT * From DistributorBrand";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new distributorbrandMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(distributorbrand distributorbrand)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(distributorbrand!= null)
		   {
			   paramSource.addValue("brandId", distributorbrand.getBrandId());
			   paramSource.addValue("distrId", distributorbrand.getDistrId());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class distributorbrandMapper implements RowMapper<distributorbrand>
	   {
		   public distributorbrand mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   distributorbrand distributorbrand=new distributorbrand();
			   distributorbrand.setBrandId(rs.getString("brandId"));
			   distributorbrand.setDistrId(rs.getInt("distrId"));
			   
			   return distributorbrand;
			   
		   }
	   }
	   
	@Override
	public void adddistributorbrand(distributorbrand distributorbrand) {
			String sql="INSERT INTO DistributorBrand values (:brandId,:distrId)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(distributorbrand));
		}  
	@Override
	public void deletedistributorbrand(distributorbrand distributorbrand) {
		String sql="DELETE FROM DistributorBrand WHERE brandId=:brandId and distrId=:brandId";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new distributorbrand(distributorbrand.getBrandId(),distributorbrand.getDistrId())));
	}
	@Override
	public List finddistributorbrandbybrandId(String brandId) {
		String sql="SELECT * FROM DistributorBrand WHERE brandId=:brandId";
	return	namedparameterjdbctemplate.query(sql, getSqlParameterByModel(new distributorbrand(brandId)),new distributorbrandMapper());

	}
	@Override
	public List finddistributorbrandbydistrId(Integer distrId) {
		String sql="SELECT * FROM DistributorBrand WHERE distrId=:distrId";
	return	namedparameterjdbctemplate.query(sql, getSqlParameterByModel(new distributorbrand(distrId)),new distributorbrandMapper());

	}

}
