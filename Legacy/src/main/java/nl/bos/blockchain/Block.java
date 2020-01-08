package nl.bos.blockchain;

import lombok.Getter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Date;

@Log
public class Block {
    @Getter
    private String hash;
    @Getter
    private String previousHash;
    private final long timeStamp;
    private int nonce;
    private String merkleRoot;
    @Getter
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calcHash();
    }

    public String calcHash() {
        return StringUtils.applySha256(String.format("%s%s%s%s", previousHash, Long.toString(timeStamp), Integer.toString(nonce), merkleRoot));
    }

    public void mineBlock(int difficulty) {
        merkleRoot = StringUtils.getMerkleRoot(transactions);
        String target = StringUtils.getDifficultyString(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calcHash();
        }
        log.info(String.format("Block mined: %s", hash));
    }

    public boolean addTransaction(Transaction transaction) {
        if (transaction == null) return false;
        if ((!previousHash.equals("0")) && (!transaction.processTransaction())) {
            log.info("Transaction failed to process. Discarded.");
            return false;
        }
        transactions.add(transaction);
        log.info("Transaction Successfully added to Block");
        return true;
    }
}
