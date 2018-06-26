package Dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
			 System.out.println("register����");
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
			 System.out.println("login����");
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
    			 System.out.println("check����");
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
				System.out.println("addʧ��");
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
				 System.out.println("addGoods����");
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
		 			//��װ��trade����		 			
				 }
				 return trade;
			} catch (SQLException e) {
				 System.out.println("selectGoods����");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
			return null;
	  }
	  
	  
	  
	  
	  public List<trade> selectGoods() {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			 List<trade> list2 = new ArrayList<trade>();
			String sql = "select * from order";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 st = stmt.executeQuery();
				 trade trade = new trade();
				 while(st.next()) {
					 trade.setTradename(st.getString("tradeName"));
					 trade.setId(st.getString("id"));
					 trade.setPrice(st.getInt("price"));
					 trade.setStock(st.getString("stock"));
					 list2.add(trade);
		 			//��װ��trade����		 			
				 }
				 return list2;
			} catch (SQLException e) {
				 System.out.println("selectGoods����");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
			return null;
	  }
	  
	 
	  public List<Users> selectUsers() {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
	        List<Users> list1 = new ArrayList<Users>();
			String sql = "select * from userinfo";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 st = stmt.executeQuery();
				Users users=new Users();
				 while(st.next()) {
					 users.setUsername(st.getString("username"));
					 System.out.println(st.getString("username"));
					 users.setEmailaddress(st.getString("emailaddress"));
					 System.out.println(st.getString("emailaddress"));

					 list1.add(users);
		 			//��װ��trade����		 			
				 }
				 return list1;
			} catch (SQLException e) {
				 System.out.println("selectGoods����");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
			return null;
	  }
	  
	  
	  
	  public void delOrder(String id,String username) {
		  Connection conn = null;
			PreparedStatement stmt = null;
           ResultSet st=null;
			 System.out.println(id+"1");
			String sql = "delete from order where id=? and username=?";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setString(1,id);
				 System.out.println(id);
				 stmt.setString(2, username);
				 System.out.println(username);
				 stmt.executeUpdate();	
				 System.out.println(username+"1"); 
			} catch (SQLException e) {
				 System.out.println("delOrder����");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbdao.closeResource(conn,  stmt, st);
			}
		  
	  }  
	  	  
	  
	  
	  
	  
	  
	  	  
	  
	  	  
	  public void delGoods(String id) {
		  Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet st = null;
			String sql = "delete from tradetable where id=?";
			try {
				 conn = dbdao.getConnection();
				 stmt = conn.prepareStatement(sql);
				 stmt.setString(1,id);
				 stmt.executeUpdate();	
			} catch (SQLException e) {
				 System.out.println("delGoods����");
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
				 System.out.println("updateGoods����");
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
			System.out.println("returnOrder�ɹ�");
			return stmt.executeQuery();
			
		 } catch (SQLException e) {
			 System.out.println("returnOrder����");
			e.printStackTrace();
		 }
		  
		  return null;
	  }
	  
	 //--------------------------------
	  public ResultSet returnOrderForSee(String orderId) {
		  Connection conn = null;
		  PreparedStatement stmt;
		  
		  try {
			conn = dbdao.getConnection();
			stmt = conn.prepareStatement("select * from username.order where orderId = ?");
			stmt.setString(1, orderId);
			System.out.println("returnOrder�ɹ�");
			return stmt.executeQuery();
			
		 } catch (SQLException e) {
			 System.out.println("returnOrder����");
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
			System.out.println("returnTrade�ɹ�");
			return stmt.executeQuery();
			
		 } catch (SQLException e) {
			 System.out.println("returnTrade����");
			e.printStackTrace();
		 }
		  
		  return null;
	  }
		
	
}

