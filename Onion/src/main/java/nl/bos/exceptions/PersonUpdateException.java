package nl.bos.exceptions;

public class PersonUpdateException extends AbstractPersonException {

    private static final String TYPE = "Update";

    public PersonUpdateException(final String message) {
        super(TYPE, message);
    }
}
