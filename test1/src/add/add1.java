package add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add1.view")
public class add1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String name =request.getParameter("name");	    
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Hello Servlet</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1> Hello "+name+"<!h1>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	}

}
