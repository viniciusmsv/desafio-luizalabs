package com.luizalabs.service;

import com.luizalabs.dao.ProductDAO;
import com.luizalabs.entity.Product;
import com.luizalabs.exception.NotFoundException;
import com.luizalabs.mock.ProductMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductDAO productDAO;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        ProductMock.mock(productDAO);
    }

    @Test
    public void productDetailSuccess(){
        Product product = productService.productDetail(ProductMock.REAL_PRODUCT_ID);
        assertTrue(ProductMock.REAL_PRODUCT_ID.equals(product.getId()));
    }

    @Test
    public void productDetailNotFound(){
        assertThrows(NotFoundException.class, () -> productService.productDetail(ProductMock.FAKE_PRODUCT_ID), "Produto não pode ser encontrado!");
    }

    @Test
    public void listProductsPage1(){
        List<Product> products = productService.listProducts(1);
        assertTrue(!products.isEmpty());
    }

    @Test
    public void listProductsNotFound(){
        assertThrows(NotFoundException.class, () -> productService.listProducts(2),"Nenhum produto encontrado.");
    }
}
