package com.practice.blockchain.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Configuration
public class MongoConfiguration implements InitializingBean {

    private final MongoTemplate mongoTemplate;
    private final Logger logger = LoggerFactory.getLogger(MongoConfiguration.class);

    public MongoConfiguration(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initDatabase();
    }

    private void initDatabase() throws IOException {
        if (!mongoTemplate.collectionExists("blocks")) {
            logger.info("create blocks collection");
            String jsonContent = new ClassPathResource("db/blocks.json").getContentAsString(StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode commands = objectMapper.readTree(jsonContent);

            for (JsonNode command : commands) {
                mongoTemplate.executeCommand(objectMapper.writeValueAsString(command));
            }
        }
    }

}
