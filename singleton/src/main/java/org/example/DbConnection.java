package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static volatile DbConnection DB_INSTANCE;
    private final Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/todo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1111";

    private DbConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static DbConnection getDbInstance() throws SQLException {
        if (DB_INSTANCE == null) {
            synchronized (DbConnection.class) {
                if (DB_INSTANCE == null) {
                    DB_INSTANCE = new DbConnection();
                }
            }
        }
        return DB_INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
