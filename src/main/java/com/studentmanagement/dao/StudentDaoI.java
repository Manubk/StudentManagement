package com.studentmanagement.dao;

import java.util.List;

import com.studentmanagement.bean.Student;

public interface StudentDaoI {
	public int create(Student student);
	public Student read(String email);
	public int update(Student student);
	public int delete(String email);
	public int noOfStudents();
	public List<Student> getAllStudents() ;
}
