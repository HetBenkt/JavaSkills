package nl.bos.trading;

import java.text.MessageFormat;

public class TradingApp {

    public static void main(String[] args) {
        User user = new User("Jhon Doe", "jhon.doe@gmail.com");
        String msg = MessageFormat.format("User mail: {0}", user.getEmail());
        System.out.println(msg);

        new UserService().register(user);
    }
}
