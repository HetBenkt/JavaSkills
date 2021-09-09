package nl.bos.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    //todo add @FXML ListView<String> lvInterests;

    @FXML
    Button btnEditSave;
    @FXML
    TextField txtEditId;
    @FXML
    TextField txtEditName;
    @FXML
    TextField txtEditAge;
    @FXML
    ListView<String> lvEditInterests;
    @FXML
    TableView<PersonDTO> tblPersons;

    IPersonService personService = new PersonService();

    @FXML
    private void initialize() {
        initTable();
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

    private void initTable() {
        tblPersons.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<PersonDTO, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<PersonDTO, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<PersonDTO, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<PersonDTO, String> interestsColumn = new TableColumn<>("Interests");
        interestsColumn.setCellValueFactory(new PropertyValueFactory<>("interests"));

        tblPersons.getColumns().add(idColumn);
        tblPersons.getColumns().add(nameColumn);
        tblPersons.getColumns().add(ageColumn);
        tblPersons.getColumns().add(interestsColumn);
    }

    private void updateTable() {
        try {
            tblPersons.getItems().clear();
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
                Collections.emptySet() //todo add interests field
        );

        try {
            if (personService.create(person)) {
                clearForm();
                updateTable();
                inform("The person was successfully created.");
            }
        } catch (SQLException exception) {
            error(exception.getMessage());
        }
    }

    @FXML
    private void viewPerson(MouseEvent mouseEvent) {
        TableView.TableViewSelectionModel<PersonDTO> selectionModel = tblPersons.getSelectionModel();
        PersonDTO selectedPerson = selectionModel.getSelectedItem();

        if (selectedPerson != null) {
            try {
                PersonDTO person = personService.read(selectedPerson.getId()); //not required, but now we call a CRUD service! Because we can!
                txtEditId.setText(String.valueOf(person.getId()));
                txtEditName.setText(person.getName());
                txtEditAge.setText(String.valueOf(person.getAge()));
                lvEditInterests.getItems().clear();
                lvEditInterests.getItems().addAll(person.getInterests());
            } catch (SQLException exception) {
                error(exception.getMessage());
            }

        }
    }

    private void inform(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void error(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public void saveEditPerson(ActionEvent actionEvent) {
        //todo implementation; after save show an inform message
    }
}