package edu.loyola.cs485.model.dao;

import java.sql.*;
import java.util.*;


public abstract class AbstractDAO<E> {
    //change these to connect with db
    private String ConUrl = "jdbc:mysql://localhost"; //protocol + url
    private String Port = "3306"; //default MySQL port
    private String Database = "game_db"; // database/schema name
    private String Username = "cs485"; //read this from a local file
    private String Password = "password"; //Also read this from a file

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ConUrl+":"+Port+"/"+Database+ "?user="+Username+"&password="+Password);
    }

    // Abstract Methods for each CRUD operation
    public abstract void create(E entity) throws SQLException;
    public abstract E read(int ID) throws SQLException;
    public abstract void update(E entity) throws SQLException;
    public abstract void delete(int ID) throws SQLException;
    public abstract List<E> list() throws SQLException;

    //for testing
    public void setTestDatabase(){
        this.Database = "game_db_test";
    }

}
