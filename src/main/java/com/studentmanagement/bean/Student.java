package com.studentmanagement.bean;

public class Student {
	private int student_Id ;
	private int class_Id;
	private String name;
	private String dob;
	private String sex;
	private String father;
	private String mother;
	private String phone;
	private String parPhone;
	private String email;
	private String pass;
	private int grade;
	private int attandance;
	private long freePaid;
	
	//for starting creation studentid is generated automaticall by DB
	public Student(int class_Id, String name, String dob, String sex, String father, String mother, String phone,
			String parPhone,String email, String pass, int grade, int attandance, long freePaid) {
		super();
		this.class_Id = class_Id;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.father = father;
		this.mother = mother;
		this.phone = phone;
		this.parPhone = parPhone;
		this.email = email;
		this.pass = pass;
		this.grade = grade;
		this.attandance = attandance;
		this.freePaid = freePaid;
	}
	
	//For update purpose taken email as username
	public Student(int student_Id ,int class_Id, String name, String dob, String sex, String father, String mother, String phone,
			String parPhone,String email, String pass, int grade, int attandance, long freePaid) {
		super();
		this.student_Id = student_Id;
		this.class_Id = class_Id;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.father = father;
		this.mother = mother;
		this.phone = phone;
		this.parPhone = parPhone;
		this.email = email;
		this.pass = pass;
		this.grade = grade;
		this.attandance = attandance;
		this.freePaid = freePaid;
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
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}


	public String getParPhone() {
		return parPhone;
	}

	public void setParPhone(String parPhone) {
		this.parPhone = parPhone;
	}

	@Override
	public String toString() {
		return "Student [student_Id=" + student_Id + ", class_Id=" + class_Id + ", name=" + name + ", dob=" + dob
				+ ", sex=" + sex + ", father=" + father + ", mother=" + mother + ", phone=" + phone + ", parPhone="
				+ parPhone + ", email=" + email + ", pass=" + pass + ", grade=" + grade + ", attandance=" + attandance
				+ ", freePaid=" + freePaid + "]";
	}
	
	
	
	
}
