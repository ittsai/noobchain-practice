package com.practice.blockchain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collation = "blocks")
public record Block(
    @Id
    String hash,
    String previoushash,
    String merkleRoot,
    List<Transaction> transactions,
    Date timestamp,
    int nonce) {}
