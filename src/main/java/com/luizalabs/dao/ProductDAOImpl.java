package com.luizalabs.dao;

import com.luizalabs.entity.Product;
import dev.morphia.Datastore;
import dev.morphia.query.FindOptions;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDAOImpl implements ProductDAO {

    @Inject
    Datastore datastore;

    @Override
    public Product findById(String id) {
        return datastore.find(Product.class).field("_id").equal(new ObjectId(id)).first();
    }

    @Override
    public List<Product> findWithPagination(Integer page) {
        return datastore.find(Product.class).find(new FindOptions()
                .skip((page-1)*10)
                .limit(10)).toList();
    }

    @Override
    public Boolean allProductsExists(Set<Product> products) {
        Set<ObjectId> ids = products.stream().map(product -> new ObjectId(product.getId())).collect(Collectors.toSet());
        Long total = datastore.find(Product.class).field("_id").in(ids).count();
        return total == ids.size();
    }
}
