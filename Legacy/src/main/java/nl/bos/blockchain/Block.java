package nl.bos.blockchain;

import java.util.ArrayList;
import java.util.Date;

public class Block {
    private String hash;
    private String previousHash;
    private final long timeStamp;
    private int nonce;
    private String merkleRoot;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calcHash();
    }

    public String calcHash() {
        return StringUtils.applySha256(String.format("%s%s%s%s", previousHash, timeStamp, nonce, merkleRoot));
    }

    public void mineBlock(int difficulty) {
        merkleRoot = StringUtils.getMerkleRoot(transactions);
        String target = StringUtils.getDifficultyString(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calcHash();
        }
        System.out.println(String.format("Block mined: %s", hash));
    }

    public boolean addTransaction(Transaction transaction) {
        if (transaction == null) return false;
        if ((!previousHash.equals("0")) && (!transaction.processTransaction())) {
            System.out.println("Transaction failed to process. Discarded.");
            return false;
        }
        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }
}
