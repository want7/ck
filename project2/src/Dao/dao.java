package Dao;

import entity.Users;
import entity.trade;

public interface dao {
       public Users login(String username); 
       public void add(Users user,trade trade);
       public boolean check(String username);
       public void addGoods(trade trade);
       public trade selectGoods(String username);
       public void delGoods(String id);
       public void updateGoods(trade trade);
     
}
