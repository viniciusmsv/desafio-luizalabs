package com.luizalabs.dao;

import com.luizalabs.entity.Client;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;

public class ClientDAO extends BaseDAO<Client, String> {

    public ClientDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
//        super(mongoClient, morphia, dbName);
    }
}
