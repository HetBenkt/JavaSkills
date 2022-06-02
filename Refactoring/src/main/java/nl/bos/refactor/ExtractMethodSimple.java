package nl.bos.refactor;

import java.util.logging.Logger;

public class ExtractMethodSimple {
    private static final Logger logger = Logger.getLogger(ExtractMethodSimple.class.getName());
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";

    public void printOwing() {
        printBanner();

        //Print details
        logger.info("firstname" + FIRST_NAME);
        logger.info("lastname" + LAST_NAME);
    }

    private void printBanner() {
        logger.info("===BANNER===========");
    }
}
