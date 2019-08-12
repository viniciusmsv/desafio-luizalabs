package com.luizalabs.controller;

import com.luizalabs.dto.ClientDTO;
import com.luizalabs.service.ClientService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/client")
@RequestScoped
public class ClientController {

    @Inject
    private ClientService clientService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ClientDTO save(ClientDTO client) {
        return clientService.save(client);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClientDTO find(@PathParam("id") Long id) {
        ClientDTO client = new ClientDTO();
        return client;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public ClientDTO update(ClientDTO client) {
        return client;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClientDTO delete(@PathParam("id") Long id) {
        ClientDTO client = new ClientDTO();
        return client;
    }
}
