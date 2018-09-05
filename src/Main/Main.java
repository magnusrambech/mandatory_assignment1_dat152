package Main;

import Controllers.DescriptionDAOController;
import Controllers.ProductsDAOController;
import DAO.ConnectionDAO;
import DAO.SQLExecutor;

import java.io.FileNotFoundException;
import java.sql.*;


import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static Connection connection;

    public static void main(String[] args) throws FileNotFoundException, SQLException {

        // Kobler opp mot sqlite database og skriver sqlfilen til database.
        ConnectionDAO connDao = new ConnectionDAO("oblig.db");
        connection = connDao.getConnection();
        String fileToRead = "schema.sql";
        SQLExecutor readSql = new SQLExecutor(fileToRead, connection);


        ProductsDAOController prodDaoCont = new ProductsDAOController();
        prodDaoCont.getAllProducts();

        DescriptionDAOController descDaoCont = new DescriptionDAOController();
        descDaoCont.getAllDescriptions();

        //Stenger tilkobling mot databasen når programmet lukkes
        connection.close();

    }
}
