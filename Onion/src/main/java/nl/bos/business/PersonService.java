package nl.bos.business;

import nl.bos.data.IPersonDAO;
import nl.bos.data.PersonDAO;
import nl.bos.data.PersonDTO;

import java.sql.SQLException;
import java.util.List;

public class PersonService implements IPersonService {

    private final IPersonDAO personDAO;

    public PersonService() {
        personDAO = new PersonDAO();
    }

    public boolean create(PersonDTO person) throws SQLException {
        return personDAO.create(person);
    }

    @Override
    public List<PersonDTO> getAll() throws SQLException {
        return personDAO.getAll();
    }
}
