package com.practice.blockchain.model;

public record Asset(
        String _id,
        String name,
        String location,
        String available,
        String ownerId
) {}
