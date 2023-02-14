package com.studentmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.bean.Teacher;
import com.studentmanagement.dao.TeacherDaoI;
import com.studentmanagement.util.DaoUtil;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet({ "/saveteacher", "/deleteteacher", "/updateteacher", "/getteacher" })
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Teacher teacher = null ;
	private TeacherDaoI teacherDao = null;
	
	private int id,attendance;
	private String name,sex,phone,father,dob,grade,email,parPhone,role,pass = null;
	private long salary;
	private int result1 = 0;
 
	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/updateteacher":

		     	role = request.getParameter("role");
				id = Integer.parseInt(request.getParameter("id"));
				name = request.getParameter("name");
				dob = request.getParameter("dob");
				sex = request.getParameter("sex");
				father = request.getParameter("father");
			    email = request.getParameter("email");
				pass = request.getParameter("password");
				phone = request.getParameter("phone"); 
				attendance = Integer.parseInt((String)request.getParameter("attendance"));
				salary = Long.parseLong(request.getParameter("salary"));
				
				teacher = new Teacher(id, name, dob, sex, father, phone,email, pass, attendance, salary);
				System.out.println("update teacher");
				System.out.println(teacher);
				teacherDao = (teacherDao != null)?teacherDao:DaoUtil.getTeacherDaoObject();
				result1= teacherDao.update(teacher);
			if(result1 > 0) {
				System.out.println("TeacherController -> Update Sucesssfull");
				request.setAttribute("status", "true");
				response.sendRedirect("teacher.jsp");
			}else {
				request.setAttribute("status", "false");
				response.sendRedirect("teacher-edit.jsp");
			}
			break;
		default : 
			
			
		}
		
	}

}
