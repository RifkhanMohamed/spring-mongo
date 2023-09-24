package com.example.Spring_Mongo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig {


    @Autowired
    private MappingMongoConverter mongoConverter;

    @PostConstruct
    public void setUpMongoEscapeCharacterAndTypeMapperConversion() {
        mongoConverter.setMapKeyDotReplacement("_");

        // This will remove _class: key
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }

}

