package P;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changeInfo
 */
@WebServlet("/changeInfo")
public class changeInfo extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
		 String username=request.getParameter("username");
	     String password=request.getParameter("password");
	     String Rpassword=request.getParameter("Rpassword");
	     String email=request.getParameter("email");
	     String phone=request.getParameter("phone");
	     String qq=request.getParameter("qq");
	     String info=request.getParameter("info");
	     String id = request.getParameter("id");
	}

}
