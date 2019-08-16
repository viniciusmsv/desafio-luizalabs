package com.luizalabs.dao;

import com.luizalabs.entity.Client;
import dev.morphia.Datastore;
import dev.morphia.Key;
import dev.morphia.query.Query;
import org.bson.types.ObjectId;

import javax.inject.Inject;

public class ClientDAOImpl implements ClientDAO {

    @Inject
    Datastore datastore;

    @Override
    public Boolean emailExists(String email) {
        Query<Client> query = datastore.createQuery(Client.class);
        query.field("email").equal(email);
        return query.count() > 0;
    }

    @Override
    public Key<Client> save(Client client) {
        return datastore.save(client);
    }

    @Override
    public void delete(Client client) {
        datastore.delete(client);
    }

    @Override
    public Client find(String id) {
        return datastore.find(Client.class).field("_id").equal(new ObjectId(id)).first();
    }
}
