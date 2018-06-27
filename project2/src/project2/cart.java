package project2;

import java.util.List;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.userDao;
import entity.trade;

@WebServlet("/cart.do")
public class cart extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		   request.setCharacterEncoding("utf-8");
           response.setContentType("text/html;charset=utf-8");
           List<trade> list = new ArrayList<trade>();
           String username=null;
           userDao userdao=new userDao();
           
           Cookie[] cookies = request.getCookies();	
   		   if(cookies != null) {
   			  for(Cookie cookie:cookies) {
   			    	if(cookie.getName().equals("users")) {
   					username = cookie.getValue();	   					
   					break; 
   				}
   			}
   			ResultSet result = null;
   			result = userdao.returnOrder(username);
   			String [] ids= new String[10];

   			if(result==null) {
					System.out.println("id 为空");
				}
   			else {
					System.out.println("id 不为空");
				}
   			try {
   				int j=0;
   				System.out.println( j);
				while(result.next()){				
					ids[j]=result.getString("id");				
					j++;
				}
				
			} catch (SQLException e) {
				System.out.println("错了");
				e.printStackTrace();
			}
   			System.out.println("开始list操作");
   			for(String id:ids) {
   				ResultSet result1 = userdao.returnTrade(id);
   				System.out.println(id);
   				try {
					while(result1.next()) {
						trade trade = new trade();
						trade.setTradename(result1.getString("tradename"));
						trade.setPrice(result1.getInt("price"));
						trade.setId(result1.getString("id"));
						trade.setStock(result1.getString("stock"));
						trade.setPhotoName("images/"+result1.getString("photoName"));
						list.add(trade);
						System.out.println("trade.getId():"+trade.getId());
						System.out.println("List添加");
					}
				} catch (SQLException e) {
					System.out.println("List添加失败");
					e.printStackTrace();
				}
   			}
   			request.setAttribute("list", list);
   			request.getRequestDispatcher("checkout.jsp").forward(request, response);
   			
   
   			
	}
   		   
   		   
   		  
}
}
