package com.studentmanagement.util;

import com.studentmanagement.dao.StudentDaoI;
import com.studentmanagement.dao.StudentDaoImpl;
import com.studentmanagement.dao.TeacherDaoI;
import com.studentmanagement.dao.TeacherDaoImpl;

public class DaoUtil {
	private static TeacherDaoI teacherDaoObject = null;
	public static StudentDaoI studentDaoObject = null;
	
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
	
	

}
