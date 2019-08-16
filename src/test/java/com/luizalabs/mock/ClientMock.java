package com.luizalabs.mock;

import com.luizalabs.dao.ClientDAO;
import com.luizalabs.entity.Client;
import dev.morphia.Key;
import org.bson.types.ObjectId;
import org.mockito.Mockito;

import java.util.Date;
import java.util.HashSet;

public class ClientMock {

    public static final String REAL_CLIENT_ID = "5d5384c215156f7cf2a4662d";
    public static final String FAKE_CLIENT_ID = "5d537bd73eb373003fc49855";

    public static void mock(ClientDAO clientDAO) {

        Mockito.when(clientDAO.emailExists("jaexiste@teste.com")).thenReturn(Boolean.TRUE);
        Mockito.when(clientDAO.save(build())).thenReturn(new Key<>(Client.class, "clients", new ObjectId(new Date())));

        Client client = build();
        client.setId(new ObjectId(REAL_CLIENT_ID));
        Mockito.when(clientDAO.save(client)).thenReturn(new Key<>(Client.class, "clients", new ObjectId(REAL_CLIENT_ID)));

        Mockito.when(clientDAO.find(REAL_CLIENT_ID)).thenReturn(new Client(REAL_CLIENT_ID));
        Mockito.when(clientDAO.find(FAKE_CLIENT_ID)).thenReturn(null);
    }

    public static Client build() {
        Client client = new Client();
        client.setEmail("teste@teste.com");
        client.setEndereco("teste endereco");
        client.setNome("testador");
        client.setFavoriteProducts(new HashSet<>());
        return client;
    }
}
