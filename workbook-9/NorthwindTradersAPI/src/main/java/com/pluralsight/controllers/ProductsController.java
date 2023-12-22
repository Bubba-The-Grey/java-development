package com.pluralsight.controllers;

import com.pluralsight.daos.ProductDAO;
import com.pluralsight.models.Category;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class ProductsController {
    private final ProductDAO productDAO;

    @Autowired
    public ProductsController(ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    @RequestMapping(path="/products", method = RequestMethod.GET)
    public HashMap<Integer, Product> allProducts(){
        return productDAO.getAll();
    }

    @RequestMapping(path="/products/searchByID/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String id){
        return productDAO.getByID(Integer.parseInt(id));
    }

    @RequestMapping(path="/products/insert", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product insert(@RequestBody Product product){
        return productDAO.insert(product);
    }

    @RequestMapping(path="products/update/{id}", method=RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Product product){
        productDAO.update(id, product);
    }

    @RequestMapping(path="products/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        productDAO.delete(id);
    }
}
