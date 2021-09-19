package nl.bos.exceptions;

public abstract class AbstractPersonException extends RuntimeException {
    private final String message;

    public AbstractPersonException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}