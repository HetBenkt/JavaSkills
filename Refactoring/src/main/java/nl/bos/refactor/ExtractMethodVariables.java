package nl.bos.refactor;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ExtractMethodVariables {
    private static final Logger logger = Logger.getLogger(ExtractMethodVariables.class.getName());
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";

    public void printOwing() {
        printBanner();

        int sum = 0;
        List<Integer> values = Arrays.asList(0, 1);

        // calculate sum
        for (int value : values) {
            sum += value;
        }

        //print details
        logger.info("firstname" + FIRST_NAME);
        logger.info("lastname" + LAST_NAME);
        logger.info("sum" + sum);
    }

    private void printBanner() {
        logger.info("===BANNER===========");
    }
}
