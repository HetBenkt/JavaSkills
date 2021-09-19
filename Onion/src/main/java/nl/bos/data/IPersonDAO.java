package nl.bos.data;

import nl.bos.exceptions.*;

import java.util.List;

public interface IPersonDAO {
    boolean create(PersonDTO person) throws PersonCreateException;

    PersonDTO read(Long id) throws PersonReadException;

    boolean update(PersonDTO person) throws PersonUpdateException;

    boolean delete(Long id) throws PersonDeleteException;

    List<PersonDTO> getAll() throws PersonException;

    List<PersonDTO> getAllFiltered(String filter) throws PersonException;
}
