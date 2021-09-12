package nl.bos.business;

import nl.bos.data.PersonDTO;
import nl.bos.exceptions.PersonException;

import java.sql.SQLException;
import java.util.List;

public interface IPersonService {

    boolean create(PersonDTO person) throws PersonException;

    PersonDTO read(Long id) throws SQLException;

    boolean update(PersonDTO person) throws SQLException;

    boolean delete(Long id) throws SQLException;

    List<PersonDTO> getAll() throws SQLException;
}
