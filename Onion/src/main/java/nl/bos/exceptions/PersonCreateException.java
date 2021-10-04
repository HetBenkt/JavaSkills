package nl.bos.exceptions;

public class PersonCreateException extends AbstractPersonException {

    public static final String TYPE = "Create";

    public PersonCreateException(final String message) {
        super(TYPE, message);
    }
}
