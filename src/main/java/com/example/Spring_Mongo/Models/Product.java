package com.example.Spring_Mongo.Models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {
    private String id;
    private String title;
    private String price;
    private String product_details;
    private String image_url;
    private int quantity;
}
