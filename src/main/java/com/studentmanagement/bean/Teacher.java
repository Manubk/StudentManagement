package com.studentmanagement.bean;

import java.net.PasswordAuthentication;

public class Teacher {
	private int teacher_id;
	private String name;
	private String father;
	private String email;
	private String pass;
	private String dob;
	private String phone;
	private String sex ;
	private long salary ;
	private int attendance;
	public Teacher( String email, String pass ,String name, String father, String dob, String phone, String sex) {
		super();
		this.name = name;
		this.father = father;
		this.email = email;
		this.pass = pass;
		this.dob = dob;
		this.phone = phone;
		this.sex = sex;
	
	}
	
	
	public Teacher(int teacher_id, String name, String father, String email, String pass, String dob, String phone,
			String sex, long salary, int attendance) {
		super();
		this.teacher_id = teacher_id;
		this.name = name;
		this.father = father;
		this.email = email;
		this.pass = pass;
		this.dob = dob;
		this.phone = phone;
		this.sex = sex;
		this.salary = salary;
		this.attendance = attendance;
	}


	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
	
	
	

}
