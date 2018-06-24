package Dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.swing.SpinnerListModel;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.apache.catalina.valves.JDBCAccessLogValve;

import entity.Users;
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
				user.setConfirmpassword(rst.getString("confirmpassword"));
				return user;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
          
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
				// TODO: handle exception
    			e.printStackTrace();
			}finally {
				dbdao.closeResource(conn, stmt, st);
			}
    		return false;
			
        }
	  
	  
	  
	  public void add(Users user,trade trade) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			int count1=(int)(Math.random())*100;
			int count2=(int)(Math.random())*10;
			String sql = "insert into order(tradeId,username,id,price) value(?,?,?,?)";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setDouble(1, count1*count2);
				 stmt.setString(2,user.getUsername());
				 stmt.setString(3, trade.getId());
				 stmt.setInt(4, trade.getPrice());
				 stmt.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
	  }
	  public void addGoods(trade trade) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			String sql = "insert into tradetable(id,tradename,price,stock) value(?,?,?,?)";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setString(1, trade.getId());
				 stmt.setString(2,trade.getTradename());
				 stmt.setInt(3, trade.getPrice());
				 stmt.setString(4, trade.getStock());
				 stmt.executeUpdate();	
			} catch (SQLException e) {
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
		 			//封装成trade对象		 			
				 }
				 return trade;
			} catch (SQLException e) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
		
	}

		
	
}

