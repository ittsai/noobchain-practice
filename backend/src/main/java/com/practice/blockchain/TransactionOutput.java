package com.practice.blockchain;

import com.practice.blockchain.util.StringUtil;

import java.security.PublicKey;

public class TransactionOutput {
    public String id;
    public PublicKey reciepient;
    public float value;
    public String parentTransactionID;

    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionID) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionID = parentTransactionID;
        this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient));
    }

    public boolean isMine(PublicKey publicKey) {
        return publicKey == reciepient;
    }
}
