package demoexamples;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/welcome")
public class ExSendRedirect extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		
		if (name.equals("admin")) {
			response.sendRedirect("index.html");
		}
		else {
			response.sendRedirect("DemoSendRedirect.html");
		}
		
	}


}
