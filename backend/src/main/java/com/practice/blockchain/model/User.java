package com.practice.blockchain.model;

import org.springframework.data.annotation.Id;

import java.security.PublicKey;
import java.time.Instant;
import java.util.List;

public record User(
        @Id
        String id,
        String walletAddress,
        String email,
        String name,
        PublicKey publicKey,
        UserRole role,
        Instant createdAt,
        Instant lastLoginAt
) {}
