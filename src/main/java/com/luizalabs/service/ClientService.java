package com.luizalabs.service;

import com.luizalabs.dao.ClientDAO;
import com.luizalabs.entity.Client;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
public class ClientService implements Serializable {

    public static final String DB_NAME = "myMongoDb";

    @Inject
    ClientDAO clientDAO;

    public Client save(Client client) {

        clientDAO.save(client);

        return client;
    }
}
