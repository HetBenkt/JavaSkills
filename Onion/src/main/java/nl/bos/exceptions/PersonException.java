package nl.bos.exceptions;

import java.text.MessageFormat;

public class PersonException extends AbstractPersonException {
    public PersonException(String message) {
        super(MessageFormat.format("Person error on SQL level with message: {0}", message));
    }
}
