/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.io.Serializable;  


public class User implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private int id; 
   private String username; 
   private String address;  
   private String name; 
   private String password; 
   public User(){} 
    
   public User(String username, String password){   
      this.username = username; 
      this.password = password; 
   }
   public User(String name,String username, String password,String address){   
      this.username = username; 
      this.password = password;
      this.name = name;
      this.address = address;
   }
   public int getId() { 
      return id; 
   }  
  
   public void setId(int id) { 
      this.id = id; 
   } 
   public String getUsername() { 
      return username; 
   } 
   
   public void setUsername(String name) { 
      this.username = username; 
   } 
   public String getName() { 
      return name; 
   } 
   
   public void setName(String name) { 
      this.name = name; 
   }  
   public String getAddress() { 
      return address; 
   } 
  
   public void setAddress(String address) { 
      this.address = address; 
   }  
  public String getPassword() { 
      return password; 
   }
   public void setPassword(String password) { 
      this.password = password; 
   }  
} 
