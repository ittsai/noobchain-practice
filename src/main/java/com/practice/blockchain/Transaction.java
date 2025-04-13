package com.practice.blockchain;

import com.practice.blockchain.util.StringUtil;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Transaction {
    public String transactionID;
    public PublicKey sender;
    public PublicKey reciepient;
    public float value;
    public byte[] signature;

    public ArrayList<TransactionInput> inputs = new ArrayList<>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<>();

    private static int sequence = 0;

    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs = inputs;
    }

    public boolean processTransaction() {
        if (verifySignature() == false) {
            return false;
        }

        for (TransactionInput i : inputs) {
            i.UTXO = Main.UTXOs.get(i.transactionOutputID);
        }

        if (getInputsValue() < Main.minimumTransaction) {
            return false;
        }

        float lefeOver = getInputsValue() - value;
        transactionID = calculateHash();
        outputs.add(new TransactionOutput(this.reciepient, value, transactionID));
        outputs.add(new TransactionOutput(this.sender, lefeOver, transactionID));

        for (TransactionOutput o : outputs) {
            Main.UTXOs.put(o.id, o);
        }

        for (TransactionInput i : inputs) {
            if (i.UTXO == null) continue;

            Main.UTXOs.remove(i.UTXO.id);
        }

        return true;
    }
    public String calculateHash() {
        sequence++;
        return StringUtil.applySha256(
                  StringUtil.getStringFromKey(sender) +
                          StringUtil.getStringFromKey(reciepient) +
                        value + sequence
        );
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + value;
        signature = StringUtil.applyECDSASignature(privateKey, data);
    }

    public boolean verifySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        return StringUtil.verifyECDSASignature(sender, data, signature);
    }

    public float getInputsValue() {
        float total = 0;

        for (TransactionInput i : inputs) {
            if (i.UTXO == null) continue;

            total += i.UTXO.value;
        }

        return total;
    }

    public float getOutputsValue() {
        float total = 0;

        for (TransactionOutput o : outputs) {
            total += o.value;
        }
        return total;
    }
}
