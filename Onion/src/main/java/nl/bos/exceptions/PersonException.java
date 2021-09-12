package nl.bos.exceptions;

public class PersonException extends RuntimeException {
    private final String message;

    public PersonException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
