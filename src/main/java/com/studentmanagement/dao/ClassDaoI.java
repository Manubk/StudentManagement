package com.studentmanagement.dao;

public interface ClassDaoI {
	public int create(Class class_);
	public Class get(int class_Num ,String section);
	public int update(Class class_);
	public int delete(int class_Num ,String section);
	public int noOfClasses();
}
