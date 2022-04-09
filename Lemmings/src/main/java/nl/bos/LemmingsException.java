package nl.bos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LemmingsException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(LemmingsException.class.getName());

    public LemmingsException(String message, IOException e) {
        logger.log(Level.SEVERE, message, e);
    }
}
