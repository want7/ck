package Dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import entity.trade;

@WebServlet("/index")
public class index extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			  request.setCharacterEncoding("utf-8");
	           response.setContentType("text/html;charset=utf-8");
	           PrintWriter out= response.getWriter();
	           userDao userdao=new userDao();
	           Users user = new Users();
	           trade trade = new trade();
	           String  username=null;

	           String id =request.getParameter("id");
	           Cookie[] cookies = request.getCookies();	   		
	   		   if(cookies != null) {
	   			  for(Cookie cookie:cookies) {
	   			    	if(cookie.getName().equals("users")) {
	   					username = cookie.getValue();
	   					break; 
	   				}
	   			}
	           user.setUsername(username);
	           trade.setId(id);   
	           userdao.add(user, trade);
	           out.println("¶©µ¥³É¹¦");
	           response.setHeader("refresh", "2,url=index.jsp");
	   
	  }

       }
}
