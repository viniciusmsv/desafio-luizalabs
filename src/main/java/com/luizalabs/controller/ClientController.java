package com.luizalabs.controller;

import com.luizalabs.entity.Client;
import com.luizalabs.service.ClientService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/client")
public class ClientController {

    @Inject
    private ClientService clientService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Client save(Client client) {
        return clientService.save(client);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client find(@PathParam("id") Long id) {
        Client client = new Client();
        return client;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Client update(Client client) {
        return client;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client delete(@PathParam("id") Long id) {
        Client client = new Client();
        return client;
    }
}
