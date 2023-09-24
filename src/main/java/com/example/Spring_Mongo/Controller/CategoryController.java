package com.example.Spring_Mongo.Controller;

import com.example.Spring_Mongo.Models.Category;
import com.example.Spring_Mongo.Models.Product;
import com.example.Spring_Mongo.Service.CategoryService;
import com.example.Spring_Mongo.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
@RequiredArgsConstructor
@Validated
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping(path = "/update")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping(path = "/delete/{categoryId}")
    public String deleteCategory(@PathVariable String categoryId){
        return categoryService.deleteCategory(categoryId);
    }



    @GetMapping("/{category_name}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category_name) {
        List<Product> products = productService.getProductsByCategory(category_name);
        return ResponseEntity.ok(products);
    }
}
