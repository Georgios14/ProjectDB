package org.example;

import java.sql.*;

public class SqlCommands {

    public static void getRow(int id) throws SQLException {

        String sql = "SELECT name FROM names WHERE id=" + id + ";";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        System.out.println(name);

        con.close();

    }

    public static void getTable() throws SQLException {

        String sql = "SELECT * FROM names;";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        System.out.println(name);

        con.close();

    }

    public static void insertRow(String data) throws SQLException {

        String sql = "INSERT INTO names (name) VALUES ('" + data + "');";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        con.close();

    }

}
