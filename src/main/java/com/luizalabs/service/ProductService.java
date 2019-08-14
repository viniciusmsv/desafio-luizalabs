package com.luizalabs.service;

import com.luizalabs.dao.ProductDAO;
import com.luizalabs.entity.Product;
import org.bson.types.ObjectId;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProductService {

    @Inject
    ProductDAO productDAO;

    public Product productDetail(String id) {
        return productDAO.findOne("_id", new ObjectId(id));
    }

    public List<Product> listProducts(Integer page) {
        return productDAO.find().asList();
    }
}
