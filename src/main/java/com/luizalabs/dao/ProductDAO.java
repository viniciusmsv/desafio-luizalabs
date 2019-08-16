package com.luizalabs.dao;

import com.luizalabs.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductDAO {

    Product findById(String id);

    List<Product> findWithPagination(Integer page);

    Boolean  allProductsExists(Set<Product> ids);
}
