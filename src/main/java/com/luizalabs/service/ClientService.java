package com.luizalabs.service;

import com.luizalabs.dao.ClientDAO;
import com.luizalabs.dao.ProductDAO;
import com.luizalabs.entity.Client;
import com.luizalabs.exception.BusinessException;
import com.luizalabs.exception.NotFoundException;
import com.luizalabs.util.Validator;
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

    public Client save(Client client) {

        Validator.validate(clientDAO.emailExists(client.getEmail()),  new BusinessException("Email já cadastrado!"));

        if(client.getFavoriteProducts() != null && !client.getFavoriteProducts().isEmpty()) {
            Validator.validate(!productDAO.allProductsExists(client.getFavoriteProducts()), new BusinessException("Um dos produtos não pode ser encontrado!"));
        }

        client.setId(null);
        Key<Client> key = clientDAO.save(client);
        String id = ((ObjectId)key.getId()).toHexString();
        client.setId(new ObjectId(id));
        LOGGER.info("Cliente salvo com sucesso: " + id);
        return client;
    }

    public String delete(String id) {
        clientDAO.delete(new Client(id));
        LOGGER.info("Cliente deletado com sucesso: " + id);
        return id;
    }

    public Client find(String id) {
        LOGGER.info("Buscando cliente: " + id);
        Client client = clientDAO.find(id);
        Validator.validate(client == null, new NotFoundException("Cliente não encontrado!"));
        return client;
    }

    public Client update(Client client) {
        Client clientDB = clientDAO.find(client.getId());

        Validator.validate(clientDB == null, new NotFoundException("Cliente não encontrado!"));

        Validator.validate(clientDAO.emailExists(client.getEmail()),  new BusinessException("Email já cadastrado!"));

        if(client.getFavoriteProducts() != null && !client.getFavoriteProducts().isEmpty()) {
            Validator.validate(!productDAO.allProductsExists(client.getFavoriteProducts()), new BusinessException("Um dos produtos não pode ser encontrado!"));
        }

        Key<Client> key = clientDAO.save(client);
        String id = ((ObjectId)key.getId()).toHexString();
        LOGGER.info("Cliente atualizado com sucesso: " + id);
        return client;
    }
}
