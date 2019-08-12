package com.luizalabs.service;

import com.luizalabs.entity.Client;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
public class ClientService implements Serializable {

    protected MongoDatabase db;
    protected MongoCollection<Document> collection;

    public static final String DB_NAME = "myMongoDb";
    public static final String COLL_NAME = "customers";

    @Inject
    MongoClient mongoClient;

    @PostConstruct
    public void init() {
        this.db = this.mongoClient.getDatabase(DB_NAME);
        this.collection = this.db.getCollection(COLL_NAME);
    }


    public Client save(Client client) {

        Document document = new Document();
        document.put("name", "Shubham");
        document.put("company", "Baeldung");
        collection.insertOne(document);

        return client;
    }
}
