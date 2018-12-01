package com.alacriti.bloodbankmanager.impl.dao;
/**
 * 
 * @author digvijaykumars
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.alacriti.bloodbankmanager.dao.RegistrationDAO;
import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodmanager.bo.AddressBO;
import com.alacriti.bloodmanager.bo.UserBO;
import com.alacriti.bloodmanager.bo.WarehouseBO;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public class RegistrationDAOImpl extends BaseDAO implements RegistrationDAO {

	final static Logger log = Logger.getLogger(RegistrationDAOImpl.class);

	@Override
	public int insertUserInfo(UserBO userBo) throws BloodManagerDAOException {
		int result = 0;

		if (log.isDebugEnabled())
			log.debug(" in registerCustomer() ");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn=null;
		String query = "insert into user_tbl(user_id,password,user_type,country_code,contact_no,"
				+ " email_id,login_counter,user_full_name,last_login_time,login_ip,status)"
				+ "  values(?,?,?,?,?,?,?,?,now(),?,?)";
		try {
			conn=getConnection();
			if(conn!=null){
			stmt =conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			int i = 0;
			stmt.setLong(++i, userBo.getUserId());
			stmt.setString(++i, userBo.getPassword());
			stmt.setInt(++i, userBo.getUserType());
			stmt.setString(++i, userBo.getAddress().getCountry());
			stmt.setString(++i, userBo.getPhoneNo());
			stmt.setString(++i, userBo.getEmail());
			stmt.setInt(++i, userBo.getLoginCounter());
			stmt.setString(++i, userBo.getFullName());
			stmt.setString(++i, userBo.getLoginIp());
			stmt.setInt(++i, userBo.getStatus());
			
			// execute the query
			stmt.executeUpdate();
			rs=stmt.getGeneratedKeys();
			if (rs.next())
				result = rs.getInt(1);
		}
		} catch (SQLException e) {
			log.error("Some exception occured during register the user " + e.getMessage());
			throw new BloodManagerDAOException("Some exception occured during register the user");
		}
		finally{
			close(rs);
			close(stmt);
			close(conn);
		}
		return result;
	}
//	public static void main(String[] args) {
//		RegistrationRequest request=new RegistrationRequest();
//		request.setFirstName("Arun");
//		request.setLastName("K");
//		request.setAge(25);
//		request.setEmail("arunk@alacriti.com");
//		request.setGender("male");
//		request.setPhoneNo("58873833728");
//		request.setBloodGroup("A+");
//		System.out.println(new RegistrationDAOImpl().register(request));
//	}

	@Override
	public boolean insertWarehouseDetails(WarehouseBO wareHouseBo) throws BloodManagerDAOException {
		boolean result = false;

		if (log.isDebugEnabled())
			log.debug(" in registerCustomer() ");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn=null;
		String query = "insert into warehouse_info_tbl (warehouse_id,warehouse_type,addr_id,total_area,available_area)"
				+ " values(?,?,?,?,?);";
		try {
			conn=getConnection();
			if(conn!=null){
			stmt =conn.prepareStatement(query);
			int i = 0;
			stmt.setLong(++i, wareHouseBo.getWarehouseId());
			stmt.setInt(++i, wareHouseBo.getWarehouseType());
			stmt.setLong(++i, wareHouseBo.getAddressId());
			stmt.setString(++i, wareHouseBo.getTotalArea());
			stmt.setString(++i, wareHouseBo.getAvailableArea());
			// execute the query
			 if(stmt.executeUpdate()>0)
			 result=true;
		}
		} catch (SQLException e) {
			log.error("Some exception occured during register the user " + e.getMessage());
			throw new BloodManagerDAOException("Some exception occured during register the user");
		}
		finally{
			close(rs);
			close(stmt);
			close(conn);
		}
		return result;
	}
	
	@Override
	public int insertAddress(AddressBO addressBo) throws BloodManagerDAOException {
		int result = 0;

		if (log.isDebugEnabled())
			log.debug(" in registerCustomer() ");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn=null;
		String query = "insert into address_tbl(line1,line2,city,state,country_code_2d,zip,latitude,longitude)"
				+ " values(?,?,?,?,?,?,?,?);";
		try {
			conn=getConnection();
			if(conn!=null){
			stmt =conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			int i = 0;
			//stmt.setLong(++i, addressBo.getAddressId());
			stmt.setString(++i, addressBo.getAddressLine1());
			stmt.setString(++i, addressBo.getAddressLine2());
			stmt.setString(++i, addressBo.getCity());
			stmt.setString(++i, addressBo.getState());
			stmt.setString(++i, addressBo.getCountry());
			stmt.setString(++i, addressBo.getZipCode());
			stmt.setString(++i, addressBo.getLongitude());
			stmt.setString(++i, addressBo.getLattitude());
			// execute the query
			 stmt.executeUpdate();
			 rs=stmt.getGeneratedKeys();
			if (rs.next())
				result = rs.getInt(1);
		}
		} catch (SQLException e) {
			log.error("Some exception occured during insert address" + e.getMessage());
			throw new BloodManagerDAOException("Some exception occured during insert address");
		}
		finally{
			close(rs);
			close(stmt);
			close(conn);
		}
		return result;
	}
}
