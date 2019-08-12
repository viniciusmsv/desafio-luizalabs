package com.luizalabs.controller;

import com.luizalabs.dto.ClientDTO;
import com.luizalabs.dto.ProductDTO;

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
    public ClientDTO getTestService() {
        ProductDTO product = new ProductDTO();
        product.setId(1l);
        product.setBrand("Sony");
        product.setTitle("PS4");
        ClientDTO client = new ClientDTO();
        client.setNome("Vinicius");
        client.setFavoriteProducts(new HashSet<ProductDTO>());
        client.getFavoriteProducts().add(product);
        return client;
    }
}
