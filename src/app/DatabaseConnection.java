package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    // Constructor is private to prevent instantiation
    private DatabaseConnection() {
        try {
            // Example of creating a connection to a MySQL database
            String url = "jdbc:mysql://localhost:3306/library_db";
            String user = "root";
            String password = "password";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to return the single instance of the DatabaseConnection
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Method to return the connection object
    public Connection getConnection() {
        return connection;
    }
}
