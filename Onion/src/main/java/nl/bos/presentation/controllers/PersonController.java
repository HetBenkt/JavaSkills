package nl.bos.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.PersonDTO;
import nl.bos.exceptions.AbstractPersonException;

import java.util.HashSet;

public class PersonController {
    @FXML
    Button btnSave;
    @FXML
    Button btnClear;
    @FXML
    Button btnDelete;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAge;
    @FXML
    ListView<String> lvInterests;

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
        txtEditAge.focusedProperty().addListener((observableValue, isOldValue, isNewValue) -> {
            if (!isNewValue) { //when focus lost
                validateForm();
            }
        });
        txtEditName.focusedProperty().addListener((observableValue, isOldValue, isNewValue) -> {
            if (!isNewValue) { //when focus lost
                validateForm();
            }
        });
        lvInterests.setCellFactory(TextFieldListCell.forListView());
        lvEditInterests.setCellFactory(TextFieldListCell.forListView());
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
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    private void validateForm() {
        btnSave.setDisable(
                txtName.getText().isEmpty() ||
                        !txtAge.getText().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$") //1-120
        );
        btnEditSave.setDisable(
                txtEditName.getText().isEmpty() ||
                        !txtEditAge.getText().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$") //1-120
        );
    }

    @FXML
    private void clearForm() {
        txtName.clear();
        txtAge.clear();
        lvInterests.getItems().clear();
    }

    private void clearEditForm() {
        txtEditId.clear();
        txtEditName.clear();
        txtEditAge.clear();
        lvEditInterests.getItems().clear();
    }

    @FXML
    private void savePerson() {
        PersonDTO person = new PersonDTO(
                txtName.getText(),
                Integer.parseInt(txtAge.getText()),
                new HashSet<>(lvInterests.getItems())
        );

        try {
            if (personService.create(person)) {
                clearForm();
                updateTable();
                inform("The person was successfully created.");
            }
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    @FXML
    private void viewPerson(MouseEvent mouseEvent) {
        TableView.TableViewSelectionModel<PersonDTO> selectionModel = tblPersons.getSelectionModel();
        PersonDTO selectedPerson = selectionModel.getSelectedItem();

        if (selectedPerson != null) {
            btnDelete.setDisable(false);
            try {
                PersonDTO person = personService.read(selectedPerson.getId()); //Retrieve latest data from database; instead of current table data!
                txtEditId.setText(String.valueOf(person.getId()));
                txtEditName.setText(person.getName());
                txtEditAge.setText(String.valueOf(person.getAge()));
                lvEditInterests.getItems().clear();
                lvEditInterests.getItems().addAll(person.getInterests());
            } catch (AbstractPersonException exception) {
                error(exception.getMessage());
            }
        }
    }

    public void saveEditPerson(ActionEvent actionEvent) {
        PersonDTO person = new PersonDTO(Long.parseLong(txtEditId.getText()), txtEditName.getText(), Integer.parseInt(txtEditAge.getText()), new HashSet<>(lvEditInterests.getItems()));
        try {
            if (personService.update(person)) {
                inform("The person was successfully updated.");
                clearEditForm();
                updateTable();
                btnDelete.setDisable(true);
            }
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    @FXML
    private void deletePerson(ActionEvent actionEvent) {
        try {
            if (personService.delete(Long.valueOf(txtEditId.getText()))) {
                inform("The person was successfully deleted.");
                clearEditForm();
                updateTable();
            }
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    @FXML
    private void addInterest(ActionEvent actionEvent) {
        lvInterests.getItems().add(0, "");
    }

    @FXML
    private void updateInterests(ListView.EditEvent<String> stringEditEvent) {
        lvInterests.getItems().add(stringEditEvent.getNewValue());
        lvInterests.getItems().remove("");
    }

    @FXML
    private void addEditInterest(ActionEvent actionEvent) {
        lvEditInterests.getItems().add(0, "");
    }

    public void updateEditInterests(ListView.EditEvent<String> stringEditEvent) {
        lvEditInterests.getItems().add(stringEditEvent.getNewValue());
        lvEditInterests.getItems().remove("");
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
}