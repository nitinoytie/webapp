package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/head")
public class HeaderInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			Enumeration enumeration=request.getHeaderNames();
			
			while (enumeration.hasMoreElements()) {
				String getheader = (String) enumeration.nextElement();
				String headervalue=request.getHeader(getheader);
				out.print("<span>"+getheader+":</span>");
				out.print("<span>"+headervalue+"</span><br>");
			}
			RequestDispatcher rd=request.getRequestDispatcher("newservlet");
			rd.include(request, response);
			
			
	}
}
