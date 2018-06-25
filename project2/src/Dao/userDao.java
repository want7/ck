package Dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.SpinnerListModel;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.apache.catalina.valves.JDBCAccessLogValve;

import entity.Users;
import entity.orderC;
import entity.trade;
import project2.dbdao;
import project2.register;

public class userDao implements dao{
    dbdao dbdao = new dbdao();
	public  void register(Users user) {
		String sql="insert into userinfo(username,emailaddress,password) value(?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		try {
			conn=dbdao.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmailaddress());
			pstmt.setString(3, user.getPassword());
		    pstmt.executeUpdate();	
		} catch (SQLException e) {
			 System.out.println("register´íÎó");
			// TODO: handle exception
			e.printStackTrace();

		}finally {
			dbdao.closeResource(conn, pstmt, null);

	        }
		}

	@Override
	public Users login(String username) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rst=null;
        Users user = new Users();
        String sql = "select * from userinfo where username=?";
        		   
        try {
			conn=dbdao.getConnection();
			statement=conn.prepareStatement(sql);
			statement.setString(1,username);
			rst=statement.executeQuery();
			while(rst.next())                          
			{
				user.setUsername(rst.getString("username"));		
				user.setEmailaddress(rst.getString("emailaddress"));
				user.setPassword(rst.getString("password"));			
			}	
			return user;
		} catch (SQLException e) {
			 System.out.println("login´íÎó");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
          
	}
	

       public boolean check(String username){
        	Connection conn = null;
    		PreparedStatement stmt = null;
    		ResultSet st = null;
    		String sql2 = "select * from userinfo where username=?";
    		try {
    		conn=dbdao.getConnection();
    	    stmt = conn.prepareStatement(sql2);
 			stmt.setString(1, username);
 		    st = stmt.executeQuery();
 			if(st.next()) {
 				return true;
 			}
    		}catch (Exception e) {
    			 System.out.println("check´íÎó");
				// TODO: handle exception
    			e.printStackTrace();
			}finally {
				dbdao.closeResource(conn, stmt, st);
			}
    		return false;
			
        }
	  
	  
	  
	  public void add(String user,String id) {
			Connection conn = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
			ResultSet st = null;
			String sql3 = "insert into username.order(username,id) values(?,?)";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql3);
				 stmt.setString(1,user);
				 stmt.setString(2, id);
				 stmt.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("addÊ§°Ü");
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
	  }
	  public void addGoods(trade trade) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			String sql = "insert into tradetable(id,tradename,stock) value(?,?,?)";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setString(1, trade.getId());
				 stmt.setString(2,trade.getTradename());
				 stmt.setString(3, trade.getStock());
				 stmt.executeUpdate();	
			} catch (SQLException e) {
				 System.out.println("addGoods´íÎó");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
		
	}
	  
	  public trade selectGoods(String username) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			
			String sql = "select * from order where username=?";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setString(1, username);
				 st = stmt.executeQuery();
				 trade trade = new trade();
				 while(st.next()) {
					 String id=st.getString("id");
					 int price=st.getInt("price");
					 trade.setId(id);
					 trade.setPrice(price);
		 			//·â×°³Étrade¶ÔÏó		 			
				 }
				 return trade;
			} catch (SQLException e) {
				 System.out.println("selectGoods´íÎó");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
			return null;
	  }
	  public void delGoods(String id) {
		  Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			String sql = "deltete from tradetable where id=?";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setString(1,id);
				 stmt.executeUpdate();	
			} catch (SQLException e) {
				 System.out.println("delGoods´íÎó");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
		  
	  }
	  public void updateGoods(trade trade) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			String sql = "update tradetable set tradename=? ,price=? ,stock=? where id=?";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setString(1, trade.getId());
				 stmt.setString(2,trade.getTradename());
				 stmt.setInt(3, trade.getPrice());
				 stmt.setString(4, trade.getStock());
				 stmt.executeUpdate();	
			} catch (SQLException e) {
				 System.out.println("updateGoods´íÎó");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
		
	}
	  public ResultSet returnOrder(String name) {
		  Connection conn = null;
		  PreparedStatement stmt;
		  
		  try {
			conn = dbdao.getConnection();
			stmt = conn.prepareStatement("select * from username.order where username = ?");
			stmt.setString(1, name);
			System.out.println("returnOrder³É¹¦");
			return stmt.executeQuery();
			
		 } catch (SQLException e) {
			 System.out.println("returnOrder´íÎó");
			e.printStackTrace();
		 }
		  
		  return null;
	  }
	  public ResultSet returnTrade(String id) {
		  Connection conn = null;
		  PreparedStatement stmt;
		  
		  try {
			orderC orderc = new orderC();
			conn = dbdao.getConnection();
			stmt = conn.prepareStatement("select * from username.tradetable where id = ?");
			stmt.setString(1, id);
			System.out.println("returnTrade³É¹¦");
			return stmt.executeQuery();
			
		 } catch (SQLException e) {
			 System.out.println("returnTrade´íÎó");
			e.printStackTrace();
		 }
		  
		  return null;
	  }
		
	
}

