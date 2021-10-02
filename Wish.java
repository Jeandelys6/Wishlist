/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;


public class Wish {
   private int userid; 
   private int bookid; 
   private int cartid; 
   public Wish(){
   }
   public Wish(int wishid, int bookid){   
      this.cartid = cartid; 
      this.bookid = bookid; 
   }

    public Wish(int wishid,int bookid,int userid){   
      this.userid = userid; 
      this.bookid = bookid; 
   }
   public int getWishId() { 
      return cartid; 
   }  
  
   public void setWishId(int cartid) { 
      this.cartid = cartid; 
   }
   public int getUserId() { 
      return userid; 
   }  
  
   public void setUserId(int userid) { 
      this.userid = userid; 
   } 
    public int getBookId() { 
      return bookid; 
   }  
  
   public void setBookId(int bookid) { 
      this.bookid = bookid; 
   } 
                
}
