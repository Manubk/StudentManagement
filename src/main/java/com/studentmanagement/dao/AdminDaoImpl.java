package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagement.bean.Admin;
import com.studentmanagement.util.DbConnectionUtil;

public class AdminDaoImpl implements AdminDaoI {
	
	//Db resources
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet results = null;
	
	Admin admin = null;
	
	//db queryes
	private final String READ_ADMIN ="select * from admin where id = ?";
	private final String READ_BY_EMAIL_PASS ="select * from admin where email = ? and pass = ? ";
	@Override
	public int create(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admin read(int id) {
		System.out.println("--> AdminDaoImpl -> read()");
		try {
			connection = (connection != null)?connection:DbConnectionUtil.getDbConnection();
		
			pStatement = connection.prepareStatement(READ_ADMIN);
		
			results = pStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("-->AdminDaoImpl -> read ->Exception");
			System.out.println("-------------------------------------");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Admin findByEmailPass(String email,String pass) {
		System.out.println("--> AdminDaoImpl -> findByEmailPass");
		try {
		connection = (connection!=null)?connection:DbConnectionUtil.getDbConnection();
		System.out.println("-->connection created");
		pStatement = connection.prepareStatement(READ_BY_EMAIL_PASS);
		pStatement.setString(1, email);
		pStatement.setString(2, pass);
		
		results = pStatement.executeQuery();
		results.next();
		System.out.println("-->results created");
		admin = new Admin(results.getInt("id"), results.getString("name"), results.getString("email"),
				results.getString("pass"));
		System.out.println("-->sending results");
		System.out.println("----------------------------------------");
		return admin;
		} catch (SQLException e) {
		System.out.println("-->findByEmailPass Exceptions");
		System.out.println("----------------------------------------");
			e.printStackTrace();
		}
		
		return null;
	}
	

}
