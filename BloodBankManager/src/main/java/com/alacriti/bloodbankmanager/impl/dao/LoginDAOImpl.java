package com.alacriti.bloodbankmanager.impl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.alacriti.bloodbankmanager.dao.LoginDAO;
import com.alacriti.bloodbankmanager.lambda.handler.LoginHandler;
import com.alacriti.bloodbankmanager.request.LoginRequest;

public class LoginDAOImpl extends BaseDAO implements LoginDAO{
	
	final static Logger log = Logger.getLogger(LoginDAOImpl.class);
	@Override
	public Boolean validateUser(LoginRequest loginRequest) {
		System.out.println("LoginDAO.validateUser()");
		Connection con = null;
		PreparedStatement ps;
		Boolean result = false;
		ResultSet rs = null;
		String query = "select count(*) from users where user_name=? and password=?";
		try {
			con = getConnection();
			if (con != null) {
				log.debug("Connection is not null");
				ps = con.prepareStatement(query);
				ps.setString(1, loginRequest.getUsername());
				ps.setString(2, loginRequest.getPassword());
				// execute the query
				rs = ps.executeQuery();
				int cnt = 0;
				if (rs.next())
					cnt = rs.getInt(1);
				if (cnt > 0) {
					result = true;
					System.out.println("Result :" + result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
