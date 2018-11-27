package com.alacriti.bloodbankmanager.impl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class BaseDAO {
	final static Logger log = Logger.getLogger(BaseDAO.class);

	protected static final String dbUrl = "jdbc:mysql://hackriti10c.cmboaqgjozj1.us-east-2.rds.amazonaws.com:3306/test";
	protected static final String username = "digsingh144";
	protected static final String password = "pass1234";
	protected static final String driverClass = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
		log.debug("in getConnection()");
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(dbUrl, username, password);
			if(conn!=null)
				log.info("Sccessfuly got db connection");
		} catch (ClassNotFoundException e) {
			log.error("Some exception occured while loading  driver class " + e.getMessage());
		} catch (SQLException se) {
			log.error("Some exception occured while getting connection " + se.getMessage());
		}

		return conn;
	}
	 public static void close(ResultSet rs)
	    {
	        if (rs != null)
	        {
	            try
	            {
	                rs.close();
	            }
	            catch (Exception e)
	            {
	                log.error(e.getMessage(), e);
	            }
	        }
	    }

	    public static void close(Statement stmt)
	    {
	        if (stmt != null)
	        {
	            try
	            {
	                stmt.close();
	            }
	            catch (Exception e)
	            {
	                log.error(e.getMessage(), e);
	            }
	        }
	    }
	    public static void close(Connection conn)
	    {
	        if (conn != null)
	        {
	            try
	            {
	                conn.close();
	            }
	            catch (Exception e)
	            {
	                log.error(e.getMessage(), e);
	            }
	        }
	    }

}
