package P;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import DAO.userDao;
import entity.user;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		 String username=request.getParameter("username");
	     String password=request.getParameter("password");
	     String Rpassword=request.getParameter("Rpassword");
	     String email=request.getParameter("email");
	     String phone=request.getParameter("phone");
	     String qq=request.getParameter("qq");
	     String info=request.getParameter("info");
	     String id = request.getParameter("id");
	     
	     userDao userdao = new userDao();
	     boolean flag = userdao.check(username);
	     user user =new user();
	     user.setUsername(username);
	     user.setEmail(email);
	     user.setPassword(password);
	     user.setPhone(phone);
	     user.setQq(qq);
	     user.setInfo(info);
	     user.setId(id);

	     
	     if(flag) {
			  out.println("���û����ڣ�������ע�ᣡ");
			  request.getRequestDispatcher("register.html").forward(request,response);	
	     }
	     else {
	    	 if(password.equals(Rpassword)) {
	    		userDao userDao=new userDao();
	 	  		userDao.register(user);
	            out.println("ע��ɹ�!");
	            request.getRequestDispatcher("login.html").forward(request,response);
	    	 }
	    	 else {
	    		 out.printf("�������벻һ�£����������롣");
	    		  request.getRequestDispatcher("register.html").forward(request,response);
	    	 }
	     }

	}

}
