package com.luizalabs.service;

import com.luizalabs.dao.ClientDAO;
import com.luizalabs.dao.ProductDAO;
import com.luizalabs.entity.Client;
import com.luizalabs.util.NegocioValidator;
import dev.morphia.Key;
import org.bson.types.ObjectId;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Logger;

@Stateless
public class ClientService {

    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());

    @Inject
    ClientDAO clientDAO;

    @Inject
    ProductDAO productDAO;

    public String save(Client client) {
        NegocioValidator.validate(clientDAO.isEmailExists(client.getEmail()), "Email já cadastrado!");
        NegocioValidator.validate(!productDAO.allProductsExists(client.getFavoriteProducts()), "Um dos produtos não pode ser encontrado.");
        client.setId(null);
        Key<Client> key = clientDAO.save(client);
        String id = ((ObjectId)key.getId()).toHexString();
        LOGGER.info("Cliente salvo com sucesso: " + id);
        return id;
    }

    public String delete(String id) {
        clientDAO.delete(new Client(id));
        LOGGER.info("Cliente deletado com sucesso: " + id);
        return id;
    }

    public Client find(String id) {
        LOGGER.info("Buscando cliente: " + id);
        return clientDAO.find(id);
    }

    public String update(Client client) {
        Client clientDB = clientDAO.find(client.getId());
        NegocioValidator.validate(clientDB == null, "Cliente não encontrado.");
        NegocioValidator.validate(!productDAO.allProductsExists(client.getFavoriteProducts()), "Um dos produtos não pode ser encontrado.");
        ;
        client.setEmail(clientDB.getEmail());
        Key<Client> key = clientDAO.save(client);
        String id = ((ObjectId)key.getId()).toHexString();
        LOGGER.info("Cliente atualizado com sucesso: " + id);
        return id;
    }
}
