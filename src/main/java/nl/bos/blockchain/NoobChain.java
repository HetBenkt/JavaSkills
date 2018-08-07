package nl.bos.blockchain;

import com.google.gson.GsonBuilder;
import lombok.extern.java.Log;

import java.util.ArrayList;

@Log
public class NoobChain {
    private static final ArrayList<Block> blockChain = new ArrayList<>();
    private static final int DIFFICULTY = 3;


    public static void main(String[] args) {
        Block genesisBlock = new Block("0", "This is the first block");
        blockChain.add(genesisBlock);
        genesisBlock.mineBlock(DIFFICULTY);

        Block secondBlock = new Block(genesisBlock.getHash(), "This is the second block");
        blockChain.add(secondBlock);
        secondBlock.mineBlock(DIFFICULTY);

        Block thirdBlock = new Block(secondBlock.getHash(), "This is the third block");
        blockChain.add(thirdBlock);
        thirdBlock.mineBlock(DIFFICULTY);

        log.info(String.format("Is a valid blockchain: %s", isChainValid()));

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        log.info(blockChainJson);
    }

    private static boolean isChainValid() {
        String hashTarget = new String(new char[DIFFICULTY]).replace('\0', '0');

        for (int i = 1; i < blockChain.size(); i++) {
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calcHash())) {
                log.info("Current Hashes not equal");
                return false;
            }
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                log.info("Previous Hashes not equal");
                return false;
            }
            if (!currentBlock.getHash().substring(0, DIFFICULTY).equals(hashTarget)) {
                log.info("This block hasn't been mined");
                return false;

            }
        }
        return true;
    }
}