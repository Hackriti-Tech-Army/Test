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

import org.apache.log4j.Logger;

import com.alacriti.bloodbankmanager.dao.RegistrationDAO;
import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodmanager.bo.PartnerBO;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public class RegistrationDAOImpl extends BaseDAO implements RegistrationDAO {

	final static Logger log = Logger.getLogger(RegistrationDAOImpl.class);

	@Override
	public boolean registerCustomer(RegisterCustomerRequest request) throws BloodManagerDAOException {
		int count = 0;
		boolean result = false;

		if (log.isDebugEnabled())
			log.debug(" in registerCustomer() ");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn=null;
		String query = "insert into user_profile_tbl(f_name,l_name,email,phone_no,age,gender,blood_group)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			conn=getConnection();
			if(conn!=null){
			stmt =conn.prepareStatement(query);
			int i = 0;
			stmt.setString(++i, request.getFirstName());
			stmt.setString(++i, request.getLastName());
			stmt.setString(++i, request.getEmail());
			stmt.setString(++i, request.getPhoneNo());
			// execute the query
			count = stmt.executeUpdate();
			if (count > 0)
				result = true;
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
	public boolean registerPartner(PartnerBO partnerBo) throws BloodManagerDAOException {
		int count = 0;
		boolean result = false;

		if (log.isDebugEnabled())
			log.debug(" in registerCustomer() ");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn=null;
		String query = "insert into  warehouse_info_tbl(f_name,l_name,email,phone_no,age,gender,blood_group)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			conn=getConnection();
			if(conn!=null){
			stmt =conn.prepareStatement(query);
			int i = 0;
			stmt.setString(++i, partnerBo.getWarehouseType());
			stmt.setLong(++i, partnerBo.getAddressId());
			stmt.setString(++i, partnerBo.getTotalArea());
			stmt.setString(++i, partnerBo.getAvailableArea());
			// execute the query
			count = stmt.executeUpdate();
			if (count > 0)
				result = true;
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
}
