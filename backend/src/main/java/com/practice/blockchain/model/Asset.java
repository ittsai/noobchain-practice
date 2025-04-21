package com.practice.blockchain.model;

import org.springframework.data.annotation.Id;

public record Asset(
        @Id
        String id,
        String name,
        String location,
        String available,
        String ownerId
) {}
