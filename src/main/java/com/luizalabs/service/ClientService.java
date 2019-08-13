package com.luizalabs.service;

import com.luizalabs.dao.ClientDAO;
import com.luizalabs.entity.Client;
import com.luizalabs.exception.NegocioException;
import org.bson.types.ObjectId;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
public class ClientService implements Serializable {

    @Inject
    ClientDAO clientDAO;

    public String save(Client client) throws NegocioException {
        if(clientDAO.isEmailExists(client.getEmail())){
            throw new NegocioException("Email já cadastrado!");
        }
        client.setId(null);
        return ((ObjectId)clientDAO.save(client).getId()).toHexString();
    }

    public void delete(String id) {
        clientDAO.deleteById(new ObjectId(id));
    }

    public Client find(String id) {
        return clientDAO.findOne("_id", new ObjectId(id));
    }

    public String update(Client client) {
        Client clientDB = clientDAO.findOne("_id", new ObjectId(client.getId()));
        client.setEmail(clientDB.getEmail());
        return ((ObjectId)clientDAO.save(client).getId()).toHexString();
    }
}
