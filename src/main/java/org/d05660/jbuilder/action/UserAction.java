package org.d05660.jbuilder.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.d05660.jbuilder.entity.User;
import org.d05660.jbuilder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("user")
@Component
public class UserAction {
    @Autowired
    private UserService userService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public User getGreeting(@PathParam("id") Integer id) throws Exception {
        return userService.getUserById(id);
    }
}
