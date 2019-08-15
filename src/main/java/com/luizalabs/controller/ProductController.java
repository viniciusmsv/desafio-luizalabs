package com.luizalabs.controller;

import com.luizalabs.entity.Product;
import com.luizalabs.service.ProductService;
import io.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
@Api(value="/product" )
public class ProductController {

    @Inject
    ProductService productService;

    @ApiOperation(value = "Detalhe os dados de um produto",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Produto não pode ser encontrado.")
    })
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product productDetail(@ApiParam(value = "ID do produto para ser detalhado.")@PathParam("id") String id) {
        return productService.productDetail(id);
    }

    @ApiOperation(value = "Lista os produtos paginados",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Nenhum produto encontrado.")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listProducts(@ApiParam(value = "Número da página.") @QueryParam("page") Integer page) {
        return productService.listProducts(page);
    }
}
