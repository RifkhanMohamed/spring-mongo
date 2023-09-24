package com.example.Spring_Mongo.Service;

import com.example.Spring_Mongo.Models.Category;
import com.example.Spring_Mongo.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAll(){
        return categoryRepo.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepo.save(category);
    }

    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }

    public String deleteCategory(String categoryID) {
        categoryRepo.deleteById(categoryID);
        return "Deleted Successfully..!";
    }
}
