package com.practice.blockchain.model;

import org.springframework.data.annotation.Id;

import java.time.Instant;

public record Transaction(
        @Id
        String id,
        String renterId,
        String assetId,
        RentalPeriod rentalPeriod,
        String signature,
        Instant timestamp,
        Status status
) {}

