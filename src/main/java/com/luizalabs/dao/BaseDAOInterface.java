package com.luizalabs.dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;

import javax.inject.Inject;

public interface BaseDAOInterface<T, E> extends DAO<T, E> {

}
