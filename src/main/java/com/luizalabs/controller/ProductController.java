package com.luizalabs.controller;

import com.luizalabs.entity.Client;
import com.luizalabs.entity.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;

/**
 * Hello world!
 */
@Path("/product")
public class ProductController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client getTestService() {
        Product product = new Product();
        product.setId(1l);
        product.setBrand("Sony");
        product.setTitle("PS4");
        Client client = new Client();
        client.setNome("Vinicius");
        client.setFavoriteProducts(new HashSet<Product>());
        client.getFavoriteProducts().add(product);
        return client;
    }
}
