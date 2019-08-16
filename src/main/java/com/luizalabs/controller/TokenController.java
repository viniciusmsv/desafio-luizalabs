package com.luizalabs.controller;

import com.luizalabs.security.Credentials;
import com.luizalabs.service.TokenService;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/token")
@Api(value="/token" )
public class TokenController {

    @Inject
    TokenService tokenService;

    @ApiOperation(value = "Autentica o usuário e gera um token de acesso a API.",
            response = String.class,
            notes = "Utilizar usuário: admin e senha: admin")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Usuário ou senha incorretos.")
    })
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@ApiParam("credentials") Credentials credentials) {
        return Response.ok().entity(tokenService.login(credentials)).build();
    }
}
