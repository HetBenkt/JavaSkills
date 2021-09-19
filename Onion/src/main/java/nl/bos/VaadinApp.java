package nl.bos;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Onion CRUD Vaadin App", shortName = "Vaadin App", enableInstallPrompt = false)
public class VaadinApp extends VerticalLayout {
    public VaadinApp() {
        TextField textField = new TextField("Name");
        Button button = new Button("Say hello");
        add(textField, button);
    }
}
