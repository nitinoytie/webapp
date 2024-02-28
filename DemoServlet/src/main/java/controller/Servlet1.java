package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Dao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modal.Users;


/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/demo1")
public class Servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter out=response.getWriter();
		try {
			
			ArrayList<Users> list=new ArrayList<>();
			list.addAll(Dao.getAllUsers());
			out.print("<html><head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>"
					+ "</head><body><table class=\"table\">\r\n"
					+ "  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "      <th scope=\"col\">Id</th>\r\n"
					+ "      <th scope=\"col\">First Name</th>\r\n"
					+ "      <th scope=\"col\">Last Name</th>\r\n"
					+ "      <th scope=\"col\">Age</th>\r\n"
					+ "      <th scope=\"col\">Email</th>\r\n"
					+ "      <th scope=\"col\">Password</th>\r\n"
					+ "      <th scope=\"col\">Edit User</th>\r\n"
					+ "      <th scope=\"col\">Delete User</th>\r\n"
					+ "    </tr>\r\n"
					+ "  </thead>\r\n"
					+"<tbody>\r\n");
			for (Users us : list) {
				out.print("    <tr>\r\n"
						+ "      <td>"+us.getId()+"</td>\r\n"
						+ "      <td>"+us.getFname()+"</td>\r\n"
						+ "      <td>"+us.getLname()+"</td>\r\n"
						+ "      <td>"+us.getAge()+"</td>\r\n"
						+ "      <td>"+us.getEmail_id()+"</td>\r\n"
						+ "      <td>"+us.getPass()+"</td>\r\n"
						+ "      <td><a href='edituser?id="+us.getId()+"'>Edit</a></td>\r\n"
						+ "      <td><a href='deleteuser?id="+us.getId()+"'>Delete</a></td>\r\n"
						+ "    </tr>\r\n");
						
			}
			out.print("</tbody>\r\n"
					+ "</table></body></html>");
				
//			response.setContentType("text/html");
			
//			out.print("<html><body>");
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(e.getMessage());
		}
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
		
		
	}

}
