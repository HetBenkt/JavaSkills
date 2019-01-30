package nl.bos.trading;

import lombok.extern.java.Log;

import java.text.MessageFormat;

@Log
public class TradingApp {

    public static void main(String[] args) {
        User user = new User("Jhon Doe", "jhon.doe@gmail.com");
        String msg = MessageFormat.format("User mail: {0}", user.getEmail());
        log.info(msg);

        new UserService().register(user);
    }
}
