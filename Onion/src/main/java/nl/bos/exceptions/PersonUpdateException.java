package nl.bos.exceptions;

import java.text.MessageFormat;

public class PersonUpdateException extends AbstractPersonException {

    //todo call the class
    public PersonUpdateException(String message) {
        super(MessageFormat.format("Update person error on SQL level with message: {0}", message));
    }
}
