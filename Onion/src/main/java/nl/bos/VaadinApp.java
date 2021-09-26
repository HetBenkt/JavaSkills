package nl.bos;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import nl.bos.business.IPersonService;
import nl.bos.business.PersonService;
import nl.bos.data.ConnectionFactory;
import nl.bos.data.PersonDTO;
import nl.bos.exceptions.AbstractPersonException;

import java.util.*;

@Route("")
@PWA(name = "Onion CRUD Vaadin App", shortName = "Vaadin App", enableInstallPrompt = false)
public class VaadinApp extends VerticalLayout implements HasUrlParameter<String> {
    private static final ConnectionFactory connectionFactory = ConnectionFactory.INSTANCE;
    private final ListBox<String> lbInterests;
    private final List<String> interests = new ArrayList<>();
    private final TextField txtId;
    private final TextField txtName;
    private final TextField txtAge;
    private final Grid<PersonDTO> persons;
    private final IPersonService personService = new PersonService();
    private final Button btnDelete;
    private final Button btnCreate;
    private final Button btnSave;
    private String username = "";
    private String password = "";
    private String database = "";

    //todo create some kind of controller class; like in JavaFX!? https://vaadin.com/docs/v8/framework/advanced/advanced-architecture
    public VaadinApp() {
        VerticalLayout verticalLayout = new VerticalLayout();

        txtId = new TextField("ID");
        txtId.setEnabled(false);
        txtName = new TextField("Name");
        txtName.addValueChangeListener(e -> validateForm());
        txtAge = new TextField("Age");
        txtAge.addValueChangeListener(e -> validateForm());
        lbInterests = new ListBox<>();

        Button btnAddInterest = new Button("Add interest");
        btnAddInterest.addClickListener(this::addInterest);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        btnCreate = new Button("Create");
        btnCreate.setEnabled(false);
        btnCreate.addClickListener(this::createPerson);

        btnSave = new Button("Save");
        btnSave.setEnabled(false);
        btnSave.addClickListener(this::savePerson);
        btnDelete = new Button("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addClickListener(this::deletePerson);

        Button btnClear = new Button("Clear");
        btnClear.addClickListener(this::clearForm);

        horizontalLayout.add(btnCreate, btnClear, btnSave, btnDelete);

        verticalLayout.add(txtId, txtName, txtAge, lbInterests, btnAddInterest, horizontalLayout);

        persons = new Grid<>(PersonDTO.class);
        persons.asSingleSelect();
        persons.addSelectionListener(selectionEvent -> {
            Optional<PersonDTO> selectedItem = selectionEvent.getFirstSelectedItem();
            selectedItem.ifPresent(personDTO -> {
                txtId.setValue(String.valueOf(personDTO.getId()));
                txtName.setValue(personDTO.getName());
                txtAge.setValue(String.valueOf(personDTO.getAge()));
                interests.clear();
                interests.addAll(personDTO.getInterests());
                lbInterests.setItems(interests);
                btnDelete.setEnabled(true);
            });
        });

        add(verticalLayout, persons);
    }

    private void validateForm() {
        btnCreate.setEnabled(!txtName.isEmpty() &&
                txtAge.getValue().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$") &&
                txtId.isEmpty());

        btnSave.setEnabled(!txtName.isEmpty() &&
                txtAge.getValue().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$") &&
                !txtId.isEmpty());
        btnDelete.setEnabled(!txtId.isEmpty());
    }

    private void deletePerson(ClickEvent<Button> buttonClickEvent) {
        try {
            if (personService.delete(Long.valueOf(txtId.getValue()))) {
                inform("The person was successfully deleted.");
                clearForm(null);
                updateTable();
                btnDelete.setEnabled(false);
            }
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    private void savePerson(ClickEvent<Button> buttonClickEvent) {
        PersonDTO person = new PersonDTO(Long.parseLong(txtId.getValue()), txtName.getValue(), Integer.parseInt(txtAge.getValue()), new HashSet<>(interests));
        try {
            if (personService.update(person)) {
                inform("The person was successfully updated.");
                clearForm(null);
                updateTable();
                btnDelete.setEnabled(false);
            }
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    private void createPerson(ClickEvent<Button> buttonClickEvent) {
        PersonDTO person = new PersonDTO(
                txtName.getValue(),
                Integer.parseInt(txtAge.getValue()),
                new HashSet<>(interests)
        );

        try {
            if (personService.create(person)) {
                clearForm(null);
                updateTable();
                inform("The person was successfully created.");
            }
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    private void updateTable() {
        try {
            persons.setItems(personService.getAll());
        } catch (AbstractPersonException exception) {
            error(exception.getMessage());
        }
    }

    private void error(String message) {
        Notification.show("ERROR: " + message, 3000, Notification.Position.MIDDLE);
    }

    private void inform(String message) {
        Notification.show(message, 3000, Notification.Position.MIDDLE);
    }

    private void clearForm(ClickEvent<Button> buttonClickEvent) {
        txtId.setValue("");
        txtName.setValue("");
        txtAge.setValue("");
        interests.clear();
        lbInterests.setItems(interests);
    }

    private void addInterest(ClickEvent<Button> buttonClickEvent) {
        List<String> randomInterests = Arrays.asList("Read a book", "Play a game", "Running around", "Cycle along", "Drive at speet");
        int min = 0;
        int max = 4;
        String interest = randomInterests.get(new Random().nextInt(max - min + 1) + min);
        interests.add(interest);
        lbInterests.setItems(interests);
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        //http://localhost:8080?username=value1&password=value2&database=value3
        Map<String, List<String>> parametersMap =
                event.getLocation().getQueryParameters().getParameters();

        for (var entry : parametersMap.entrySet()) {
            if (entry.getKey().equals("password")) {
                password = entry.getValue().get(0);
            } else if (entry.getKey().equals("username")) {
                username = entry.getValue().get(0);
            }
            if (entry.getKey().equals("database")) {
                database = entry.getValue().get(0);
            }
        }

        connectionFactory.setInstanceVariables(username, password, database);
        updateTable();
    }
}