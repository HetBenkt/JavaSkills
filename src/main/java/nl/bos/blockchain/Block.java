package nl.bos.blockchain;

import lombok.Getter;
import lombok.extern.java.Log;

import java.util.Date;

@Log
public class Block {
    @Getter
    private String hash;
    @Getter
    private String previousHash;
    private final String data;
    private final long timeStamp;
    private int nonce;

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calcHash();
    }

    public String calcHash() {
        return StringUtils.applySha256(String.format("%s%s%s%s", previousHash, Long.toString(timeStamp), Integer.toString(nonce), data));
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calcHash();
        }
        log.info(String.format("Block mined: %s", hash));
    }
}
