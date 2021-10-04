package nl.bos.business;

import nl.bos.data.PersonDTO;
import nl.bos.exceptions.*;

import java.util.List;

public interface IPersonService {

    boolean create(final PersonDTO person) throws PersonCreateException;

    PersonDTO read(final Long id) throws PersonReadException;

    boolean update(final PersonDTO person) throws PersonUpdateException;

    boolean delete(final Long id) throws PersonDeleteException;

    List<PersonDTO> getAll() throws PersonException;

    List<PersonDTO> getAllFiltered(final String filter) throws PersonException;
}
