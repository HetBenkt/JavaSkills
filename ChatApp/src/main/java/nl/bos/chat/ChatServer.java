package nl.bos.chat;

import nl.bos.chat.exception.ChatException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {

    private static final Logger LOGGER = Logger.getLogger(ChatServer.class.getName());

    private final int port;

    private ChatServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer(81);
        try {
            server.run();
        } catch (IOException e) {
            throw new ChatException(e);
        }
    }

    private void run() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            String message = String.format("Listening on port: %s, host: %s", port, serverSocket.getInetAddress().getHostName());
            LOGGER.log(Level.INFO, message);

            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.log(Level.INFO, "Connection is made!");
            }
        }
    }
}
