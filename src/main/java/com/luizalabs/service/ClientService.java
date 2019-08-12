package com.luizalabs.service;

import com.luizalabs.dto.ClientDTO;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@RequestScoped
public class ClientService implements Serializable {

    public ClientDTO save(ClientDTO client) {

        return client;
    }
}
