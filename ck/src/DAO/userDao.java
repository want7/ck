package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.trade;
import entity.user;
import entity.user;

public class userDao {
         Dao dao =new Dao();
         
         
         //实现注册
     	public  void register(user user) {
    		String sql="insert into t_user(id,username,password,,phone,qq,info) value(-1,?,?,?,?,?,?)";
    		Connection conn=null;
    		PreparedStatement pstmt=null;
    		ResultSet resultSet=null;
    		try {
    			conn=dao.getConnection();
    			pstmt=conn.prepareStatement(sql);
    			pstmt.setString(1, user.getUsername());
    			pstmt.setString(2, user.getPassword());
    			pstmt.setString(3, user.getEmail());
    			pstmt.setString(4, user.getPhone());
    			pstmt.setString(5, user.getQq());
    			pstmt.setString(6, user.getInfo());
    		    pstmt.executeUpdate();	
    		} catch (SQLException e) {
    			 System.out.println("register错误");
    			// TODO: handle exception
    			e.printStackTrace();

    		}finally {
    			dao.closeResource(conn, pstmt, null);
    	        }
    		}
         
       	
         //登陆调用函数
         public user login(String username) {
    		// TODO Auto-generated method stub
    		Connection conn = null;
    		PreparedStatement statement = null;
    		ResultSet rst=null;
            user user = new user();
            String sql = "select * from t_user where username=?";
            		   
            try {
    			conn=Dao.getConnection();
    			statement=conn.prepareStatement(sql);
    			statement.setString(1,username);
    			rst=statement.executeQuery();
    			while(rst.next())                          
    			{
    				user.setUsername(rst.getString("username"));		
    				user.setEmail(rst.getString("email"));
    				user.setPassword(rst.getString("password"));	
    				
    			}	
    			return user;
    		} catch (SQLException e) {
    			 System.out.println("login错误");
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return null;
              
    	}
         
         
       //检查是否用户已经存在函数
         public boolean check(String username){
         	Connection conn = null;
     		PreparedStatement stmt = null;
     		ResultSet st = null;
     		String sql2 = "select * from t_user where username=?";
     		try {
     		conn=dao.getConnection();
     	    stmt = conn.prepareStatement(sql2);
  			stmt.setString(1, username);
  		    st = stmt.executeQuery();
  			if(st.next()) {
  				return true;
  			}
     		}catch (Exception e) {
     			 System.out.println("check错误");
 				// TODO: handle exception
     			e.printStackTrace();
 			}finally {
 				dao.closeResource(conn, stmt, st);
 			}
     		return false;
 			
         }
         
         //更新用户信息
         public void updateGoods(user user) {
 			Connection conn = null;
 			PreparedStatement stmt = null;
 			ResultSet st = null;
 			String sql = "update t_user set password=? ,email=? ,qq=? ,info=? where username=?";
 			try {
 				 conn = dbdao.getConnection();
 				 stmt = conn.prepareStatement(sql);
 				 stmt.setString(1, trade.getId());
 				 stmt.setString(2,trade.getTradename());
 				 stmt.setInt(3, trade.getPrice());
 				 stmt.setString(4, trade.getStock());
 				 stmt.executeUpdate();	
 			} catch (SQLException e) {
 				 System.out.println("updateGoods错误");
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}finally {
 				dbdao.closeResource(conn,  stmt, st);
 			}
 		
 	}
 	  
}
