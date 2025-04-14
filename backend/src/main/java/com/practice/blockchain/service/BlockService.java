package com.practice.blockchain.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

    public final MongoTemplate mongoTemplate;

    public BlockService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void createBlock() {}
}
