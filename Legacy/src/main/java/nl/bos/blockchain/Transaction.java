package nl.bos.blockchain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Log
public class Transaction {
    @Setter
    @Getter
    private String transactionId;
    @Getter
    private PublicKey sender;
    @Getter
    private PublicKey recipient;
    @Getter
    private float value;
    private byte[] signature;

    @Getter
    private List<TransactionInput> inputs;
    @Getter
    private List<TransactionOutput> outputs = new ArrayList<>();

    public Transaction(PublicKey sender, PublicKey recipient, float value, List<TransactionInput> inputs) {
        this.sender = sender;
        this.recipient = recipient;
        this.value = value;
        this.inputs = inputs;
    }

    private String calcHash() {
        return StringUtils.applySha256(String.format("%s%s%s%s", StringUtils.getStringFromKey(sender), StringUtils.getStringFromKey(recipient), Float.toString(value), 0));
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtils.getStringFromKey(sender) + StringUtils.getStringFromKey(recipient) + Float.toString(value);
        signature = StringUtils.applyECDSASig(privateKey, data);
    }

    public boolean verifySignature() {
        String data = StringUtils.getStringFromKey(sender) + StringUtils.getStringFromKey(recipient) + Float.toString(value);
        return !StringUtils.verifyECDSASig(sender, data, signature);
    }

    public boolean processTransaction() {

        if (verifySignature()) {
            log.info("#Transaction Signature failed to verify");
            return false;
        }

        for (TransactionInput transactionInput : inputs) {
            TransactionOutput transactionOutput = NoobChain.getUtxos().get(transactionInput.getTransactionOutputId());
            transactionInput.setUtco(transactionOutput);
        }

        if (getInputsValue() < NoobChain.getMinimumTransaction()) {
            log.info("#Transaction Inputs to small: " + getInputsValue());
            return false;
        }

        float leftOver = getInputsValue() - value;
        transactionId = calcHash();
        outputs.add(new TransactionOutput(this.recipient, value, transactionId));
        outputs.add(new TransactionOutput(this.sender, leftOver, transactionId));

        for (TransactionOutput transactionOutput : outputs) {
            NoobChain.getUtxos().put(transactionOutput.getId(), transactionOutput);
        }

        for (TransactionInput transactionInput : inputs) {
            if (transactionInput.getUtco() == null) continue;
            NoobChain.getUtxos().remove(transactionInput.getUtco().getId());
        }

        return true;
    }

    public float getInputsValue() {
        float total = 0;
        for (TransactionInput transactionInput : inputs) {
            if (transactionInput.getUtco() == null)
                continue;
            total += transactionInput.getUtco().getValue();
        }
        return total;
    }

    public float getOutputsValue() {
        float total = 0;
        for (TransactionOutput transactionOutput : outputs) {
            total += transactionOutput.getValue();
        }
        return total;
    }
}