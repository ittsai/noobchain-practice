package com.practice.blockchain.model;

import org.springframework.data.annotation.Id;

import java.time.Instant;

public record Token(
        @Id
        String id,
        String userId,
        Instant issuedAt,
        Instant expiresAt,
        boolean revoked
) {}
