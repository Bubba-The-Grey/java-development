package com.pluralsight.daos;

import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public interface ProductDAO {
    @Autowired
    ProductDAO productDAO = null;
    HashMap<Integer, Product> getAll();
    Product getByID(int id);
    Product insert(Product product);
    void update(int id, Product product);
    void delete(int id);
}
