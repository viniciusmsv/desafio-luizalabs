package com.luizalabs.controller;

import com.luizalabs.security.Credentials;
import com.luizalabs.service.TokenService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/token")
public class TokenController {

    @Inject
    TokenService tokenService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Credentials credentials) {
        return Response.ok().entity(tokenService.login(credentials)).build();
    }

}
