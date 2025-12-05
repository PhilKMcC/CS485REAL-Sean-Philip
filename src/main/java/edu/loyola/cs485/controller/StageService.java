package edu.loyola.cs485.controller;

import edu.loyola.cs485.model.entity.Stage;
import edu.loyola.cs485.model.dao.StageDAO;
import java.util.List;


public class StageService {
    public Stage createStage(String name, String size, String layout) throws Exception {

        Stage stage = new Stage();
        stage.setName(name);
        stage.setSize(size);
        stage.setLayout(layout);

        StageDAO dao = new StageDAO();
        dao.create(stage);

        return stage;
    }
    public Stage readStage(int id) throws Exception {
        StageDAO dao = new StageDAO();
        return dao.read(id);
    }

    public void updateStage(int id, String name, String size, String layout) throws Exception {

        Stage stage = new Stage();
        stage.setID(id);
        stage.setName(name);
        stage.setSize(size);
        stage.setLayout(layout);

        StageDAO dao = new StageDAO();
        dao.update(stage);
    }

    public void deleteStage(int id) throws Exception {
        StageDAO dao = new StageDAO();
        dao.delete(id);
    }

    public List<Stage> getAllStages() throws Exception {
        StageDAO dao = new StageDAO();
        return dao.list();
    }






}
