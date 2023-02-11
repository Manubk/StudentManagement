package com.studentmanagement.dao;

import com.studentmanagement.bean.Teacher;

public interface TeacherDaoI {
	public int create(Teacher teacher);
	public Teacher read(int teacherId);
	public int update(Teacher teacher);
	public int delete(int teacherId);
}
