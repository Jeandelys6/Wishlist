/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONException;
import org.json.JSONObject;


public class WishDao {
     public JSONObject getWish(int userid)throws JSONException { 
     
     //String subquery=UserDao.getOption(option, total);
       ResultSet resultSet = null;
       
        JSONObject wishs = new JSONObject();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","newuser","password");
            Statement st=con.createStatement();
            resultSet = st.executeQuery("Select FROM wish books.name INNER JOIN wish on wish.userid=users.id INNER JOIN books ON books.id=wish.bookid where user.id='"+userid+"'");
            int i=1;
            while(resultSet.next()){
                 wishs.put("id",resultSet.getString("id"));
                 wishs.put("name", resultSet.getString("name"));
               
            }
            return wishs;
           
      

        }catch (Exception e2) {
            System.out.println("error"+e2);
        }
        return null;
   } 
    public int addWish(Wish wish){ 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","newuser","password");
            Statement st=con.createStatement();
             st.executeUpdate("insert into wish (bookid,userid)values('"+wish.getBookId()+"','"+wish.getUserId()+"')");
                  return 1;
            }catch (Exception e2) {
                System.out.println("error"+e2);
                return 0;
            
        }
      
     
     
   }
      public int updateWish(Wish wish){ 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","newuser","password");
            Statement st=con.createStatement();
             st.executeUpdate("Update wish set bookid="+wish.getBookId()+"' WHERE id='"+wish.getWishId()+"'");
                  return 1;
            }catch (Exception e2) {
                System.out.println("error"+e2);
                return 0;
            
        }
    
   }
      public int deleteWish(int id){ 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","newuser","password");
            Statement st=con.createStatement();
             st.executeUpdate("DELETE FROM wish WHERE id='"+id+"'");
                  return 1;
            }catch (Exception e2) {
                System.out.println("error"+e2);
                return 0;
            
        }
     }
     public int getId(String tabl,String name){
      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","newuser","password");
            Statement st=con.createStatement();
          ResultSet resultSet = st.executeQuery("Select id FROM '"+tabl+"'  where name='"+name+"'");
            int resultid=0;
            while(resultSet.next()){
                 resultid=Integer.parseInt(resultSet.getString("id"));
                 
               
            }
            return resultid;
           
     
        }catch (Exception e2) {
            System.out.println("error"+e2);
        
     }
         return 0;
     }
}
