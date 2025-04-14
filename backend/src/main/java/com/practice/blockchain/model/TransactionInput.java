package com.practice.blockchain.model;

import org.springframework.data.annotation.Id;

public record TransactionInput(
        @Id
        String transactionOutputId
) {}
