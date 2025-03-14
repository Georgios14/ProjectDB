package org.example;

import java.sql.*;

public class Connection {

    public java.sql.Connection connect() {

        String url = "jdbc:postgresql://localhost:5432/project";
        String username = "postgres";
        String password = ReadFile.readPasswordFile();

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
