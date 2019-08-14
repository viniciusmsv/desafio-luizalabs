package com.luizalabs.dao;

import com.luizalabs.entity.Client;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import javax.inject.Inject;

public class ClienteDAOImpl extends BasicDAO<Client, ObjectId> implements ClientDAO {

    public static final String DB_NAME = "luizalabs";

    @Inject
    protected ClienteDAOImpl(MongoClient mongoClient, Morphia morphia) {
        super(mongoClient, morphia, DB_NAME);
    }


    @Override
    public Boolean isEmailExists(String email) {
        Query<Client> query = this.createQuery();
        query.and(
                query.criteria("email").equal(email)
        );
        QueryResults<Client> clients = this.find(query);
        return clients.count() > 0;
    }
}
