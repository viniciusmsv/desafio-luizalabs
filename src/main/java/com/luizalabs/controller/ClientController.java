package com.luizalabs.controller;

import com.luizalabs.entity.Client;
import com.luizalabs.exception.NegocioException;
import com.luizalabs.service.ClientService;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/client")
@Api(value="/client" )
public class ClientController {

    @Inject
    private ClientService clientService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Client client) throws NegocioException {
        return clientService.save(client);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client find(@PathParam("id") String id) {
        return clientService.find(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Client client) throws NegocioException {
        return clientService.update(client);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") String id) {
        return clientService.delete(id);
    }
}
