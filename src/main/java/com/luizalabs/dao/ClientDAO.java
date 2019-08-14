package com.luizalabs.dao;

import com.luizalabs.entity.Client;
import dev.morphia.Key;

public interface ClientDAO {

    Boolean isEmailExists(String email);

    Key<Client> save(Client client);

    void delete(Client client);

    Client find(String client);
}
