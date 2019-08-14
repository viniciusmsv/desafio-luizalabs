package com.luizalabs.dao;

import com.luizalabs.entity.Product;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface ProductDAO extends DAO<Product, ObjectId> {

}
