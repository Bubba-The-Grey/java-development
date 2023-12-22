package com.pluralsight.NorthwindTradersSpringBoot.daos;
import java.util.*;

import com.pluralsight.NorthwindTradersSpringBoot.daos.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

public class SimpleProductDAO implements ProductDAO {
    private List<Product> products;
    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
    public SimpleProductDAO(){
        this.products = new ArrayList<>();
        products.add(0, new Product(1, "Chai", "Beverages", 18.00));
        products.add(1, new Product(2, "Chang", "Beverages", 19.00));
        products.add(2, new Product(3, "Aniseed Syrup", "Condiments", 10.00));
    }
}