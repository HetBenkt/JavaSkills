package nl.bos.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.PersonDTO;

import java.sql.SQLException;
import java.util.Collections;

public class PersonController {
    @FXML
    Button btnSave;
    @FXML
    Button btnClear;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAge;
    @FXML
    TableView<PersonDTO> tblPersons;

    IPersonService personService = new PersonService();

    @FXML
    private void initialize() {
//        TableColumn<PersonDTO, String> firstNameColumn = TableColumn<>("First Name");
//        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        updateTable();

        txtAge.focusedProperty().addListener((observableValue, isOldValue, isNewValue) -> {
            if (!isNewValue) { //when focus lost
                validateForm();
            }
        });
        txtName.focusedProperty().addListener((observableValue, isOldValue, isNewValue) -> {
            if (!isNewValue) { //when focus lost
                validateForm();
            }
        });
    }

    private void updateTable() {
        try {
            tblPersons.getItems().addAll(personService.getAll());
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void validateForm() {
        btnSave.setDisable(
                txtName.getText().isEmpty() ||
                        !txtAge.getText().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$") //1-120
        );
    }

    @FXML
    private void clearForm() {
        txtName.clear();
        txtAge.clear();
    }

    @FXML
    private void savePerson() {
        PersonDTO person = new PersonDTO(
                txtName.getText(),
                Integer.parseInt(txtAge.getText()),
                Collections.emptySet()
        );

        try {
            if (personService.create(person)) {
                clearForm();
                updateTable();
                inform("The person was successfully created.");
            } else {
                //todo error message!?
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void viewPerson(MouseEvent mouseEvent) {
        //todo onclick row implementation
    }

    private void inform(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}