package com.luizalabs.controller;

import com.luizalabs.entity.Client;
import com.luizalabs.exception.BusinessException;
import com.luizalabs.service.ClientService;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client")
@Api(value="/client" )
public class ClientController {

    @Inject
    private ClientService clientService;

    @ApiOperation(value = "Salva um novo cliente",
            response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Email já cadastrado!"),
            @ApiResponse(code = 400, message = "Um dos produtos não pode ser encontrado.")
    })
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@ApiParam(value = "Objeto Client a ser salvo.") Client client) throws BusinessException {
        return Response.ok().entity(clientService.save(client)).build();
    }

    @ApiOperation(value = "Busca um cliente pelo id",
            response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Cliente não encontrado.")
    })
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@ApiParam(value = "ID do cliente para ser localizado.") @PathParam("id") String id) {
        return Response.ok().entity(clientService.find(id)).build();
    }

    @ApiOperation(value = "Atualiza dados de um cliente",
            response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Cliente não encontrado."),
            @ApiResponse(code = 400, message = "Um dos produtos não pode ser encontrado.")
    })
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@ApiParam(value = "Objeto Client com os dados a serem atualizados.") Client client) throws BusinessException {
        return Response.ok().entity(clientService.update(client)).build();
    }

    @ApiOperation(value = "Apaga um cliente pelo id",
            response = String.class)
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@ApiParam(value = "ID do cliente a ser apagado.") @PathParam("id") String id) {
        return Response.ok().entity(clientService.delete(id)).build();
    }
}
