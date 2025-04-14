package com.practice.blockchain.model;

import org.springframework.data.annotation.Id;

import java.security.PublicKey;

public record Transaction(
        @Id
        String transactionId,
        PublicKey sender,
        PublicKey recipient,
        float value,
        byte[] signature
) {}
