package com.pluralsight.daos;

import com.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Component
public interface CategoryDAO {
    @Autowired
    CategoryDAO categoryDAO = null;
    HashMap<Integer, Category> getAll();
    Category getByID(int id);
    Category insert(Category category);
    void update(int id, Category category);
    void delete(int id);
}
