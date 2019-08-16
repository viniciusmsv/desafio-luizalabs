package com.luizalabs.mock;

import com.luizalabs.dao.ProductDAO;
import com.luizalabs.entity.Product;
import org.bson.types.ObjectId;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProductMock {

    public static final String FAKE_PRODUCT_ID = "5d535db2fba5fa6c2473f4d5";
    public static final String REAL_PRODUCT_ID = "5d535db2fba5fa6c2473f4d4";

    public static void mock(ProductDAO productDAO) {
        Mockito.when(productDAO.allProductsExists(buildSet())).thenReturn(!FAKE_PRODUCT_ID.equals(REAL_PRODUCT_ID));
        Mockito.when(productDAO.findById(REAL_PRODUCT_ID)).thenReturn(build());
        Mockito.when(productDAO.findWithPagination(1)).thenReturn(new ArrayList<>(buildSet()));
    }

    public static Set<Product> buildSet() {
        Set<Product> products = new HashSet<>();
        Product product = build();
        products.add(product);
        return products;
    }

    public static Product build() {
        Product product = new Product();
        product.setId(new ObjectId(REAL_PRODUCT_ID));
        return product;
    }
}
