package org.dbms.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.dbms.model.invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class invoiceDaoImpl implements invoiceDao {

	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	public void setNamedparameterjdbctemplate(NamedParameterJdbcTemplate namedparameterjdbctemplate) {
		this.namedparameterjdbctemplate = namedparameterjdbctemplate;
	}
	
	public List listAllinvoices() {
		String sql="SELECT * From Invoice order by id desc";
		List list = namedparameterjdbctemplate
				.query(sql,getSqlParameterByModel(null), new invoiceMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterByModel(invoice invoice)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(invoice!= null)
		   {
			   paramSource.addValue("id", invoice.getId());
			   paramSource.addValue("date", invoice.getDate());
			   paramSource.addValue("amount", invoice.getAmount());
			   paramSource.addValue("delivery_charge", invoice.getDelivery_charge());
			   paramSource.addValue("delivery_by", invoice.getDelivery_by());
			   paramSource.addValue("distrId", invoice.getDistrId());
			   
		   }
		   
		   
		   return paramSource;
	   }
	   private static final class invoiceMapper implements RowMapper<invoice>
	   {
		   public invoice mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   invoice invoice=new invoice();
			   invoice.setId(rs.getInt("id"));
			   invoice.setDate(rs.getString("date"));
			   invoice.setAmount(rs.getInt("amount"));
			   invoice.setDelivery_charge(rs.getInt("delivery_charge"));
			   invoice.setDelivery_by(rs.getString("delivery_by"));
			   invoice.setDistrId(rs.getInt("distrId"));
			   
			   return invoice;
			   
		   }
	   }
	   
	@Override
	public void addinvoice(invoice invoice) {
			String sql="INSERT INTO Invoice values (:id,curdate(),:amount,:delivery_charge,:delivery_by,:distrId)";
			namedparameterjdbctemplate
			.update(sql,getSqlParameterByModel(invoice));
		}  
	@Override
	public void deleteinvoice(int id) {
		String sql="DELETE FROM Invoice WHERE id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(new invoice(id)));
	}
	@Override
	public void updateinvoice(invoice invoice) {
		String sql="UPDATE Invoice set date=:date,amount=:amount,delivery_charge=:delivery_charge,delivery_by=:delivery_by,distrId=:distrId where id=:id";
		namedparameterjdbctemplate.update(sql,getSqlParameterByModel(invoice));

	}

	@Override
	public invoice findinvoicebyId(int id) {
		String sql="SELECT * FROM Invoice WHERE id=:id";
	return	namedparameterjdbctemplate.queryForObject(sql, getSqlParameterByModel(new invoice(id)),new invoiceMapper());

	}
}
