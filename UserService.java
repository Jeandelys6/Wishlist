/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.io.IOException;
import java.util.List; 
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;  
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Path("/users") 

public class UserService {  
   UserDao user= null;  
   private static final String SUCCESS_RESULT = "'{result:success}'"; 
   private static final String FAILURE_RESULT = "'{result:failed}'";
       @Path("{username}")
	@GET
	@Produces("application/json")
	public Response getGenre(@PathParam("num") String username) throws JSONException {
                user= new UserDao();
                JSONObject myresult=user.getUser(username);
		return Response.status(200).entity(myresult).build();
	}
        @Path("/sold/{num}")
	@POST
	@Produces("application/json")
	public String createUser(@FormParam("username") String username,@FormParam("password") String password,@Context HttpServletResponse servletResponse) throws IOException{ 
                User newuser = new User(username, password); 
                int result = user.addUser(newuser); 
                if(result == 1){ 
                   return SUCCESS_RESULT; 
                } 
                return FAILURE_RESULT; 
                
        
        }
}