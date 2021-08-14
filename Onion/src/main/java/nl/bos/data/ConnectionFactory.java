package nl.bos.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum ConnectionFactory {
    INSTANCE; //singleton from "Effective Java" book...nice!

    private Connection connection;
    private String username, password, database;

    public void setInstanceVariables(String username, String password, String database) {
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                Properties props = new Properties();
                props.setProperty("user", username);
                props.setProperty("password", password);
                props.setProperty("ssl", "false");
                connection = DriverManager.getConnection(String.format("jdbc:postgresql://tai.db.elephantsql.com/%s", database), props);
            } catch (SQLException ex) {
                throw new RuntimeException("Error connecting to the database", ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException("Error loading the driver", ex);
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