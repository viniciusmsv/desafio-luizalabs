package com.luizalabs.controller;

import com.luizalabs.entity.Client;
import com.luizalabs.exception.BusinessException;
import com.luizalabs.service.ClientService;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    @Produces(MediaType.TEXT_PLAIN)
    public Client save(@ApiParam(value = "Objeto Client a ser salvo.") Client client) throws BusinessException {
        return clientService.save(client);
    }

    @ApiOperation(value = "Busca um cliente pelo id",
            response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Cliente não encontrado.")
    })
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client find(@ApiParam(value = "ID do cliente para ser localizado.") @PathParam("id") String id) {
        return clientService.find(id);
    }

    @ApiOperation(value = "Atualiza dados de um cliente",
            notes = "O email é o único campo que nao pode ser alterado",
            response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Cliente não encontrado."),
            @ApiResponse(code = 400, message = "Um dos produtos não pode ser encontrado.")
    })
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Client update(@ApiParam(value = "Objeto Client com os dados a serem atualizados.") Client client) throws BusinessException {
        return clientService.update(client);
    }

    @ApiOperation(value = "Apaga um cliente pelo id",
            response = String.class)
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@ApiParam(value = "ID do cliente a ser apagado.") @PathParam("id") String id) {
        return clientService.delete(id);
    }
}
