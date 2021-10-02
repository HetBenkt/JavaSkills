package nl.bos;

import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.PersonDTO;
import nl.bos.exceptions.AbstractPersonException;

import java.util.Collections;
import java.util.List;

public class VaadinPersonModel {

    private final IPersonService personService = new PersonService();
    private VaadinPersonPresenter personPresenter;

    public void setPersonPresenter(VaadinPersonPresenter personPresenter) {
        this.personPresenter = personPresenter;
    }

    List<PersonDTO> getPersons() {
        try {
            return personService.getAll();
        } catch (AbstractPersonException exception) {
            personPresenter.error(exception.getMessage());
        }
        return Collections.emptyList();
    }

    void deletePerson() {
        try {
            if (personService.delete(personPresenter.getPersonId())) {
                personPresenter.inform("The person was successfully deleted.");
                personPresenter.clearForm();
                personPresenter.updateTable();
                personPresenter.disableDeleteButton();
            }
        } catch (AbstractPersonException exception) {
            personPresenter.error(exception.getMessage());
        }
    }

    void savePerson() {
        PersonDTO person = new PersonDTO(personPresenter.getPersonId(), personPresenter.getPersonName(), personPresenter.getPersonAge(), personPresenter.getPersonInterests());
        try {
            if (personService.update(person)) {
                personPresenter.inform("The person was successfully updated.");
                personPresenter.clearForm();
                personPresenter.updateTable();
                personPresenter.disableDeleteButton();
            }
        } catch (AbstractPersonException exception) {
            personPresenter.error(exception.getMessage());
        }
    }

    void createPerson() {
        PersonDTO person = new PersonDTO(
                personPresenter.getPersonName(),
                personPresenter.getPersonAge(),
                personPresenter.getPersonInterests()
        );

        try {
            if (personService.create(person)) {
                personPresenter.clearForm();
                personPresenter.updateTable();
                personPresenter.inform("The person was successfully created.");
            }
        } catch (AbstractPersonException exception) {
            personPresenter.error(exception.getMessage());
        }
    }
}