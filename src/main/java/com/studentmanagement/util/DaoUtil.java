package com.studentmanagement.util;

import com.studentmanagement.dao.AdminDaoI;
import com.studentmanagement.dao.AdminDaoImpl;
import com.studentmanagement.dao.StudentDaoI;
import com.studentmanagement.dao.StudentDaoImpl;
import com.studentmanagement.dao.TeacherDaoI;
import com.studentmanagement.dao.TeacherDaoImpl;

public class DaoUtil {
	private static TeacherDaoI teacherDaoObject = null;
	public static StudentDaoI studentDaoObject = null;
	public static AdminDaoI adminDaoObject = null;
	
	//creating DaoObject of Teacher
	public static TeacherDaoI getTeacherDaoObject() {
		if(teacherDaoObject == null) {
			teacherDaoObject = new TeacherDaoImpl();
			return teacherDaoObject;
		}
		return teacherDaoObject;
	}
	
	//creating DaoObjects of Student
	public static StudentDaoI getStudentDaoObject() {
		if(studentDaoObject == null) {
			return  new StudentDaoImpl();
		}
		return studentDaoObject;
	}
	
	//creating instance of admindao 
	public static AdminDaoI getAdminDaoObject() {
		if(adminDaoObject == null)
			return new AdminDaoImpl();
		
		return adminDaoObject;
	}
	

}
