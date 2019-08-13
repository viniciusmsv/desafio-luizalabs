package com.luizalabs.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductController {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer productDetail(@PathParam("id") Integer page) {
        return page;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer listProducts(@QueryParam("page") Integer page) {
        return page;
    }
}
