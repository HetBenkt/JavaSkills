package nl.bos.vaadincrud;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    private final IAccountService accountService = EAccountService.INSTANCE;

    public MainView() {
        add(new Button("Click me", e -> Notification.show("Hello, Spring+Vaadin user!")));
        add(new Button("Click me", e -> accountService.getAccount()));
    }
}
