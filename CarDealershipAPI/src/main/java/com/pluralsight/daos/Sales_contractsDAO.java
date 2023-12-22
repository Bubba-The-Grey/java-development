package com.pluralsight.daos;

import com.pluralsight.models.Sales_contracts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public interface Sales_contractsDAO {
    @Autowired
    Sales_contractsDAO sales_contractsDAO = null;

    HashMap<Integer, Sales_contracts> getAll();
    void addSale(Sales_contracts sales_contract);
}
