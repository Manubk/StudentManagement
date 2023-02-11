package com.studentmanagement.dao;

import java.sql.*;
import com.studentmanagement.bean.Teacher;
import com.studentmanagement.util.DbConnectionUtil;

public class TeacherDaoImpl implements TeacherDaoI {
	
	/**
	 * DataBase Queryes where email is taken as Primery Key
	 */
	private final String CREATE_QUERY = "insert into teachers (name,father,sex,dob,phone,email,pass,attendance,salary) values (?,?,?,?,?,?,?,?)";
	private final String SELECT_QUERY = "select * from teacher where email = ?";
	private final String UPDATE_QUERY =	"update teachers set name = ? ,father = ?, pass = ? , dob = ? , phone = ? ,sex = ?,salary = ?, attendance =? where email = ?";
	private final String DELETE_QUERY = "delete from teachers where email = ?";
	
	/**
	 * Data Base resources
	 */
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private Statement statement = null;
	private ResultSet results = null;
	
	
	/**
	 * Normally used variables
	 */
	private int id,attendance ;
	private String name,father,email,pass,phone,sex,dob;
	private long salary;
	
	@Override
	public int create(Teacher teacher) {

		// Setting all the values to instance variables
		name = teacher.getName();
		father = teacher.getFather();
		dob = teacher.getDob();
		sex = teacher.getSex();
		phone = teacher.getPhone();
		email = teacher.getEmail();
		pass = teacher.getPass();
		salary = teacher.getSalary();
		attendance = teacher.getAttendance();

		try {
			connection = DbConnectionUtil.getDbConnection();
			if (connection != null) {
				pStatement = connection.prepareStatement(CREATE_QUERY);
				if (pStatement != null) {
					pStatement.setString(1, name);
					pStatement.setString(2, father);
					pStatement.setString(3, sex);
					pStatement.setString(4, dob);
					pStatement.setString(5, phone);
					pStatement.setString(6, email);
					pStatement.setString(7, pass);
					pStatement.setInt(8, attendance);
					pStatement.setLong(9, salary);

					return pStatement.executeUpdate();

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Teacher read(int teacherId) {
		
		return null;
	}

	@Override
	public int update(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int teacherId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
