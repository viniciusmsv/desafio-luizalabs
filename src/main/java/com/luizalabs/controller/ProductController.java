package com.luizalabs.controller;

import com.luizalabs.entity.Product;
import com.luizalabs.service.ProductService;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
@Api(value="/product" )
public class ProductController {

    @Inject
    ProductService productService;

    @ApiOperation(value = "Detalhe os dados de um produto",
            response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Produto não pode ser encontrado.")
    })
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productDetail(@ApiParam(value = "ID do produto para ser detalhado.")@PathParam("id") String id) {
        return Response.ok().entity(productService.productDetail(id)).build();
    }

    @ApiOperation(value = "Lista os produtos paginados",
            response = Product.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Nenhum produto encontrado.")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProducts(@ApiParam(value = "Número da página.") @QueryParam("page") Integer page) {
        return Response.ok().entity(productService.listProducts(page)).build();
    }
}
