package nl.bos;

import com.vaadin.flow.component.grid.Grid;
import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.PersonDTO;
import nl.bos.exceptions.AbstractPersonException;

import java.util.HashSet;

public class VaadinPersonModel {

    private final IPersonService personService = new PersonService();
    private VaadinPersonView personView; //todo remove it and so something via the presenter!!
    private VaadinPersonPresenter personPresenter;

    public void setPersonPresenter(VaadinPersonPresenter personPresenter) {
        this.personPresenter = personPresenter;
    }

    void validateForm() {
        personView.getBtnCreate().setEnabled(!personView.getTxtName().isEmpty() &&
                personView.getTxtAge().getValue().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$") &&
                personView.getTxtId().isEmpty());

        personView.getBtnSave().setEnabled(!personView.getTxtName().isEmpty() &&
                personView.getTxtAge().getValue().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$") &&
                !personView.getTxtId().isEmpty());
        personView.getBtnDelete().setEnabled(!personView.getTxtId().isEmpty());
    }

    void updateTable(Grid<PersonDTO> persons) {
        try {
            persons.setItems(personService.getAll());
        } catch (AbstractPersonException exception) {
            VaadinPersonPresenter.error(exception.getMessage());
        }
    }

    void deletePerson() {
        try {
            if (personService.delete(Long.valueOf(personView.getTxtId().getValue()))) {
                VaadinPersonPresenter.inform("The person was successfully deleted.");
                personPresenter.clearForm();
                updateTable(personView.getPersons());
                personView.getBtnDelete().setEnabled(false);
            }
        } catch (AbstractPersonException exception) {
            VaadinPersonPresenter.error(exception.getMessage());
        }
    }

    void savePerson() {
        PersonDTO person = new PersonDTO(Long.parseLong(personView.getTxtId().getValue()), personView.getTxtName().getValue(), Integer.parseInt(personView.getTxtAge().getValue()), new HashSet<>(personView.getInterests()));
        try {
            if (personService.update(person)) {
                VaadinPersonPresenter.inform("The person was successfully updated.");
                personPresenter.clearForm();
                updateTable(personView.getPersons());
                personView.getBtnDelete().setEnabled(false);
            }
        } catch (AbstractPersonException exception) {
            VaadinPersonPresenter.error(exception.getMessage());
        }
    }

    void createPerson() {
        PersonDTO person = new PersonDTO(
                personView.getTxtName().getValue(),
                Integer.parseInt(personView.getTxtAge().getValue()),
                new HashSet<>(personView.getInterests())
        );

        try {
            if (personService.create(person)) {
                personPresenter.clearForm();
                updateTable(personView.getPersons());
                VaadinPersonPresenter.inform("The person was successfully created.");
            }
        } catch (AbstractPersonException exception) {
            VaadinPersonPresenter.error(exception.getMessage());
        }
    }
}
