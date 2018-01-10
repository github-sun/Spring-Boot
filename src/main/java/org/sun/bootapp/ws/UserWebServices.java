package org.sun.bootapp.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sun.bootapp.entity.User;

@Path("/user")
public interface UserWebServices {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers();
}
