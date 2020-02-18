package com.xiangxue.jack.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
* 可以接受http请求
* */
@Path("/jersey/")
public class JerseyController {

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@PathParam("id") Long id) {
        return "hello";
    }
}
