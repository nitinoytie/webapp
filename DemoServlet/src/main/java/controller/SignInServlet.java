package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Users;


@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		
		try {
			if(dao.Dao.checkuser(email,pass)) {
				int days=10;
				Cookie ck=new Cookie("UserId", email);
				ck.setMaxAge(days*24*60*60);
				response.addCookie(ck);
				response.sendRedirect("signinsuccess");
				
			}
			else {
				out.print("Invalid Username & PassWord..");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
