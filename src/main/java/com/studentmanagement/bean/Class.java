package com.studentmanagement.bean;

import java.util.List;

public class Class {
	private int id ;
	private int number ;
	private String section;
	private Teacher teacher;
	private Long fee;
	private List<Student> students ;
	
	public Class(int id, int number, String section, Teacher teacher, Long fee) {
		super();
		this.id = id;
		this.number = number;
		this.section = section;
		this.teacher = teacher;
		this.fee = fee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Long getFee() {
		return fee;
	}
	public void setFee(Long fee) {
		this.fee = fee;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(Student students) {
		this.students.add(students);
	} 
	
	

}
