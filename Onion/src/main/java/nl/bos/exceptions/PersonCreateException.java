package nl.bos.exceptions;

import java.text.MessageFormat;

public class PersonCreateException extends PersonException {

    public PersonCreateException(String message) {
        super(MessageFormat.format("Create person error on SQL level with message: {0}", message));
    }
}
