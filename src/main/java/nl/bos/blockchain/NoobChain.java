package nl.bos.blockchain;

import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.extern.java.Log;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;

@Log
public class NoobChain {
    private static final ArrayList<Block> blockChain = new ArrayList<>();
    private static final int DIFFICULTY = 3;
    @Getter
    private static float minimumTransaction = 0.1f;
    @Getter
    private static HashMap<String, TransactionOutput> utxos = new HashMap<>();
    private static Transaction genesisTransaction;
    private static final String MSG_WALLET = "Wallet%s's balance is: %s";


    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        Wallet walletA = new Wallet();
        Wallet walletB = new Wallet();
        Wallet coinBase = new Wallet();

        genesisTransaction = new Transaction(coinBase.getPublicKey(), walletA.getPublicKey(), 100f, null);
        genesisTransaction.generateSignature(coinBase.getPrivateKey());
        genesisTransaction.setTransactionId("0");
        genesisTransaction.getOutputs().add(new TransactionOutput(genesisTransaction.getRecipient(), genesisTransaction.getValue(), genesisTransaction.getTransactionId()));
        utxos.put(genesisTransaction.getOutputs().get(0).getId(), genesisTransaction.getOutputs().get(0));

        log.info("Creating and Mining Genesis block... ");
        Block genesis = new Block("0");
        if (genesis.addTransaction(genesisTransaction))
            addBlock(genesis);

        //testing
        Block block1 = new Block(genesis.getHash());
        log.info(String.format(MSG_WALLET, "A", walletA.getBalance()));
        log.info("WalletA is Attempting to send funds (40) to WalletB...");
        if (block1.addTransaction(walletA.sendFunds(walletB.getPublicKey(), 40f)))
            addBlock(block1);
        log.info(String.format(MSG_WALLET, "A", walletA.getBalance()));
        log.info(String.format(MSG_WALLET, "B", walletB.getBalance()));

        Block block2 = new Block(block1.getHash());
        log.info("WalletA Attempting to send more funds (1000) than it has...");
        if (block2.addTransaction(walletA.sendFunds(walletB.getPublicKey(), 1000f)))
            addBlock(block2);
        log.info(String.format(MSG_WALLET, "A", walletA.getBalance()));
        log.info(String.format(MSG_WALLET, "B", walletB.getBalance()));

        Block block3 = new Block(block2.getHash());
        log.info("WalletB is Attempting to send funds (20) to WalletA...");
        block3.addTransaction(walletB.sendFunds(walletA.getPublicKey(), 20));
        log.info(String.format(MSG_WALLET, "A", walletA.getBalance()));
        log.info(String.format(MSG_WALLET, "B", walletB.getBalance()));

        if (isChainValid())
            log.info("Blockchain is valid");

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        log.info(blockChainJson);
    }

    private static void addBlock(Block block) {
        block.mineBlock(DIFFICULTY);
        blockChain.add(block);
    }

    private static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = StringUtils.getDifficultyString(DIFFICULTY);
        HashMap<String, TransactionOutput> tempUTXOs = new HashMap<>();
        tempUTXOs.put(genesisTransaction.getOutputs().get(0).getId(), genesisTransaction.getOutputs().get(0));

        for (int i = 1; i < blockChain.size(); i++) {

            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(currentBlock.calcHash())) {
                log.info("#Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                log.info("#Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if (!currentBlock.getHash().substring(0, DIFFICULTY).equals(hashTarget)) {
                log.info("#This block hasn't been mined");
                return false;
            }

            if (hasInvalidTransactions(currentBlock, tempUTXOs))
                return false;

        }
        return true;
    }

    private static boolean hasInvalidTransactions(Block currentBlock, HashMap<String, TransactionOutput> tempUTXOs) {
        for (int t = 0; t < currentBlock.getTransactions().size(); t++) {
            Transaction currentTransaction = currentBlock.getTransactions().get(t);

            if (currentTransaction.verifySignature()) {
                log.info("#Signature on Transaction(" + t + ") is Invalid");
                return true;
            }
            if (currentTransaction.getInputsValue() != currentTransaction.getOutputsValue()) {
                log.info("#Inputs are note equal to outputs on Transaction(" + t + ")");
                return true;
            }

            if (removeTempUtxos(tempUTXOs, t, currentTransaction))
                return true;

            for (TransactionOutput output : currentTransaction.getOutputs()) {
                tempUTXOs.put(output.getId(), output);
            }

            if (currentTransaction.getOutputs().get(0).getRecipient() != currentTransaction.getRecipient()) {
                log.info("#Transaction(" + t + ") output recipient is not who it should be");
                return true;
            }
            if (currentTransaction.getOutputs().get(1).getRecipient() != currentTransaction.getSender()) {
                log.info("#Transaction(" + t + ") output 'change' is not sender.");
                return true;
            }

        }
        return false;
    }

    private static boolean removeTempUtxos(HashMap<String, TransactionOutput> tempUTXOs, int t, Transaction currentTransaction) {
        for (TransactionInput input : currentTransaction.getInputs()) {
            TransactionOutput tempOutput = tempUTXOs.get(input.getTransactionOutputId());

            if (tempOutput == null) {
                log.info("#Referenced input on Transaction(" + t + ") is Missing");
                return true;
            }

            if (input.getUtco().getValue() != tempOutput.getValue()) {
                log.info("#Referenced input Transaction(" + t + ") value is Invalid");
                return true;
            }

            tempUTXOs.remove(input.getTransactionOutputId());
        }
        return false;
    }
}