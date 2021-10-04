package nl.bos.exceptions;

public class PersonReadException extends AbstractPersonException {

    private static final String TYPE = "Read";

    public PersonReadException(final String message) {
        super(TYPE, message);
    }
}
