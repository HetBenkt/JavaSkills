package nl.bos.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.PersonDTO;
import nl.bos.exceptions.AbstractPersonException;

import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PersonController {
    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private ListView<String> lvInterests;

    @FXML
    private Button btnEditSave;
    @FXML
    private TextField txtEditId;
    @FXML
    private TextField txtEditName;
    @FXML
    private TextField txtEditAge;
    @FXML
    private ListView<String> lvEditInterests;
    @FXML
    private TableView<PersonDTO> tblPersons;
    @FXML
    private TextField txtFilter;

    IPersonService personService = PersonService.INSTANCE;

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
            Supplier<List<PersonDTO>> readAll = () -> personService.getAll();
            tblPersons.getItems().addAll(readAll.get());
        } catch (AbstractPersonException exception) {
            Consumer<String> error = this::error;
            error.accept(exception.getMessage());
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
        btnSave.setDisable(true);
    }

    private void clearEditForm() {
        txtEditId.clear();
        txtEditName.clear();
        txtEditAge.clear();
        lvEditInterests.getItems().clear();
        btnEditSave.setDisable(true);
        btnDelete.setDisable(true);
    }

    @FXML
    private void savePerson() {
        PersonDTO person = new PersonDTO(
                txtName.getText(),
                Integer.parseInt(txtAge.getText()),
                new HashSet<>(lvInterests.getItems())
        );

        try {
            Predicate<PersonDTO> create = personDTO -> personService.create(personDTO);
            if (create.test(person)) {
                clearForm();
                updateTable();
                Consumer<String> inform = this::inform;
                inform.accept("The person was successfully created.");
            }
        } catch (AbstractPersonException exception) {
            Consumer<String> error = this::error;
            error.accept(exception.getMessage());
        }
    }

    @FXML
    private void viewPerson() {
        TableView.TableViewSelectionModel<PersonDTO> selectionModel = tblPersons.getSelectionModel();
        PersonDTO selectedPerson = selectionModel.getSelectedItem();

        if (selectedPerson != null) {
            btnDelete.setDisable(false);
            try {
                Function<Long, PersonDTO> read = personId -> personService.read(personId);
                PersonDTO person = read.apply(selectedPerson.getId()); //Retrieve latest data from database; instead of current table data!
                txtEditId.setText(String.valueOf(person.getId()));
                txtEditName.setText(person.getName());
                txtEditAge.setText(String.valueOf(person.getAge()));
                lvEditInterests.getItems().clear();
                lvEditInterests.getItems().addAll(person.getInterests());
            } catch (AbstractPersonException exception) {
                Consumer<String> error = this::error;
                error.accept(exception.getMessage());
            }
        }
    }

    public void saveEditPerson() {
        PersonDTO person = new PersonDTO(Long.parseLong(txtEditId.getText()), txtEditName.getText(), Integer.parseInt(txtEditAge.getText()), new HashSet<>(lvEditInterests.getItems()));
        try {
            Predicate<PersonDTO> update = personDTO -> personService.update(personDTO);
            if (update.test(person)) {
                clearEditForm();
                updateTable();
                btnDelete.setDisable(true);
                Consumer<String> inform = this::inform;
                inform.accept("The person was successfully updated.");
            }
        } catch (AbstractPersonException exception) {
            Consumer<String> error = this::error;
            error.accept(exception.getMessage());
        }
    }

    @FXML
    private void deletePerson() {
        try {
            Predicate<Long> delete = personId -> personService.delete(personId);
            if (delete.test(Long.valueOf(txtEditId.getText()))) {
                clearEditForm();
                updateTable();
                btnDelete.setDisable(true);
                Consumer<String> inform = this::inform;
                inform.accept("The person was successfully deleted.");
            }
        } catch (AbstractPersonException exception) {
            Consumer<String> error = this::error;
            error.accept(exception.getMessage());
        }
    }

    @FXML
    private void addInterest() {
        lvInterests.getItems().add(0, "");
    }

    @FXML
    private void updateInterests(final ListView.EditEvent<String> stringEditEvent) {
        lvInterests.getItems().add(stringEditEvent.getNewValue());
        lvInterests.getItems().remove("");
    }

    @FXML
    private void addEditInterest() {
        lvEditInterests.getItems().add(0, "");
    }

    @FXML
    private void updateEditInterests(ListView.EditEvent<String> stringEditEvent) {
        lvEditInterests.getItems().add(stringEditEvent.getNewValue());
        lvEditInterests.getItems().remove("");
    }

    @FXML
    private void filterPersons() {
        tblPersons.getItems().clear();
        Function<String, List<PersonDTO>> readAllFiltered = filter -> personService.getAllFiltered(filter);
        tblPersons.getItems().addAll(readAllFiltered.apply(txtFilter.getText()));
    }


    private void inform(final String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void error(final String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}