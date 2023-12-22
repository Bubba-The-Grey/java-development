package com.pluralsight.NorthwindTradersSpringBoot.daos;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public interface ProductDAO {
    @Autowired
    ProductDAO productDAO = null;
    void add(Product product);
    List<Product> getAll();
}
