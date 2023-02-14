package com.studentmanagement.dao;

import java.sql.*;
import com.studentmanagement.bean.Teacher;
import com.studentmanagement.util.DbConnectionUtil;

public class TeacherDaoImpl implements TeacherDaoI {
	
	/**
	 * DataBase Queryes where email is taken as Primery Key
	 */
	private final String CREATE_QUERY = "insert into teachers (name,father,sex,dob,phone,email,pass,attendance,salary) values (?,?,?,?,?,?,?,?,?)";
	private final String SELECT_QUERY = "select * from teachers where email = ?";
	private final String UPDATE_QUERY =	"update teachers set name = ? ,father = ?, dob = ?,sex = ?, phone = ?, pass = ? ,salary = ?, attendance =? where email = ?";
	private final String DELETE_QUERY = "delete from teachers where email = ?";
	private final String NO_OF_TEACHERS ="select count(*) from teachers;";
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
	
	private Teacher teacher = null ;
	
	@Override
	public int create(Teacher teacher) {
		System.out.println("TeacherDaoImpl --> Create");
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
				System.out.println("--> Connection is Created");
				pStatement = connection.prepareStatement(CREATE_QUERY);
				if (pStatement != null) {
					System.out.println("--> PStatement is Created");
					pStatement.setString(1, name);
					pStatement.setString(2, father);
					pStatement.setString(3, sex);
					pStatement.setString(4, dob);
					pStatement.setString(5, phone);
					pStatement.setString(6, email);
					pStatement.setString(7, pass);
					pStatement.setInt(8, attendance);
					pStatement.setLong(9, salary);
					System.out.println(teacher.toString());
					System.out.println("-->Executed the pStatement");
					return pStatement.executeUpdate();

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println(" TeacherDaoImpl --> Closing the Resources ");
				connection.close();
				pStatement.close();
				if(results != null)
					results.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
	}

	@Override
	public Teacher read(String email) {
		System.out.println("TeacherDaoImpl --> read()");
		if(connection == null ) {
			connection = DbConnectionUtil.getDbConnection();
		}
		System.out.println("--> connection is Ready");
		try {
			pStatement = connection.prepareStatement(SELECT_QUERY);
			if(pStatement != null) {
				System.out.println("--> statement is ready");
				pStatement.setString(1, email);
				results = pStatement.executeQuery();
				if(results != null) {
					System.out.println("--> got values from db");
					if(results.next()) {
						System.out.println("--> creating an teacher object ");
						id = results.getInt("teacherId");
						name = results.getString("name");
						father = results.getString("father");
						dob = results.getString("dob");
						sex = results.getString("sex");
						phone = results.getString("phone");
						email = results.getString("email");
						pass = results.getString("pass");
						salary = results.getLong("salary");
						attendance = results.getInt("attendance");
						
						// creating a teacher object
						teacher = new Teacher(name, dob, sex, father, phone, email, pass, attendance, salary);
						System.out.println("--> created and sent");
						System.out.println("----------------------------------------");
						return teacher;
						
						
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("TeacherDaoImpl --> Exception");
			System.out.println("----------------------------------------");
			e.printStackTrace();
		}finally {
			
		}
		
		
		return null;
	}

	@Override
	public int update(Teacher teacher) {
		System.out.println("TeacherDaoImpl --> Update");
		int result = 0;
		name = teacher.getName();
		father = teacher.getFather();
		dob = teacher.getDob();
		sex = teacher.getSex();
		phone = teacher.getPhone();
		email = teacher.getEmail();
		pass = teacher.getPass();
		salary = teacher.getSalary();
		attendance = teacher.getAttendance();
		
		connection = DbConnectionUtil.getDbConnection();
		
		try {
			pStatement = connection.prepareStatement(UPDATE_QUERY);
			
			pStatement.setString(1,name);
			pStatement.setString(2, father);
			pStatement.setString(3, dob);
			pStatement.setString(4, sex);
			pStatement.setString(5, phone);
			pStatement.setString(6, pass);
			pStatement.setLong(7, salary);
			pStatement.setInt(8, attendance);
			pStatement.setString(9, email);
			
			System.out.println(teacher.getEmail());
			System.out.println(pStatement.toString());
		    result = pStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
		}
		return  result;
		
		
	}

	@Override
	public int delete(int teacherId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int noOfTeachers(){
		System.out.println("TeacherDaoImpl --> noOfTeachers");
		try {
		connection = (connection !=null )?connection:DbConnectionUtil.getDbConnection();
		System.out.println("--> connection created");
		statement = connection.prepareStatement(NO_OF_TEACHERS);
		
		results = statement.executeQuery(NO_OF_TEACHERS);
		results.next();
		
		return results.getInt(1);
		
		} catch (SQLException e) {
			System.out.println("TeacherDaoImpl --> Exception");
			e.printStackTrace();
		}
		return 0;
		
	}
}
