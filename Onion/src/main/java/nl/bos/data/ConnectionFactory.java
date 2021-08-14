package nl.bos.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost/test"; //TODO bring up a real database!?
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {
        try {
            Properties props = new Properties();
            props.setProperty("user", USERNAME);
            props.setProperty("password", PASSWORD);
            props.setProperty("ssl", "false");
            return DriverManager.getConnection(URL, props);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void release(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Error closing database connection", ex);
        }
    }
}