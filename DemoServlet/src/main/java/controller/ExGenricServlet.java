package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/table")
public class ExGenricServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("<html><head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>"
				+ "</head><body><table class=\"table\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">#</th>\r\n"
				+ "      <th scope=\"col\">First</th>\r\n"
				+ "      <th scope=\"col\">Last</th>\r\n"
				+ "      <th scope=\"col\">Handle</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "  <tbody>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"row\">1</th>\r\n"
				+ "      <td>Mark</td>\r\n"
				+ "      <td>Otto</td>\r\n"
				+ "      <td>@mdo</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"row\">2</th>\r\n"
				+ "      <td>Jacob</td>\r\n"
				+ "      <td>Thornton</td>\r\n"
				+ "      <td>@fat</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"row\">3</th>\r\n"
				+ "      <td colspan=\"2\">Larry the Bird</td>\r\n"
				+ "      <td>@twitter</td>\r\n"
				+ "    </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "</table></body></html>");
	}

}
