package org.sun.bootapp.ws;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sun.bootapp.entity.User;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserWebServices {
	
	@GET
	@Path("/{id}")
	User getUserById(@PathParam("id") int id);
	
    @GET
	List<User> getUsers();
    
    @POST
    int addUser(User user);
    
    @DELETE
    @Path("/{id}")
    int removeUser(@PathParam("id") int id);
    
    @PUT
    int updateUser(User user);
}
