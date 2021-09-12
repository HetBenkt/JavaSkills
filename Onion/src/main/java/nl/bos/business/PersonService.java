package nl.bos.business;

import nl.bos.data.IPersonDAO;
import nl.bos.data.PersonDAO;
import nl.bos.data.PersonDTO;
import nl.bos.exceptions.PersonException;

import java.sql.SQLException;
import java.util.List;

public class PersonService implements IPersonService {

    private final IPersonDAO personDAO;

    public PersonService() {
        personDAO = new PersonDAO();
    }

    public boolean create(PersonDTO person) throws PersonException {
        return personDAO.create(person);
    }

    @Override
    public PersonDTO read(Long id) throws SQLException {
        return personDAO.read(id);
    }

    @Override
    public boolean update(PersonDTO person) throws SQLException {
        return personDAO.update(person);
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return personDAO.delete(id);
    }

    @Override
    public List<PersonDTO> getAll() throws SQLException {
        return personDAO.getAll();
    }
}
