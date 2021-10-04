package nl.bos;

import com.vaadin.flow.component.notification.Notification;

import java.util.*;

public class VaadinPersonPresenter {
    private final VaadinPersonView personView;
    private final VaadinPersonModel personModel;

    public VaadinPersonPresenter(final VaadinPersonModel personModel, final VaadinPersonView personView) {
        this.personView = personView;
        this.personModel = personModel;

        personModel.setPersonPresenter(this);
        personView.setPersonPresenter(this);
    }

    void error(final String message) {
        Notification.show("ERROR: " + message, 3000, Notification.Position.MIDDLE);
    }

    void inform(final String message) {
        Notification.show(message, 3000, Notification.Position.MIDDLE);
    }

    void clearForm() {
        personView.getTxtId().setValue("");
        personView.getTxtName().setValue("");
        personView.getTxtAge().setValue("");
        personView.getInterests().clear();
        personView.getLbInterests().setItems(personView.getInterests());
    }

    void addInterest() {
        List<String> randomInterests = Arrays.asList("Read a book", "Play a game", "Running around", "Cycle along", "Drive at speet");
        int min = 0;
        int max = 4;
        String interest = randomInterests.get(new Random().nextInt(max - min + 1) + min);
        personView.getInterests().add(interest);
        personView.getLbInterests().setItems(personView.getInterests());
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

    void updateTable() {
        personView.getPersons().setItems(personModel.getPersons());
    }

    void createPerson() {
        personModel.createPerson();
    }

    void savePerson() {
        personModel.savePerson();
    }

    void deletePerson() {
        personModel.deletePerson();
    }

    long getPersonId() {
        return Long.parseLong(personView.getTxtId().getValue());
    }

    void disableDeleteButton() {
        personView.getBtnDelete().setEnabled(false);
    }

    String getPersonName() {
        return personView.getTxtName().getValue();
    }

    int getPersonAge() {
        return Integer.parseInt(personView.getTxtAge().getValue());
    }

    Set<String> getPersonInterests() {
        return new HashSet<>(personView.getInterests());
    }
}