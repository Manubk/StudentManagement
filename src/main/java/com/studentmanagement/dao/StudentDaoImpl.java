package com.studentmanagement.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.bean.Student;
import com.studentmanagement.util.DbConnectionUtil;

public class StudentDaoImpl implements StudentDaoI {
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private Statement statement = null;
	private ResultSet result = null;
	private int result1 = 0;
	
	
	//Bean
	private Student student = null;
	private List<Student> students = null;
	
	//Db Querys
	private final String CREATE_QUERY = "insert into students (class_id, name, dob,sex,father,mother,phone,parphone,email,pass,grade,attandance,feepaid) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String NO_OF_STUDENTS = "select count(*) from students"; 
	private final String READ_STUDENT ="select * from students where email = ?";
	private final String UPDATE_STUDENT ="update students set student_id = ? , class_id =?, name = ? ,dob = ?,sex = ?,father = ? ,mother = ? ,phone = ? ,parphone = ? , email = ? ,pass = ? ,grade = ?,feepaid= ?,attandance = ? where email = ?";
	private final String SELECT_STUDENTS = "select * from students";
	private final String DELETE_STUDENT ="delete from students where email = ?";
	private final String STUDENTS_OF_CLASS="select * from students where class_id = ?";
	
	private int student_Id ;
	private int class_Id;
	private String name;
	private String dob;
	private String sex;
	private String father;
	private String mother;
	private String phone;
	private String parPhone;
	private String email;
	private String pass;
	private int grade;
	private int attandance;
	private long freePaid;
	
