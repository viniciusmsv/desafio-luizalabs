package com.luizalabs.dao;

import com.luizalabs.entity.Client;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface ClientDAO extends DAO<Client, ObjectId> {

    Boolean isEmailExists(String email);
}
