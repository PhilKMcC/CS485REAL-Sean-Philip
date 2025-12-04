package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.Stage;

import java.sql.SQLException;
import java.util.List;

public class StageDAO extends AbstractDAO<Stage>{

    @Override
    public void create(Stage entity) throws SQLException {

    }

    @Override
    public Stage read(int ID) throws SQLException {
        return null;
    }

    @Override
    public void update(Stage entity) throws SQLException {

    }

    @Override
    public void delete(int ID) throws SQLException {

    }

    @Override
    public List<Stage> list() throws SQLException {
        return List.of();
    }
}
