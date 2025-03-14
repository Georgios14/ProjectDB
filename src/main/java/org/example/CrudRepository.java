package org.example;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository {
    Human getHumanById(Integer id) throws SQLException;
    List<Human> getAllHumans();
    Human createHuman(Human human) throws SQLException;
    Human updateHuman(Human human) throws SQLException;
    void deleteHuman(Integer id) throws SQLException;
}
