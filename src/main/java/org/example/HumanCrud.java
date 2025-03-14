package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class HumanCrud implements CrudRepository{


    @Override
    public Human getHumanById(Integer id) throws SQLException {

        String sql = "SELECT name,age,comment FROM people WHERE id=" + id + ";";

        //Creates connection
        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        //Executes sql query
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();

        //Saves data in data class object and returns it
        return new Human(id,rs.getString(1),rs.getInt(2),rs.getString(3));
    }

    @Override
    public List<Human> getAllHumans() {
        return List.of();
    }

    @Override
    public Human createHuman(Human human) throws SQLException {
        String sql = "INSERT INTO people (name, age, comment) VALUES ('" +
                human.getName() + "','" + human.getAge() + "','" + human.getComment() + "') RETURNING id;";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();

        human.setId(rs.getInt(1));

        con.close();
        return human;
    }

    @Override
    public Human updateHuman(Human human) throws SQLException {
        String sql = "UPDATE people SET name='" +
                human.getName() + "',age='" + human.getAge() + "',comment='" + human.getComment() + "' " +
                "WHERE id=" + human.getId() + " RETURNING id;";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();

        con.close();
        return human;
    }

    @Override
    public void deleteHuman(Integer id) throws SQLException {
        String sql = "DELETE FROM people WHERE id="+id+" RETURNING id;";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        con.close();
    }
}
