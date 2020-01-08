package nl.bos.blockchain;

import lombok.Getter;
import lombok.extern.java.Log;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Log
public class Wallet {
    @Getter
    private PublicKey publicKey;
    @Getter
    private PrivateKey privateKey;
    private final HashMap<String, TransactionOutput> utxos = new HashMap<>();


    public Wallet() {
        generateKeyPair();
    }

    private void generateKeyPair() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecGen = new ECGenParameterSpec("prime192v1");
            keyPairGen.initialize(ecGen, secureRandom);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            log.finest(e.getMessage());
        }
    }

    public float getBalance() {
        float total = 0;
        for (Map.Entry<String, TransactionOutput> item : NoobChain.getUtxos().entrySet()) {
            TransactionOutput utco = item.getValue();
            if (utco.isMine(publicKey)) {
                utxos.put(utco.getId(), utco);
                total += utco.getValue();
            }
        }
        return total;
    }

    public Transaction sendFunds(PublicKey recipient, float value) {
        if (getBalance() < value) { //gather balance and check funds.
            log.info("#Not Enough funds to send transaction. Transaction Discarded.");
            return null;
        }
        ArrayList<TransactionInput> inputs = new ArrayList<>();

        float total = 0;
        for (Map.Entry<String, TransactionOutput> item : utxos.entrySet()) {
            TransactionOutput utco = item.getValue();
            total += utco.getValue();
            inputs.add(new TransactionInput(utco.getId()));
            if (total > value) break;
        }

        Transaction newTransaction = new Transaction(publicKey, recipient, value, inputs);
        newTransaction.generateSignature(privateKey);

        for (TransactionInput input : inputs) {
            utxos.remove(input.getTransactionOutputId());
        }
        return newTransaction;
    }
}
