package com.example.Spring_Mongo.Service;

import com.example.Spring_Mongo.Models.Category;
import com.example.Spring_Mongo.Models.Product;
import com.example.Spring_Mongo.Repository.CategoryRepo;
import com.example.Spring_Mongo.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product createProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> bulkProductUpload(List<Product> products){
        return productRepo.saveAll(products);
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public String deleteProduct(String productID) {
        productRepo.deleteById(productID);
        return "Deleted Successfully..!";
    }

    public List<Product> getProductsByCategory(String category_name) {
        // Find the category by its name
        Category category = categoryRepo.findByCategoryNameContainingIgnoreCase(category_name);

        if (category != null) {
            // Retrieve products using the product IDs from the category

            List<Product> products = productRepo.findAllById(category.getProductIds());
            return products;
        } else {
            // Handle the case when the category does not exist
            return Collections.emptyList();
        }
    }
}
