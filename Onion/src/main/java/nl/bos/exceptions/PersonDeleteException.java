package nl.bos.exceptions;

public class PersonDeleteException extends AbstractPersonException {

    private static final String TYPE = "Delete";

    public PersonDeleteException(final String message) {
        super(TYPE, message);
    }
}
