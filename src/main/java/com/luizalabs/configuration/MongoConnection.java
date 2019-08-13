package com.luizalabs.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Morphia;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class MongoConnection {

    @Produces
    @ApplicationScoped
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI("mongodb://root:root@localhost");
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient;
    }

    @Produces
    @ApplicationScoped
    public Morphia morphia() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.luizalabs");
        return morphia;
    }

}
