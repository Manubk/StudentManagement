package com.studentmanagement.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.studentmanagement.bean.Teacher;
import com.studentmanagement.dao.TeacherDaoI;
import com.studentmanagement.dao.TeacherDaoImpl;
import com.studentmanagement.util.DbConnectionUtil;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement query = null;
	private Connection connection = null;
	private PrintWriter out ;
	private TeacherDaoI tdao = null ;
	

	/**
	 * Db queryes
	 */
	private String insertTeacherQuery = "insert into teachers (email,pass,name,father,dob,sex,phone) values (?,?,?,?,?,?,?)";
	private String insertStudentQuery = "insert into students (email,pass,name,father,dob,sex,phone) values (?,?,?,?,?,?,?)";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Getting the values form request object
		    String role = request.getParameter("role");
		    String email = request.getParameter("email");
			String pass = request.getParameter("password");
			String name = request.getParameter("name");
			String father = request.getParameter("father");
			String dob = request.getParameter("dob");
			String sex = request.getParameter("sex");
			String phone = request.getParameter("phone");
		try {
			//Getting connection from util class and getting preparedstatement using conection
				connection = DbConnectionUtil.getDbConnection();
				if(connection!=null) {
					if(role.equalsIgnoreCase("teacher")) {
						Teacher teacher = new Teacher(email, pass, name, father, dob, phone, sex);
						tdao = new TeacherDaoImpl().create(teacher);
					query = connection.prepareStatement(insertTeacherQuery);
				}else if(role.equalsIgnoreCase("student")) {
					query = connection.prepareStatement(insertStudentQuery);
				}
					query.setString(1, email);
					query.setString(2, pass);
					query.setString(3, name);
					query.setString(4, father);
					query.setString(5, dob);
					query.setString(6,sex);
					query.setString(7, phone);
				
					int result = query.executeUpdate();
				
					//adding email to the session to validate through out the session
					HttpSession session = request.getSession();
					session.setAttribute(email, email);
					request.getRequestDispatcher("/Home.jsp").forward(request, response);
				
				}else {
					// If connection fails go to signup page
					request.getRequestDispatcher("/signup.jsp").forward(request, response);
					
				}
				
			
			
			
		} catch (SQLException e) {
			//request.getRequestDispatcher("/signup.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}

}
