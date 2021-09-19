package nl.bos.exceptions;

import java.text.MessageFormat;

public class PersonDeleteException extends AbstractPersonException {

    //todo call the class
    public PersonDeleteException(String message) {
        super(MessageFormat.format("Delete person error on SQL level with message: {0}", message));
    }
}
