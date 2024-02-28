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


@WebServlet("/edituser")
public class EditUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(ids);
		try {
			
			Users us=Dao.getUserById(id);
			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<div class=\"container p-5\">\r\n"
					+ "<form action=\"updateuser\">\r\n"
					+ "    <input type=\"hidden\" name=\"id\" value="+us.getId()+" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\">\r\n"
					+ "   \r\n"
					+ " <div class=\"mb-3\">\r\n"
					+ "    <label for=\"exampleInputEmail1\" class=\"form-label\">First Name</label>\r\n"
					+ "    <input type=\"text\" name=\"fname\" value="+us.getFname()+" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\">\r\n"
					+ "   \r\n"
					+ "  </div>\r\n"
					+ "   <div class=\"mb-3\">\r\n"
					+ "    <label for=\"exampleInputEmail1\" class=\"form-label\">Last Name</label>\r\n"
					+ "    <input type=\"text\" name=\"lname\" value="+us.getLname()+" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\">\r\n"
					+ "  </div>\r\n"
					+ "   <div class=\"mb-3\">\r\n"
					+ "    <label for=\"exampleInputEmail1\" class=\"form-label\">Age</label>\r\n"
					+ "    <input type=\"number\" name=\"age\" value="+us.getAge()+" min=\"1\" max=\"100\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\">\r\n"
					+ "   \r\n"
					+ "  </div>\r\n"
					+ "  <div class=\"mb-3\">\r\n"
					+ "    <label for=\"exampleInputEmail1\" class=\"form-label\">Email address</label>\r\n"
					+ "    <input type=\"email\" name=\"email\" value="+us.getEmail_id()+" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\">\r\n"
					+ "    <div id=\"emailHelp\" class=\"form-text\">We'll never share your email with anyone else.</div>\r\n"
					+ "  </div>\r\n"
					+ "  <div class=\"mb-3\">\r\n"
					+ "    <label for=\"exampleInputPassword1\" class=\"form-label\">Password</label>\r\n"
					+ "    <input type=\"password\" name=\"pass\" value="+us.getPass()+" class=\"form-control\" id=\"exampleInputPassword1\">\r\n"
					+ "  </div>\r\n"
					+ "  <div class=\"mb-3 form-check\">\r\n"
					+ "    <input type=\"checkbox\" class=\"form-check-input\" id=\"exampleCheck1\">\r\n"
					+ "    <label class=\"form-check-label\" for=\"exampleCheck1\">Check me out</label>\r\n"
					+ "  </div>\r\n"
					+ "  <button type=\"submit\" class=\"btn btn-primary\">Update User</button>\r\n"
					+ "</form>\r\n"
					+ "</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
