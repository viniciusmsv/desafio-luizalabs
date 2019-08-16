package com.luizalabs.service;

import com.luizalabs.dao.ClientDAO;
import com.luizalabs.dao.ProductDAO;
import com.luizalabs.entity.Client;
import com.luizalabs.entity.Product;
import com.luizalabs.exception.BusinessException;
import com.luizalabs.exception.NotFoundException;
import com.luizalabs.mock.ClientMock;
import com.luizalabs.mock.ProductMock;
import com.luizalabs.util.CDIExtension;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

;

@ExtendWith(CDIExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientDAO clientDAO;

    @Mock
    private ProductDAO productDAO;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        ClientMock.mock(clientDAO);
        ProductMock.mock(productDAO);
    }

    @Test
    public void saveClientSuccessEmptyProducts(){
        Client mock = ClientMock.build();
        Client client = clientService.save(mock);
        assertNotNull(client.getId());
        assertTrue(client.getFavoriteProducts().isEmpty());
    }

    @Test
    public void saveClientSuccessNullProducts(){
        Client mock = ClientMock.build();
        mock.setFavoriteProducts(null);
        Client client = clientService.save(mock);
        assertNotNull(client.getId());
        assertNull(client.getFavoriteProducts());
    }

    @Test
    public void saveClientSuccessWithProducts(){
        Client mock = ClientMock.build();
        mock.setFavoriteProducts(ProductMock.buildSet());
        Client client = clientService.save(mock);
        assertNotNull(client);
    }

    @Test
    public void saveClientExceptionEmailJaExiste(){
        Client client = ClientMock.build();
        client.setEmail("jaexiste@teste.com");
        assertThrows(BusinessException.class, () -> clientService.save(client), "Email já cadastrado!");
    }

    @Test
    public void saveClientProductNotFound(){
        Client client = ClientMock.build();
        client.setFavoriteProducts(ProductMock.buildSet());
        Product productFake = new Product();
        productFake.setId(new ObjectId(ProductMock.FAKE_PRODUCT_ID));
        client.getFavoriteProducts().add(productFake);
        assertThrows(BusinessException.class, () -> clientService.save(client), "Um dos produtos não pode ser encontrado!");
    }

    @Test
    public void deleteClientSuccess(){
        String id = clientService.delete(ClientMock.REAL_CLIENT_ID);
        assertEquals(ClientMock.REAL_CLIENT_ID, id);
    }

    @Test
    public void findClientSuccess(){
        Client client = clientService.find(ClientMock.REAL_CLIENT_ID);
        assertEquals(ClientMock.REAL_CLIENT_ID, client.getId());
    }

    @Test
    public void findClientNotFound(){
        assertThrows(NotFoundException.class, () -> clientService.find(ClientMock.FAKE_CLIENT_ID), "Um dos produtos não pode ser encontrado!");
    }

    @Test
    public void updateClientSucces(){
        Client client = ClientMock.build();
        client.setId(new ObjectId(ClientMock.REAL_CLIENT_ID));
        client.setFavoriteProducts(ProductMock.buildSet());
        Client id = clientService.update(client);
        assertEquals(client, id);
        assertEquals(client.getFavoriteProducts(), id.getFavoriteProducts());
    }

    @Test
    public void updateClientProductNotFound(){
        Client client = ClientMock.build();
        client.setId(new ObjectId(ClientMock.REAL_CLIENT_ID));
        client.setFavoriteProducts(ProductMock.buildSet());
        Product productFake = new Product();
        productFake.setId(new ObjectId(ProductMock.FAKE_PRODUCT_ID));
        client.getFavoriteProducts().add(productFake);
        assertThrows(BusinessException.class, () -> clientService.update(client), "Um dos produtos não pode ser encontrado!");
    }

    @Test
    public void updateClientDuplicateProduct(){
        Client mock = ClientMock.build();
        mock.setId(new ObjectId(ClientMock.REAL_CLIENT_ID));
        mock.setFavoriteProducts(ProductMock.buildSet());
        Product duplicate = ProductMock.build();
        duplicate.setId(new ObjectId(ProductMock.REAL_PRODUCT_ID));
        mock.getFavoriteProducts().add(duplicate);
        Client client = clientService.update(mock);
        assertTrue(client.getFavoriteProducts().size() == 1);
    }

    @Test
    public void updateClientNotFound(){
        Client mock = ClientMock.build();
        mock.setId(new ObjectId(ClientMock.FAKE_CLIENT_ID));
        assertThrows(NotFoundException.class, () -> clientService.update(mock), "Cliente não encontrado!");
    }

}
