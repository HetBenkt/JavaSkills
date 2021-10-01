package nl.bos;

import com.vaadin.flow.component.notification.Notification;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VaadinPersonPresenter {
    private final VaadinPersonView personView;

    public VaadinPersonPresenter(VaadinPersonModel personModel, VaadinPersonView personView) {
        this.personView = personView;

        //personModel.setPersonView(personView); //todo should use model change events through presenter!!?
        personModel.setPersonPresenter(this);

        //personView.setPersonModel(personModel); //todo should use user change events through presenter!!?
        personView.setPersonPresenter(this);
    }

    static void error(String message) {
        Notification.show("ERROR: " + message, 3000, Notification.Position.MIDDLE);
    }

    static void inform(String message) {
        Notification.show(message, 3000, Notification.Position.MIDDLE);
    }

    void clearForm() {
        personView.getTxtId().setValue("");
        personView.getTxtName().setValue("");
        personView.getTxtAge().setValue("");
        personView.getInterests().clear();
        personView.getLbInterests().setItems(personView.getInterests());
    }

    void addInterest() {
        List<String> randomInterests = Arrays.asList("Read a book", "Play a game", "Running around", "Cycle along", "Drive at speet");
        int min = 0;
        int max = 4;
        String interest = randomInterests.get(new Random().nextInt(max - min + 1) + min);
        personView.getInterests().add(interest);
        personView.getLbInterests().setItems(personView.getInterests());
    }
}
