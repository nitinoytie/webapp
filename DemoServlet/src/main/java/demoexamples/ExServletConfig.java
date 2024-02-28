package demoexamples;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ExServletConfig extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletConfig conf=getServletConfig();
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String url=conf.getInitParameter("url");
		
		out.print("Servlet Config.<a href='"+url+"'>Visit Google</a>");
	}
}
