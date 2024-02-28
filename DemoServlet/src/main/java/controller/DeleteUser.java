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


@WebServlet("/deleteuser")
public class DeleteUser extends HttpServlet{
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		Users us=new Users();
		us.setId(id);
		try {
			int st=Dao.deleteuser(us);
			if (st>0) {
				out.print("User id:"+id+" is deleted..");
			}
			
			
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
