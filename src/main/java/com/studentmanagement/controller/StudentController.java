package com.studentmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.studentmanagement.bean.Student;
import com.studentmanagement.dao.StudentDaoI;
import com.studentmanagement.util.DaoUtil;

@WebServlet({ "/addstudent", "/updatestudent", "/deletestudent" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDaoI studentDao = null;
	
	private Student student = null;
	
	private int result;
   
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		System.out.println("--> passed to dopost");
			doPost(request, response);
		} catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = (String)request.getSession().getAttribute("role");
		String path = request.getServletPath();
		System.out.println(request.getServletPath());
		switch(path) {
		case "/updatestudent": System.out.print("entered");
			student = new Student(Integer.parseInt(request.getParameter("id")),
				Integer.parseInt(request.getParameter("classId")),request.getParameter("name"), request.getParameter("dob"), request.getParameter("sex"),
				request.getParameter("father"), request.getParameter("mother"), request.getParameter("phone"),
				request.getParameter("parPhone"), request.getParameter("email"), request.getParameter("password"),
				Integer.parseInt(request.getParameter("grade")),Integer.parseInt(request.getParameter("attendance")),
				Long.parseLong(request.getParameter("feePaid")));
				
				studentDao = (studentDao!=null)?studentDao:DaoUtil.getStudentDaoObject();
				
				result = studentDao.update(student);
				if(result >0) {
					request.setAttribute("status", "true");
					if(role.equalsIgnoreCase("student"))
						response.sendRedirect("student.jsp");
					else if(role.equalsIgnoreCase("admin"))
						response.sendRedirect("admin.jsp");
				}else {
					request.setAttribute("status", "false");
					if(role.equalsIgnoreCase("student"))
						response.sendRedirect("student.jsp");
					else if(role.equalsIgnoreCase("admin"))
						response.sendRedirect("admin.jsp");
				}
			break;
		case "/deletestudent":
				System.out.println("--> studentController -> deletedtudent");
				String email = request.getParameter("email");
				studentDao = (studentDao != null)?studentDao:DaoUtil.getStudentDaoObject();
				int result = studentDao.delete(email);
				if(result > 0) {
					request.setAttribute("deleteStatus", "true");
					response.sendRedirect("All-Students.jsp");
				}else {
					request.setAttribute("deleteStatus", "false");
					response.sendRedirect("All-Students.jsp");
				}
				
			break;
		case "/addstudent" :
			student = new Student(Integer.parseInt(request.getParameter("classId")),request.getParameter("name"),
					request.getParameter("dob"), request.getParameter("sex"),request.getParameter("father"),
					request.getParameter("mother"), request.getParameter("phone"),request.getParameter("parPhone"), 
					request.getParameter("email"), request.getParameter("password"),Integer.parseInt(request.getParameter("grade")),
					Integer.parseInt(request.getParameter("attendance")),Long.parseLong(request.getParameter("feePaid")));
			studentDao = (studentDao != null)?studentDao:DaoUtil.getStudentDaoObject();
			result = studentDao.create(student);
			if(result > 0) {
				request.setAttribute("status", "true");
				response.sendRedirect("All-Students.jsp");
			}else {
				request.setAttribute("status", "fail");
				response.sendRedirect("add-student.jsp");
			}

			break;
			
		
		}
	}

}
