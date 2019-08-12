package com.luizalabs.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

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

}
