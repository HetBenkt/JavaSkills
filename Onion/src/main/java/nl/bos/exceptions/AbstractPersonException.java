package nl.bos.exceptions;

import java.text.MessageFormat;

public abstract class AbstractPersonException extends RuntimeException {
    private final String message;

    public AbstractPersonException(final String type, final String message) {
        this.message = MessageFormat.format("{0} person error on SQL level with message: {1}", type, message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}