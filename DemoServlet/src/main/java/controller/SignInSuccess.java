package controller;

import java.io.IOException;
import java.io.PrintWriter;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signinsuccess")
public class SignInSuccess extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Cookie[] ck=request.getCookies();
		
		for (int i = 0; i < ck.length; i++) {
			if(ck[i].getName().equals("UserId")) {
				out.print("Welcome "+ck[i].getValue());
			}
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
		
	}

}
