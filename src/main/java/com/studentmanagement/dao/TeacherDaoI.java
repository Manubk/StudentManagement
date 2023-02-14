package com.studentmanagement.dao;

import com.studentmanagement.bean.Teacher;

public interface TeacherDaoI {
	public int create(Teacher teacher);
	public Teacher read(String teacherEmail);
	public int update(Teacher teacher);
	public int delete(int teacherId);
	public int noOfTeachers();
}
