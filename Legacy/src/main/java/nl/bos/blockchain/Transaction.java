package nl.bos.blockchain;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String transactionId;
    private PublicKey sender;
    private PublicKey recipient;
    private float value;
    private byte[] signature;

    private List<TransactionInput> inputs;
    private List<TransactionOutput> outputs = new ArrayList<>();

    public Transaction(PublicKey sender, PublicKey recipient, float value, List<TransactionInput> inputs) {
        this.sender = sender;
        this.recipient = recipient;
        this.value = value;
        this.inputs = inputs;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PublicKey getSender() {
        return sender;
    }

    public void setSender(PublicKey sender) {
        this.sender = sender;
    }

    public PublicKey getRecipient() {
        return recipient;
    }

    public void setRecipient(PublicKey recipient) {
        this.recipient = recipient;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public List<TransactionInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<TransactionInput> inputs) {
        this.inputs = inputs;
    }

    public List<TransactionOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<TransactionOutput> outputs) {
        this.outputs = outputs;
    }

    private String calcHash() {
        return StringUtils.applySha256(String.format("%s%s%s%s", StringUtils.getStringFromKey(sender), StringUtils.getStringFromKey(recipient), value, 0));
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtils.getStringFromKey(sender) + StringUtils.getStringFromKey(recipient) + value;
        signature = StringUtils.applyECDSASig(privateKey, data);
    }

    public boolean verifySignature() {
        String data = StringUtils.getStringFromKey(sender) + StringUtils.getStringFromKey(recipient) + value;
        return !StringUtils.verifyECDSASig(sender, data, signature);
    }

    public boolean processTransaction() {

        if (verifySignature()) {
            System.out.println("#Transaction Signature failed to verify");
            return false;
        }

        for (TransactionInput transactionInput : inputs) {
            TransactionOutput transactionOutput = NoobChain.getUtxos().get(transactionInput.getTransactionOutputId());
            transactionInput.setUtco(transactionOutput);
        }

        if (getInputsValue() < NoobChain.getMinimumTransaction()) {
            System.out.println("#Transaction Inputs to small: " + getInputsValue());
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