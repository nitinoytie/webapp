package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.Dao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Users;

@WebServlet("/user")
public class UserServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		int clength=request.getContentLength();
		
		Users us=new Users();
		us.setFname(fname);
		us.setLname(lname);
		us.setAge(age);
		us.setEmail_id(email);
		us.setPass(pass);
		
		try {
			
			if (Dao.save(us)>0) {
				pw.println("Inserted..");
//				pw.println("<a href='list'>View User List</a>");
				RequestDispatcher rd=request.getRequestDispatcher("list");
				rd.include(request, response);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.print(e.getMessage());
			
		}
	
		
	}

}
