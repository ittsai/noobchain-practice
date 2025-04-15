package com.practice.blockchain.repository;

import com.practice.blockchain.model.Block;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BlockRepository {
    public final MongoTemplate mongoTemplate;
    public final String BLOCKS_COLLECTION = "blocks";
    
    public BlockRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insertBlock(Block newBlock) {
        mongoTemplate.insert(newBlock, BLOCKS_COLLECTION);
    }

}
