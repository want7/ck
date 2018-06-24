package project2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import Dao.userDao;
import entity.Users;

@WebServlet("/register")
public class register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
        String username=request.getParameter("Name");
        String a=request.getParameter("Password");
		String emailaddress=request.getParameter("EmailAddress");

		String b=request.getParameter("ConfirmPassword");
		
		   userDao usersdao = new userDao();
		    boolean flag = usersdao.check(username);
		    Users user=new Users();
	        user.setUsername(username);
	        user.setPassword(a);
	        user.setEmailaddress(emailaddress);
	        user.setConfirmpassword(b);

	   if(flag) {
		  out.println("���û����ڣ�������ע�ᣡ");
		  request.getRequestDispatcher("register.html").forward(request,response);	
	  }
	   else {
		   if(a.equals(b))
	   
		{
			userDao userDao=new userDao();
	  		userDao.register(user);
           out.println("ע��ɹ�!");
           request.getRequestDispatcher("account.html").forward(request,response);

		}else {	
	          out.println("��ȷ�����룡����ע�ᣡ");
		  	  request.getRequestDispatcher("register.html").forward(request,response);
		}	}		  		
	}

}
