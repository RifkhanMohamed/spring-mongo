package com.example.Spring_Mongo.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "category")
public class Category {
        @Id
        private String id;
        private String categoryName;
        private List<String> productIds;
}
