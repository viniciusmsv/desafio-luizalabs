package com.luizalabs.controller;

import com.luizalabs.entity.Product;
import com.luizalabs.service.ProductService;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
@Api(value="/product" )
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product productDetail(@PathParam("id") String id) {
        return productService.productDetail(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listProducts(@QueryParam("page") Integer page) {
        return productService.listProducts(page);
    }
}
