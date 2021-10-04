package nl.bos.exceptions;

public class PersonException extends AbstractPersonException {

    private static final String TYPE = "Generic";

    public PersonException(String message) {
        super(TYPE, message);
    }
}
