package com.studentmanagement.util;
import java.sql.*;

public class DbConnectionUtil {
	
	private static Connection connection = null;
	
	//Data Base Credentials
	private static String dbUrl ="jdbc:mysql://localhost:3306/studentmanagementweb?seSSL=false";
	private static String dbUser = "root";
	private static String dbPass =  "8549996008";
	
	/**
	 * 
	 * @return The Connection Object
	 */
	public static Connection getDbConnection() {
		
		try {
			//Loading the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			
			if(connection != null)
				return connection;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}

}
