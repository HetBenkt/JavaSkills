package nl.bos.blockchain;

import java.security.PublicKey;

public class TransactionOutput {
    private final String id;
    private final PublicKey recipient;
    private final float value;

    public TransactionOutput(PublicKey recipient, float value, String parentTransactionId) {
        this.recipient = recipient;
        this.value = value;
        this.id = StringUtils.applySha256(String.format("%s%s%s", StringUtils.getStringFromKey(recipient), value, parentTransactionId));
    }

    public String getId() {
        return id;
    }

    public PublicKey getRecipient() {
        return recipient;
    }

    public float getValue() {
        return value;
    }

    public boolean isMine(PublicKey publicKey) {
        return (publicKey == recipient);
    }
}
