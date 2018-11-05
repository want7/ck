package P;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDao;
import entity.user;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
    Connection con =null;
    PreparedStatement pStatement=null;
	 ResultSet rst=null;
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("username");
		String password= request.getParameter("password");

		userDao userDao = new userDao();
		user user =userDao.login(name);
		if(user ==null) {
			out.printf("用户不存在");
			System.out.print("用户不存在");
			 response.setHeader("refresh", "1,url =login.html");
		}
		else {
			 String name1=user.getUsername();
       	     String password1=user.getPassword() ;
       	     if(name.equals(name1) && password.equals(password1)) {
       		  Cookie cookie=new Cookie("user", name);
       		  cookie.setMaxAge(60*60);
       		  response.addCookie(cookie);
       		  request.getRequestDispatcher("index.jsp").forward(request,  response);
		}
       	  else {
    		  out.println("密码错误，请重新输入");
    		  System.out.print("输入密码错误");
    		  response.setHeader("refresh", "5,url=login.html");
    	  }
	}

  }
}
