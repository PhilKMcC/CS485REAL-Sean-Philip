package edu.loyola.cs485.model.dao;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import edu.loyola.cs485.model.dao.StageDAO;
import edu.loyola.cs485.model.entity.Stage;

import java.sql.SQLException;


public class StageDAOTest {

    @Test
    public void TestCreateStage() throws Exception{
        StageDAO dao = new StageDAO();
        dao.setTestDatabase();
        Stage stage = new Stage();

        stage.setName("mansion");
        stage.setSize("big");
        stage.setLayout("standard");

        dao.create(stage);

        assertAll(
                () -> assertNotNull(stage.getID())
        );
    }


    @Test
    public void testReadClient() throws Exception{
        StageDAO dao = new StageDAO();
        dao.setTestDatabase();

        Stage stage = new Stage();
        stage.setName("Testing Stage");
        stage.setSize("medium");
        stage.setLayout("Test Layout");

        dao.create(stage);
        Stage found = dao.read(stage.getID()); //Function under test

        //clean up
        dao.delete( stage.getID() );

        assertAll(
                () -> assertEquals(found.getID(), stage.getID()),
                () -> assertEquals(found.getName(), stage.getName()),
                () -> assertEquals(found.getSize(), stage.getSize()),
                () -> assertEquals(found.getLayout(), stage.getLayout())
        );

    }
}
