package com.luizalabs.configuration;

import com.luizalabs.controller.ClientController;
import com.luizalabs.controller.ProductController;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class SwaggerConfiguration extends Application {

    public SwaggerConfiguration(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/desafio-luizalabs/api/");
        beanConfig.setResourcePackage("com.luizalabs");
        beanConfig.setTitle("Desafio LuizaLabs API");
        beanConfig.setDescription("Documentação da API");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        resources.add(ClientController.class);
        resources.add(ProductController.class);

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}
