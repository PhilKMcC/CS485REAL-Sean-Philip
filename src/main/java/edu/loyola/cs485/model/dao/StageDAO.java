package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StageDAO extends AbstractDAO<Stage>{

    @Override
    public void create(Stage entity) throws SQLException {
        Connection con = getConnection();

        String sql = "INSERT INTO Stage (name_stage, size, layout) VALUES (?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getName());
        pst.setString(2, entity.getSize());
        pst.setString(3, entity.getLayout());
        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()) {
            entity.setID(rs.getInt(1));
        }

        con.close();
    }

    @Override
    public Stage read(int ID) throws SQLException {
        Stage readStage = new Stage();
        Connection con = getConnection();

        String sql = "SELECT * FROM Stage WHERE id_stage = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);

        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            readStage.setID(rs.getInt("id_stage"));
            readStage.setName(rs.getString("name_stage"));
            readStage.setSize(rs.getString("size"));
            readStage.setLayout(rs.getString("layout"));
        }

        con.close();
        return readStage;
    }

    @Override
    public void update(Stage entity) throws SQLException {

    }

    @Override
    public void delete(int ID) throws SQLException {
        Connection con = getConnection();
        String sql = "DELETE FROM Stage where id_stage = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        pst.executeUpdate();

        con.close();
    }

    @Override
    public List<Stage> list() throws SQLException {
        ArrayList<Stage> stageList = new ArrayList<>();

        Connection con = getConnection();
        String sql = "SELECT * FROM Stage ORDER BY name_stage ";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Stage s = new Stage();
            s.setID(rs.getInt("id_stage"));
            s.setName(rs.getString("name_stage") );
            s.setSize(rs.getString("size"));
            s.setLayout(rs.getString("layout"));

            stageList.add(s);
        }

        return stageList;
    }
}
