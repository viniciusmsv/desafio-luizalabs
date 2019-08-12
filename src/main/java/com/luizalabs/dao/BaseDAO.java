package com.luizalabs.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

public class BaseDAO<T, E> {

    @Produces
    @ApplicationScoped
    public BaseDAO createDAO() {
        BaseDAO<T,E> dao = new BaseDAO<>();
        return dao;
    }

}
