package com.alacriti.bloodbankmanager.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.bloodbankmanager.dao.RegistrationDAO;
import com.alacriti.bloodbankmanager.request.RegistrationRequest;

public class RegistrationDAOImpl extends BaseDAO implements RegistrationDAO {

	final static Logger log = Logger.getLogger(RegistrationDAOImpl.class);

	@Override
	public boolean register(RegistrationRequest request) {
		int count = 0;
		boolean result = false;

		if (log.isInfoEnabled())
			log.info(" in register() ");

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
			stmt.setInt(++i, request.getAge());
			stmt.setString(++i, request.getGender());
			stmt.setString(++i, request.getBloodGroup());
			// execute the query
			count = stmt.executeUpdate();
			if (count > 0)
				result = true;
		}
		} catch (SQLException e) {
			log.error("Some exception occured during register the user " + e.getMessage());
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
}