package com.practice.blockchain.model;

import java.security.PublicKey;

public record User(
        String _id,
        String name,
        String email,
        PublicKey publicKey,
        USerRole role
) {}
