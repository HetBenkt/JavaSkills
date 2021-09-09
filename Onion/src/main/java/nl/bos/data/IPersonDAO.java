package nl.bos.data;

import java.sql.SQLException;
import java.util.List;

public interface IPersonDAO {
    boolean create(PersonDTO person) throws SQLException;

    PersonDTO read(Long id) throws SQLException;

    boolean update(PersonDTO person) throws SQLException;

    boolean delete(PersonDTO person) throws SQLException;

    List<PersonDTO> getAll() throws SQLException;
}
