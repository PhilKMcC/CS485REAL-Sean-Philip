package org.example;

import edu.loyola.cs485.model.dao.StageDAO;
import edu.loyola.cs485.model.entity.Stage;
import edu.loyola.cs485.view.MainFrame;

import java.sql.*;
import java.util.List;
public class Main {
    static String ConURL = "jdbc:mysql://localhost";
    static String Port = "3306";
    //static String Database = "";
    //static String Username = "";
    //static String Password = "";
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}