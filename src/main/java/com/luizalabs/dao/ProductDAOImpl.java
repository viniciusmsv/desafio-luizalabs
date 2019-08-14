package com.luizalabs.dao;

import com.luizalabs.entity.Product;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import javax.inject.Inject;

public class ProductDAOImpl extends BasicDAO<Product, ObjectId> implements ProductDAO {

    public static final String DB_NAME = "luizalabs";

    @Inject
    protected ProductDAOImpl(MongoClient mongoClient, Morphia morphia) {
        super(mongoClient, morphia, DB_NAME);
    }

}
