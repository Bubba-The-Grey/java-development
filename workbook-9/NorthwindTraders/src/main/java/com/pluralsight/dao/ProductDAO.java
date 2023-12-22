package com.pluralsight.dao;
import com.pluralsight.model.Product;
import java.util.*;

public interface ProductDAO {
    void add(Product product);
    List<Product> getAll();
}
