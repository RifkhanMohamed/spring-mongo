package com.example.Spring_Mongo.Repository;

import com.example.Spring_Mongo.Models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends MongoRepository<Category,String> {
    Category findByCategoryNameContainingIgnoreCase(String category_name);
}
