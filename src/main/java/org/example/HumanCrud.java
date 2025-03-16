package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public List<Human> getAllHumans() throws SQLException {

        String sql = "SELECT * FROM people;";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<Human> Humans = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String comment = rs.getString("comment");

            Human human = new Human(id,name,age,comment);
            Humans.add(human);

        }

        return Humans;
    }

    @Override
    public Human createHuman(Human human) throws SQLException {
        String sql = "INSERT INTO people (name, age, comment) VALUES ('" +
                human.getName() + "','" + human.getAge() + "','" + human.getComment() + "') RETURNING id;";

        Connection connection = new Connection();
        java.sql.Connection con = connection.connect();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

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
