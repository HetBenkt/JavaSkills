package nl.bos.blockchain;

import lombok.Getter;

import java.security.PublicKey;

public class TransactionOutput {
    @Getter
    private String id;
    @Getter
    private PublicKey recipient;
    @Getter
    private float value;

    public TransactionOutput(PublicKey recipient, float value, String parentTransactionId) {
        this.recipient = recipient;
        this.value = value;
        this.id = StringUtils.applySha256(String.format("%s%s%s", StringUtils.getStringFromKey(recipient), Float.toString(value), parentTransactionId));
    }

    public boolean isMine(PublicKey publicKey) {
        return (publicKey == recipient);
    }
}
