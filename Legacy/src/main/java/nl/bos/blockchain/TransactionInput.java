package nl.bos.blockchain;

public class TransactionInput {
    private String transactionOutputId;
    private TransactionOutput utco;

    public String getTransactionOutputId() {
        return transactionOutputId;
    }

    public void setTransactionOutputId(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }

    public TransactionOutput getUtco() {
        return utco;
    }

    public void setUtco(TransactionOutput utco) {
        this.utco = utco;
    }

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}