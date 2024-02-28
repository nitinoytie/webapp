package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Users;


@WebServlet("/updateuser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		Users us=new Users();
		us.setId(id);
		us.setFname(fname);
		us.setLname(lname);
		us.setAge(age);
		us.setEmail_id(email);
		us.setPass(pass);
		
		try {
			int st=Dao.updateUser(us);
			if(st>0) {
				pw.print("Records Updated..");
				pw.println("<a href='list'>View User List</a>");
			}
			else {
				pw.print("Records Not Updated..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getStackTrace());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
