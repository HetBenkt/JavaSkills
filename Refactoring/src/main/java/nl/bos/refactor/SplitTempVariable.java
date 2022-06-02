package nl.bos.refactor;


import java.util.logging.Logger;

public class SplitTempVariable {
    private static final Logger logger = Logger.getLogger(SplitTempVariable.class.getName());
    private static final double HEIGHT = 10;
    private static final double WIDTH = 12;

    public void calculate() {
        double temp = 2 * (HEIGHT + WIDTH);
        logger.info(String.valueOf(temp));
        temp = HEIGHT * WIDTH;
        logger.info(String.valueOf(temp));
    }
}