	@Override
	public int create(Student student) {
		System.out.println("StudentDaoImpl --> create");
		try {
			System.out.println("-->creating connection ");
		connection = (connection != null)?connection :DbConnectionUtil.getDbConnection();
			
			System.out.println("-->creating P statement");
			pStatement =  connection.prepareStatement(CREATE_QUERY);
			pStatement.setInt(1, student.getClass_Id());
			pStatement.setString(2, student.getName());
			pStatement.setString(3, student.getDob());
			pStatement.setString(4,student.getSex());
			pStatement.setString(5, student.getFather());
			pStatement.setString(6, student.getMother());
			pStatement.setString(7, student.getPhone());
			pStatement.setString(8, student.getParPhone());
			pStatement.setString(9, student.getEmail());
			pStatement.setString(10, student.getPass());
			pStatement.setInt(11, student.getGrade());
			pStatement.setInt(12, student.getAttandance());
			pStatement.setLong(13, student.getFreePaid());
			
			return pStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("StudentDaoImpl --> Exception");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Student read(String email) {
		System.out.println("StudentDaoImpl --> read()");
		try {
		connection = (connection != null )?connection:DbConnectionUtil.getDbConnection();
		System.out.println("-->connection created");
		pStatement = connection.prepareStatement(READ_STUDENT);
		pStatement.setString(1, email);
		
		result = pStatement.executeQuery();
		result.next();
		System.out.println(result.getString("father")+"12");
		
			System.out.println("-->got result form db");
			student = new Student(result.getInt("student_id"), result.getInt("class_id"),
				   result.getString("name"), result.getString("dob"), result.getString("sex"),
				   result.getString("father"), result.getString("mother"),result.getString("phone"),
				   result.getString("parphone"),result.getString("email"),result.getString("pass"),
				   result.getInt("grade"), result.getInt("attandance"),result.getLong("feepaid"));
		
		System.out.println(student);
		System.out.println("----------------------------------------");
		return student;
		
		} catch (SQLException e) {
			System.out.println("-->Exception in read()");
			System.out.println("----------------------------------------");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Student student) {
		System.out.println("-->StudentDaoImpl update()");
		try {
		connection = (connection!=null)?connection:DbConnectionUtil.getDbConnection();
		System.out.println("-->connection created");
		
		pStatement = connection.prepareStatement(UPDATE_STUDENT);
		pStatement.setInt(1, student.getStudent_Id());
		pStatement.setInt(2, student.getClass_Id());
		pStatement.setString(3, student.getName());
		pStatement.setString(4, student.getDob());
		pStatement.setString(5, student.getSex());
		pStatement.setString(6, student.getFather());
		pStatement.setString(7, student.getMother());
		pStatement.setString(8, student.getPhone());
		pStatement.setString(9, student.getParPhone());
		pStatement.setString(10, student.getEmail());
		pStatement.setString(11, student.getPass());
		pStatement.setInt(12, student.getGrade());
		pStatement.setInt(13, student.getAttandance());
		pStatement.setLong(14, student.getFreePaid());
		pStatement.setString(15, student.getEmail());
		
		System.out.println(pStatement);
		result1 = pStatement.executeUpdate();
		
		if(result1>0) {
			System.out.println("-->Update sucessfull");
			System.out.println("----------------------------------------");
			return result1;
		}
		
		} catch (SQLException e) {
			System.out.println("--> update Exception");
			System.out.println("----------------------------------------");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(String email) {
		System.out.println("--> StudentDaoImpl -> delete");
		try {
		connection = (connection != null)?connection:DbConnectionUtil.getDbConnection();
		pStatement = connection.prepareStatement(DELETE_STUDENT);
		pStatement.setString(1, email);
		result1 = pStatement.executeUpdate();
		if(result1 > 0) {
			System.out.println("--> delected successful");
			System.out.println("----------------------------------------");
		}else {
			System.out.println("--> found error ");
			System.out.println("----------------------------------------");
		}
		return result1;
		} catch (SQLException e) {
			System.out.println("-->delete Exception");
			System.out.println("----------------------------------------");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int noOfStudents() {
		System.out.println("studentDaoImpl --> noOfStudents");
		try {
		connection = (connection != null)?connection :DbConnectionUtil.getDbConnection();
		
	    statement = connection.createStatement();
	    result = statement.executeQuery(NO_OF_STUDENTS);
	    System.out.println("--> got result");
		System.out.println("--------------------------------------------------");
		
	    if(result.next())
	    	return result.getInt(1);
	    
		} catch (SQLException e) {
			System.out.println("studentDaoImpl --> noOfStudents Exception");
			System.out.println("--------------------------------------------------");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> getAllStudents() {
		System.out.println("--> StudentDaoImpl -> getAllStudents ");
		students = new ArrayList<Student>();
		try {
		connection = (connection != null)?connection:DbConnectionUtil.getDbConnection();
		
		statement = connection.createStatement();
		result = statement.executeQuery(SELECT_STUDENTS);
		
		while(result.next()) {
			student = new Student(result.getInt("student_id"), result.getInt("class_id"),
					   result.getString("name"), result.getString("dob"), result.getString("sex"),
					   result.getString("father"), result.getString("mother"),result.getString("phone"),
					   result.getString("parphone"),result.getString("email"),result.getString("pass"),
					   result.getInt("grade"), result.getInt("attandance"),result.getLong("feepaid"));
			
			students.add(student);
		}
		System.out.println("--> sent list of students");
		System.out.println("--------------------------------------");
		return students;
		} catch (SQLException e) {
			System.out.println("-->getAllstudents Exception");
			System.out.println("--------------------------------------");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> studentOfClass(int class_id) {
		System.out.println("--> StudentDaoImpl --> studentOfClass");
		try {
		connection = (connection != null)?connection:DbConnectionUtil.getDbConnection();
	    pStatement = connection.prepareStatement(STUDENTS_OF_CLASS);
	    pStatement.setInt(1, class_id);
	    result = pStatement.executeQuery();
	    List<Student> students = new ArrayList<Student>();
	    while(result.next()) {
			student = new Student(result.getInt("student_id"), result.getInt("class_id"),
					   result.getString("name"), result.getString("dob"), result.getString("sex"),
					   result.getString("father"), result.getString("mother"),result.getString("phone"),
					   result.getString("parphone"),result.getString("email"),result.getString("pass"),
					   result.getInt("grade"), result.getInt("attandance"),result.getLong("feepaid"));
			
			students.add(student);
		}
	    System.out.println("--> Students returnes");
	    System.out.println("----------------------------------------");
	    return students;
		} catch (SQLException e) {
			System.out.println("--> studuntOfClass exception");
			System.out.println("----------------------------------------");
			e.printStackTrace();
		}
		
		return null;
	}

}
