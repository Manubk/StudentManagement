package com.studentmanagement.dao;

import com.studentmanagement.bean.Admin;

public interface AdminDaoI {
	public int create(Admin admin);
	public Admin read(int id);
	public int delete(int id);
	public int update(Admin admin);
	public Admin findByEmailPass(String email,String pass);
}
