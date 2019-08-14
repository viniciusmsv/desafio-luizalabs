package com.luizalabs.service;

import com.luizalabs.dao.ProductDAO;
import com.luizalabs.entity.Product;
import com.luizalabs.exception.NotFoundException;
import com.luizalabs.util.Validator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

    @Inject
    ProductDAO productDAO;

    public Product productDetail(String id) {
        LOGGER.info("Buscando produto: " + id);
        Product product = productDAO.findWithPagination(id);
        Validator.validate(product == null, new NotFoundException("Produto não pode ser encontrado."));
        return product;
    }

    public List<Product> listProducts(Integer page) {
        LOGGER.info("Listando clientes pagina: " + page);
        List<Product> products = productDAO.findWithPagination(page);
        Validator.validate(products.isEmpty(), new NotFoundException("Nenhum produto encontrado."));
        return products;
    }
}
