package com.studentmanagement.dao;

import java.util.List;

import com.studentmanagement.bean.Teacher;

public interface TeacherDaoI {
	public int create(Teacher teacher);
	public Teacher read(String teacherEmail);
	public int update(Teacher teacher);
	public int delete(String email);
	public int noOfTeachers();
	public List<Teacher> allTeachers();
}
