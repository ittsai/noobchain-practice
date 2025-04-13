package com.practice.blockchain;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
    public PrivateKey privateKey; // sign
    public PublicKey publicKey; // address

    public Wallet() {

    }

    public void generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("prime192v1");

            keyPairGenerator.initialize(ecGenParameterSpec, random);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
