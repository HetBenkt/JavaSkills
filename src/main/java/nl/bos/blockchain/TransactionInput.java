package nl.bos.blockchain;

import lombok.Getter;
import lombok.Setter;

public class TransactionInput {
    @Getter
    private String transactionOutputId;
    @Getter
    @Setter
    private TransactionOutput utco;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}