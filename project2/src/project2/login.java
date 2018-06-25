package project2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.StringManager;
import org.apache.el.util.ConcurrentCache;
import org.apache.jasper.tagplugins.jstl.core.Out;

import Dao.userDao;
import entity.Users;

@WebServlet("/login")
public class login extends HttpServlet {
     Connection con =null;
     PreparedStatement pStatement=null;
	 ResultSet rst=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   request.setCharacterEncoding("utf-8");
           response.setContentType("text/html;charset=utf-8");
           PrintWriter out= response.getWriter();
           String name=request.getParameter("Name");
           String password=request.getParameter("Password");
           userDao userDao=new Dao.userDao();
           Users users=userDao.login(name);
           if(users==null)
          {
        	  out.println("没有这个用户！请重新输入！");
        	  response.setHeader("refresh", "1,url =account.html");
        
        	  
          }
          else {
        	  String name1=users.getUsername();
        	  String password1=users.getPassword() ;
        	  if(name.equals(name1) && password.equals(password1)) {
        		  Cookie cookie=new Cookie("users", name);
        		  cookie.setMaxAge(60*60);
        		  response.addCookie(cookie);
        		  request.getRequestDispatcher("index.jsp").forward(request,  response);
        	  }      	  
        	  else {
        		  out.println("密码错误，请重新输入");
        		  response.setHeader("refresh", "1,url=account.html");
        	  }
          }
	}

}
