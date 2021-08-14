package nl.bos.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost/test"; //TODO bring up a real database!?
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";
    public static final ConnectionFactory INSTANCE = new ConnectionFactory();
    private Connection connection;


    private ConnectionFactory() {
        super(); //Singleton protected
    }

    public static ConnectionFactory getInstance() {
        return INSTANCE;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                props.setProperty("user", USERNAME);
                props.setProperty("password", PASSWORD);
                props.setProperty("ssl", "false");
                //Class.forName("");
                //DriverManager.registerDriver(null);
                connection = DriverManager.getConnection(URL, props);
            } catch (SQLException ex) {
                throw new RuntimeException("Error connecting to the database", ex);
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                throw new RuntimeException("Error closing database connection", ex);
            }
        }
    }
}