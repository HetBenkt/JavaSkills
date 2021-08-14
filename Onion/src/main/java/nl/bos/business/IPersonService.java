package nl.bos.business;

import nl.bos.data.PersonDTO;

import java.sql.SQLException;

public interface IPersonService {

    boolean create(PersonDTO person) throws SQLException;
}
