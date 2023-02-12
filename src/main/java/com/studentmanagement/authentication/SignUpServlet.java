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
import com.studentmanagement.bean.Student;
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
	private int tdao ;
	private Student student;
	private Teacher teacher;
	

	/**
	 * Db queryes
	 */
	private String insertTeacherQuery = "insert into teachers (email,pass,name,father,dob,sex,phone) values (?,?,?,?,?,?,?)";
	private String insertStudentQuery = "insert into students (email,pass,name,father,dob,sex,phone) values (?,?,?,?,?,?,?)";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		
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
					//if the role is teacher 
					if(role.equalsIgnoreCase("teacher")) {
						teacher = new Teacher(email, pass, name, father, dob, phone, sex);
						tdao = new TeacherDaoImpl().create(teacher);
					}else if(role.equalsIgnoreCase("student")) {
					//should create a code
					}
					if(tdao > 0)
					System.out.println("SignUpServlet --> Created Sucessfully");
					response.sendRedirect("login.jsp");
				} catch (Exception e) {
					response.sendRedirect("signup.jsp");
				}
				
			
		
		
	}

}
