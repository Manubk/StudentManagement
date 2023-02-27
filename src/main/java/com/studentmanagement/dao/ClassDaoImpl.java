package com.studentmanagement.dao;

import java.sql.*;
import java.util.List;

import com.studentmanagement.bean.Student;
import com.studentmanagement.util.DbConnectionUtil;

public class ClassDaoImpl implements ClassDaoI {
	
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private Statement statement = null;
	private ResultSet results = null;
	private int result = 0;
	
	private final String NUM_OF_CLASSES ="select count(*) from class";
	
	@Override
	public int create(Class class_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Class get(int class_Num, String section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Class class_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int class_Num, String section) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noOfClasses() {
		System.out.println("--> ClassDaoImpl noOfClasses");
		
		try {
			connection = (connection != null)?connection:DbConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(NUM_OF_CLASSES);
			System.out.println("--> value returned "+result);
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public List<Student> students(int classNum){
		
	}

}
