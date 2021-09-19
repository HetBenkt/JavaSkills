package nl.bos.exceptions;

import java.text.MessageFormat;

public class PersonReadException extends AbstractPersonException {

    //todo call the class
    public PersonReadException(String message) {
        super(MessageFormat.format("Read person error on SQL level with message: {0}", message));
    }
}
