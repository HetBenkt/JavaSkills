package nl.bos.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.PersonDTO;

import java.sql.SQLException;

public class SampleController {
    @FXML
    Button btnSave;
    @FXML
    Button btnClear;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAge;

    IPersonService personService = new PersonService();

    @FXML
    private void initialize() {
        txtAge.focusedProperty().addListener((observableValue, isOldValue, isNewValue) -> {
            if (!isNewValue) { //when focus lost
                btnSave.setDisable(!txtAge.getText().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$")); //1-120
            }
        });
    }

    @FXML
    private void clearForm(ActionEvent actionEvent) {
        txtName.clear();
        txtAge.clear();
    }

    @FXML
    private void savePerson(ActionEvent actionEvent) {
        PersonDTO person = new PersonDTO();
        person.setName(txtName.getText());
        person.setAge(Integer.parseInt(txtAge.getText()));
        try {
            personService.create(person);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}