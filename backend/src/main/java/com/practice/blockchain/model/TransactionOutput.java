package com.practice.blockchain.model;

import com.practice.blockchain.util.StringUtil;

import java.security.PublicKey;

public record TransactionOutput(
        PublicKey recipient,
        float value,
        String parentTransactionId,
        String id) {
    public TransactionOutput(PublicKey recipient, float value, String parentTransactionId) {
        this(
                recipient,
                value,
                parentTransactionId,
                StringUtil.applySha256(StringUtil.getStringFromKey(recipient))
        );
    }
}
