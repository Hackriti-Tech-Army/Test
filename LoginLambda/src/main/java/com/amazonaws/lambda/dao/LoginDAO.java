package com.amazonaws.lambda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.amazonaws.lambda.demo.LoginRequest;

public class LoginDAO {

	private static final String dbUrl = "jdbc:mysql://hackriti10c.cmboaqgjozj1.us-east-2.rds.amazonaws.com:3306/test";
	private static final String username = "digsingh144";
	private static final String password = "pass1234";
	private static final String driverClass="com.mysql.jdbc.Driver";

	public Boolean validateUser(LoginRequest loginRequest) {
		System.out.println("LoginDAO.validateUser()");
		Connection con = null;
		PreparedStatement ps;
		Boolean result = false;
		ResultSet rs = null;
		String query = "select count(*) from users where user_name=? and password=?";
		try {
			System.out.println("loading Driver before");
			Class.forName(driverClass);
			System.out.println("loading Driver after");
			con = DriverManager.getConnection(dbUrl, username, password);
			System.out.println("------------connection------------");
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
			System.out.println("END 1");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception 1");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception 2");
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("digvijay");
		loginRequest.setPassword("pass");
		new LoginDAO().validateUser(loginRequest);
	}
}
