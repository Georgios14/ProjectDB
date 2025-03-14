package org.example;

import java.sql.*;

public class SqlCommands {


    public static void getRecord(int id) throws SQLException {

        String sql = "SELECT name FROM people WHERE id=" + id + ";";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        String age = rs.getString(2);
        System.out.println(name+" "+age);

        con.close();

    }

    public static void getAllRecords() throws SQLException {

        int id = 1;
        String sql = "SELECT FROM names WHERE id=" + id + ";";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();
        Statement st = con.createStatement();

        while (id<return_id()){

            ResultSet rs = st.executeQuery(sql);
            rs.next();
            String name = rs.getString(1);
            System.out.println(name);
            
            id++;
        }

        con.close();

    }

    public static int insertRecord(String data) throws SQLException {

        String sql = "INSERT INTO people VALUES ( " + data + ");";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        con.close();

        return return_id();

    }

    public static int return_id() throws SQLException{

        String getLastId = "SELECT TOP 1 * FROM Table ORDER BY ID DESC";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet id = st.executeQuery(getLastId);
        String idString = id.getString(1);
        int idInt = Integer.parseInt(idString);

        con.close();

        return idInt;

    }

}
