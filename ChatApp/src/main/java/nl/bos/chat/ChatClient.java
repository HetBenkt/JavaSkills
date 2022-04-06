package nl.bos.chat;

import nl.bos.chat.exception.ChatException;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatClient {

    private static final Logger LOGGER = Logger.getLogger(ChatClient.class.getName());

    private final String host;
    private final int port;

    private ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("localhost", 81);
        try {
            chatClient.run();
        } catch (IOException e) {
            throw new ChatException(e);
        }
    }

    private void run() throws IOException {
        try (Socket socket = new Socket(host, port)) {
            LOGGER.log(Level.INFO, "Connected to the chat server");
        }
    }
}