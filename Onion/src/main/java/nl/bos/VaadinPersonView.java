package nl.bos;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import nl.bos.data.PersonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VaadinPersonView extends VerticalLayout {

    private final ListBox<String> lbInterests;
    private final List<String> interests = new ArrayList<>();
    private final TextField txtId;
    private final TextField txtName;
    private final TextField txtAge;
    private final Grid<PersonDTO> persons;
    private final Button btnDelete;
    private final Button btnCreate;
    private final Button btnSave;
    private VaadinPersonPresenter personPresenter;

    public VaadinPersonView() {
        VerticalLayout verticalLayout = new VerticalLayout();

        txtId = new TextField("ID");
        txtId.setEnabled(false);
        txtName = new TextField("Name");
        txtName.addValueChangeListener(e -> personPresenter.validateForm());
        txtAge = new TextField("Age");
        txtAge.addValueChangeListener(e -> personPresenter.validateForm());
        lbInterests = new ListBox<>();

        Button btnAddInterest = new Button("Add interest");
        btnAddInterest.addClickListener(e -> personPresenter.addInterest());

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        btnCreate = new Button("Create");
        btnCreate.setEnabled(false);
        btnCreate.addClickListener(e -> personPresenter.createPerson());

        btnSave = new Button("Save");
        btnSave.setEnabled(false);
        btnSave.addClickListener(e -> personPresenter.savePerson());
        btnDelete = new Button("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addClickListener(e -> personPresenter.deletePerson());

        Button btnClear = new Button("Clear");
        btnClear.addClickListener(e -> personPresenter.clearForm());

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

    public void setPersonPresenter(VaadinPersonPresenter personPresenter) {
        this.personPresenter = personPresenter;
    }

    public Grid<PersonDTO> getPersons() {
        return persons;
    }

    public List<String> getInterests() {
        return interests;
    }

    public TextField getTxtId() {
        return txtId;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public TextField getTxtAge() {
        return txtAge;
    }

    public ListBox<String> getLbInterests() {
        return lbInterests;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public Button getBtnCreate() {
        return btnCreate;
    }

    public Button getBtnSave() {
        return btnSave;
    }
}