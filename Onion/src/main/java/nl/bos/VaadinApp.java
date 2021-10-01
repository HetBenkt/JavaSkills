package nl.bos;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import nl.bos.data.ConnectionFactory;

import java.util.List;
import java.util.Map;

@Route("")
@PWA(name = "Onion CRUD Vaadin App", shortName = "Vaadin App", enableInstallPrompt = false)
public class VaadinApp extends VerticalLayout implements HasUrlParameter<String> {
    private static final ConnectionFactory connectionFactory = ConnectionFactory.INSTANCE;
    private String username = "";
    private String password = "";
    private String database = "";
    private final VaadinPersonView personView;
    private final VaadinPersonModel personModel;

    //todo create some kind of controller class; like in JavaFX!? https://vaadin.com/docs/v8/framework/advanced/advanced-architecture
    public VaadinApp() {
        personModel = new VaadinPersonModel();
        personView = new VaadinPersonView();
        new VaadinPersonPresenter(personModel, personView);
        add(personView);
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
        personModel.updateTable(personView.getPersons());
    }
}