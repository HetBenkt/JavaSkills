package nl.bos.data;

import java.sql.SQLException;
import java.util.List;

public interface IPersonDAO {
    boolean create(PersonDTO person) throws SQLException;

    PersonDTO read(Long id);

    boolean update(PersonDTO person);

    boolean delete(PersonDTO person);

    List<PersonDTO> getAll() throws SQLException;
}
