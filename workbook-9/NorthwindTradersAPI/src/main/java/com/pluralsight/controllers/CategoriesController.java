package com.pluralsight.controllers;
import com.pluralsight.daos.CategoryDAO;
import com.pluralsight.models.Category;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
public class CategoriesController {
    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoriesController(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }
    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public HashMap<Integer, Category> allCategories(){
        return categoryDAO.getAll();
    }

    @RequestMapping(path="/categories/searchByID/{id}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable String id){
        return categoryDAO.getByID(Integer.parseInt(id));
    }

    @RequestMapping(path="/categories/insert", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category insert(@RequestBody Category category){
        return categoryDAO.insert(category);
    }

    @RequestMapping(path="categories/update/{id}", method=RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Category category){
        categoryDAO.update(id, category);
    }

    @RequestMapping(path="categories/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        categoryDAO.delete(id);
    }
}
