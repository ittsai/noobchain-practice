package com.practice.blockchain.model;

import java.time.Instant;

public record RentalPeriod(
        Instant start,
        Instant end
) {}
