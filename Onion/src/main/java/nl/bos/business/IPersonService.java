package nl.bos.business;

import nl.bos.data.PersonDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPersonService {

    boolean create(PersonDTO person) throws SQLException;

    List<PersonDTO> getAll() throws SQLException;
}
