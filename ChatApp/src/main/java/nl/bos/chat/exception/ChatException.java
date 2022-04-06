package nl.bos.chat.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatException extends RuntimeException {
    private static final Logger LOGGER = Logger.getLogger(ChatException.class.getName());

    public ChatException(Exception e) {
        LOGGER.log(Level.SEVERE, "Error running server", e);
    }
}
