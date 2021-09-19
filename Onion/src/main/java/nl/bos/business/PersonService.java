package nl.bos.business;

import nl.bos.data.IPersonDAO;
import nl.bos.data.PersonDAO;
import nl.bos.data.PersonDTO;
import nl.bos.exceptions.*;

import java.util.List;

public class PersonService implements IPersonService {

    private final IPersonDAO personDAO;

    public PersonService() {
        personDAO = new PersonDAO();
    }

    public boolean create(PersonDTO person) throws PersonCreateException {
        return personDAO.create(person);
    }

    @Override
    public PersonDTO read(Long id) throws PersonReadException {
        return personDAO.read(id);
    }

    @Override
    public boolean update(PersonDTO person) throws PersonUpdateException {
        return personDAO.update(person);
    }

    @Override
    public boolean delete(Long id) throws PersonDeleteException {
        return personDAO.delete(id);
    }

    @Override
    public List<PersonDTO> getAll() throws PersonException {
        return personDAO.getAll();
    }
}
