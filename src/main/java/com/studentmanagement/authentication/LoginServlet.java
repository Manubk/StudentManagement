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
import com.studentmanagement.util.DbConnectionUtil;

import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection = null ;
	private PreparedStatement querys = null ; 
	private ResultSet result = null;
	
	//mysql Credencials 
	private String url = "jdbc:mysql://localhost:3306/studentmanagementweb";
	private String user = "root";
	private String pass = "8549996008";
	
	private PreparedStatement query = null;
	private ResultSet reslut = null;
	
	/**
	 * DataBase Querys 
	 */
	private String queryForTeacher = "select * from teachers where email = ? and pass = ?";
	private String queryForStudent ="select * from students where email = ? and pass = ?";

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String role = request.getParameter("role");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		int teacherId,attendance;
		String name,sex,phone,father,dob = null;
		long salary;
	
		
		// Getting dataBase Connection From UilClass
		connection = DbConnectionUtil.getDbConnection();
		if(connection != null) {
			System.out.println("--> Connected ");
			try {
					
				if (role.equalsIgnoreCase("teacher")) {

					query = connection.prepareStatement(queryForTeacher);
					System.out.println("--> Teacher Query Executed");
					
				} else if (role.equalsIgnoreCase("student")) {
					
					query = connection.prepareStatement(queryForStudent);
					System.out.println("--> Student Query Executed");
				}
				
				if(query != null) {
					query.setString(1, email);
					query.setString(2, pass);
					
					result = query.executeQuery();
					
					if(result != null){
						
						result.next();
						teacherId= result.getInt("teacherid");
						name = result.getString("name");
						sex  = result.getString("sex");
						phone = result.getString("phone");
						father = result.getString("father");
						salary = result.getLong("salary");
						attendance = result.getInt("attendance");
						Teacher teacher ;
						Student student = null;
						System.out.println("--> Got The Values From DB");
						
						//Creating new Teacher or Student  and setting that to session to access the values thorughout
						if(role.equalsIgnoreCase("teacher")) {
							
							System.out.println("--> Created Teacher Object");
							 teacher = new Teacher(email, pass, name, father, dob, phone, sex);
							request.getSession().setAttribute("email", email);
							request.setAttribute("teacher", teacher);
							request.getRequestDispatcher("teacher.jsp").forward(request, response);
							
						}else if(role.equalsIgnoreCase("student")) {
							System.out.println("--> Created Student Object");
							 student  = new Student(name, father, dob, email, pass, phone, sex);
							request.getSession().setAttribute("email", email);
							request.getSession().setAttribute("student", student);
						}
						request.setAttribute("student", student);
						request.getRequestDispatcher("student.jsp").forward(request, response);
//						response.sendRedirect("Home.jsp");
					
						
					}else {
						out.write("OPs No element fount");
					}
					
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				// Closing all the used resources
				try {
					if(connection != null)
						connection.close();
					if(query != null)
						query.close();
					if(result != null)
						result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		
	}

}
