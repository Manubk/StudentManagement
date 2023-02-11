package com.studentmanagement.bean;

public class Student {
	private int student_Id ;
	private int class_Id;
	private String name;
	private String father;
	private String dob;
	private String email;
	private String pass;
	private long freePaid;
	private int attandance;
	private int grade;
	private String phone;
	private String sex;
	public Student(String name, String father, String dob, String email, String pass, String phone, String sex) {
		this.name = name;
		this.father = father;
		this.dob = dob;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
		this.sex = sex;
	}
	public int getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	public int getClass_Id() {
		return class_Id;
	}
	public void setClass_Id(int class_Id) {
		this.class_Id = class_Id;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public long getFreePaid() {
		return freePaid;
	}
	public void setFreePaid(long freePaid) {
		this.freePaid = freePaid;
	}
	public int getAttandance() {
		return attandance;
	}
	public void setAttandance(int attandance) {
		this.attandance = attandance;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
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
	
	
	
	
	
}
