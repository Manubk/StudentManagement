package com.studentmanagement.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.studentmanagement.bean.Student;
import com.studentmanagement.bean.Teacher;
import com.studentmanagement.dao.StudentDaoI;
import com.studentmanagement.dao.TeacherDaoI;
import com.studentmanagement.dao.TeacherDaoImpl;
import com.studentmanagement.util.DaoUtil;
import com.studentmanagement.util.DbConnectionUtil;

import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int Id,attendance;
	private String name,sex,phone,father,dob,mother,grade,email,parPhone,role,pass = null;
	private long salary,feePaid;
	
	private Teacher teacher = null ;
	private Student student = null ;
	
	private StudentDaoI studentDao = null;
	private TeacherDaoI teacherDao = null;
	
	HttpSession session ;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-->Loginservlet triggred");
		
		session = request.getSession();
		
		// getting the value of role 
		role = (String) request.getParameter("role");
		email = request.getParameter("email");
		pass = request.getParameter("password");
		
		session.setAttribute("role", role);

		
		if(role.equalsIgnoreCase("admin")) {
			//code should be written
		}else if(role.equalsIgnoreCase("teacher")) {
		
			 teacherDao = (teacherDao != null)?teacherDao:DaoUtil.getTeacherDaoObject();
			 teacher = teacherDao.read(email);
			 System.out.println(teacher);
			 //Setting teacher object to session
			 session.setAttribute("userName", teacher.getName());
			 session.setAttribute("email", teacher.getEmail());
			 
			 response.sendRedirect("Home.jsp");
			 
		}else if(role.equalsIgnoreCase("student")) {
			studentDao = (studentDao != null)?studentDao:DaoUtil.getStudentDaoObject();
			student = studentDao.read(email);
			
			//setting the username to the session
			session.setAttribute("userName", student.getName());
			session.setAttribute("email", student.getEmail());
			
			response.sendRedirect("Home.jsp");
			System.out.println("student response sent to Home");
		}else {
			request.setAttribute("loginstatus", "false");
			response.sendRedirect("login.jsp");
		}
		
		
		

	}

}
