/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author gondi
 */
public class WishService {
    WishDao wish= null;  
   private static final String SUCCESS_RESULT = "'{result:success}'"; 
   private static final String FAILURE_RESULT = "'{result:failed}'";
       @Path("{username}")
	@GET
	@Produces("application/json")
	public Response getGenre(@PathParam("username") String user) throws JSONException {
                wish= new WishDao();
                int userid=wish.getId("users", user);
                JSONObject myresult=wish.getWish(userid);
		return Response.status(200).entity(myresult).build();
	}
        
	@POST
	@Produces("application/json")
	public String createWish(@FormParam("book") String book,@FormParam("user") String user,@Context HttpServletResponse servletResponse) throws IOException{ 
            int bookid=wish.getId("book",book);
             int userid=wish.getId("users",user);
             if(bookid==0 || userid==0){
                return FAILURE_RESULT;
             }
            Wish newwish = new Wish(bookid, userid); 
                int result = wish.addWish(newwish); 
                if(result == 1){ 
                   return SUCCESS_RESULT; 
                } 
                return FAILURE_RESULT; 
        }
        @PUT
	@Produces("application/json")
	public String updateWish(@FormParam("wishid") int wishid,@FormParam("book") String book,@Context HttpServletResponse servletResponse) throws IOException{ 
            int bookid=wish.getId("book",book);
             if(bookid==0){
                return FAILURE_RESULT;
             }
                Wish newwish=new Wish(wishid,bookid);
                int result = wish.addWish(newwish); 
                if(result == 1){ 
                   return SUCCESS_RESULT; 
                } 
                return FAILURE_RESULT; 
        }
        @DELETE
	@Produces("application/json")
	public String deleteWish(@FormParam("wishid") int wishid, @Context HttpServletResponse servletResponse) throws IOException{ 
           
                int result = wish.deleteWish(wishid); 
                if(result == 1){ 
                   return SUCCESS_RESULT; 
                } 
                return FAILURE_RESULT; 
        }
                
}
