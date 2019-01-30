package nl.bos.trading;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.text.MessageFormat;

@Data
@AllArgsConstructor
@Log
public class MailService {
    private final String hostname;
    private final int port;
    private final String username;

    public void sentWelcomeMail(User user) {
        String msg = MessageFormat.format("Sending out a mail to {0} via {1}:{2}", user.getEmail(), this.hostname, this.port);
        log.info(msg);
    }
}
