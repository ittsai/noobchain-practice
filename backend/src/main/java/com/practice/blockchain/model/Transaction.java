package com.practice.blockchain.model;

import org.bson.types.ObjectId;
import java.time.Instant;

public record Transaction(
        ObjectId _id,
        String renterId,
        String assetId,
        RentalPeriod rentalPeriod,
        String signature,
        Instant timestamp,
        Status status
) {}

