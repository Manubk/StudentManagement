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
import com.studentmanagement.dao.StudentDaoI;
import com.studentmanagement.dao.TeacherDaoI;
import com.studentmanagement.dao.TeacherDaoImpl;
import com.studentmanagement.util.DaoUtil;
import com.studentmanagement.util.DbConnectionUtil;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student student;
	private Teacher teacher;
	private String role ;
	private int result;
	private TeacherDaoI teacherDao = null;
	private StudentDaoI studentDao = null;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				role = request.getParameter("role");
				
				switch (role) {
				case "admin": 
					//for admit code is peding
					break;
					
				//setting the values from request object to teacher directly
				case "teacher": teacher = new Teacher(request.getParameter("name"),request.getParameter("dob"),
								request.getParameter("sex"),request.getParameter("father"),
								request.getParameter("phone"),request.getParameter("email"),
								request.getParameter("password"),0,0);
	
					teacherDao = (teacherDao != null )?teacherDao:DaoUtil.getTeacherDaoObject();
					result = teacherDao.create(teacher);
					if(result > 0)
						response.sendRedirect("login.jsp");
					else
						response.sendRedirect("signup.jsp");
					break;
				
				//Setting the values from request object to student constructor
				case "student": student = new Student(0,request.getParameter("name"),
						request.getParameter("dob"),request.getParameter("sex"),
						request.getParameter("father"),null,request.getParameter("phone"),
						null,request.getParameter("email"),request.getParameter("password"),0,0,0);
				
				studentDao = (studentDao!=null)?studentDao:DaoUtil.getStudentDaoObject();
				result = studentDao.create(student);
				
				if(result > 0) {
					System.out.println("--> signUp sucess");
					response.sendRedirect("login.jsp");
				}else {
					System.out.println("--> signup not sucess");
					response.sendRedirect("signup.jsp");
				}
					
				}
				
		
	}

}
