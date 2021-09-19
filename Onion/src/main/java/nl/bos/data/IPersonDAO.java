package nl.bos.data;

import nl.bos.exceptions.PersonCreateException;

import java.sql.SQLException;
import java.util.List;

public interface IPersonDAO {
    boolean create(PersonDTO person) throws PersonCreateException;

    PersonDTO read(Long id) throws SQLException;

    boolean update(PersonDTO person) throws SQLException;

    boolean delete(Long id) throws SQLException;

    List<PersonDTO> getAll() throws SQLException;

    List<PersonDTO> getAllFiltered(String filter) throws SQLException;
}
