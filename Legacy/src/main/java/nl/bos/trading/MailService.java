package nl.bos.trading;

import java.text.MessageFormat;

public class MailService {
    private final String hostname;
    private final int port;
    private final String username;

    public MailService(String hostname, int port, String username) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public void sentWelcomeMail(User user) {
        String msg = MessageFormat.format("Sending out a mail to {0} via {1}:{2}", user.getEmail(), this.hostname, this.port);
        System.out.println(msg);
    }
}
