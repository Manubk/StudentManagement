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
@WebServlet({ "/addteacher", "/deleteteacher", "/updateteacher", "/getteacher" })
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Teacher teacher = null ;
	private TeacherDaoI teacherDao = null;
	
	private int id,attendance;
	private String name,sex,phone,father,dob,grade,email,parPhone,role,pass = null;
	private long salary;
	private int result1 = 0;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("--> sending to doPost");
			doPost(req, resp);
		}
 
	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/updateteacher":

		     	role = (String)request.getSession().getAttribute("role");
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
				if(role.equalsIgnoreCase("teacher"))
					response.sendRedirect("teacher.jsp");
				else if(role.equalsIgnoreCase("admin"))
					response.sendRedirect("All-Teachers.jsp");
			}else {
				request.setAttribute("status", "false");
				if(role.equalsIgnoreCase("teacher"))
					response.sendRedirect("teacher.jsp");
				else if(role.equalsIgnoreCase("admin"))
					response.sendRedirect("All--Teachers.jsp");
			}
			break;
		case "/deleteteacher" :
			email = request.getParameter("email");
			teacherDao = (teacherDao != null)?teacherDao:DaoUtil.getTeacherDaoObject();
			result1 = teacherDao.delete(email);
			if(result1 > 0) {
				request.setAttribute("status", "true");
			}else {
				request.setAttribute("status", "false");
			}
			response.sendRedirect("All-Teachers.jsp");
			break;
		case "/addteacher" :
			name = request.getParameter("name");
			dob = request.getParameter("dob");
			sex = request.getParameter("sex");
			father = request.getParameter("father");
		    email = request.getParameter("email");
			pass = request.getParameter("password");
			phone = request.getParameter("phone"); 
			attendance = Integer.parseInt((String)request.getParameter("attendance"));
			salary = Long.parseLong(request.getParameter("salary"));
			
			teacher = new Teacher(name, dob, sex, father, phone, email, pass, attendance, salary);
			teacherDao = (teacherDao != null)?teacherDao:DaoUtil.getTeacherDaoObject();
			result1 = teacherDao.create(teacher);
			
			if(result1 >0) {
				request.setAttribute("status", "true");
				response.sendRedirect("All-Teachers.jsp");
			}else {
				request.setAttribute("status", "false");
				response.sendRedirect("addteacher.jsp");
			}

					
			break;
		default : 
			
			
		}
		
	}

}
