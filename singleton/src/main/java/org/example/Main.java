package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnection dbConnection = DbConnection.getDbInstance();
        Statement statement = dbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM task";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String tech_id = resultSet.getString("tech_id");
            String title = resultSet.getString("task_title");
            LocalDate date = resultSet.getDate("deadline").toLocalDate();
            boolean status = resultSet.getBoolean("status");
            System.out.println(id + " " + tech_id + " " + title + " " + date + " " + status);
        }

        statement.close();
    }
}