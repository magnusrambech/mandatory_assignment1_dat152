package Main;

import Controllers.DescriptionDAOController;
import Controllers.ProductsDAOController;
import DAO.ConnectionDAO;
import DAO.DescriptionDAO;
import DAO.SQLExecutor;
import Entities.Description;
import Entities.Product;
import Store.Store;

import java.io.FileNotFoundException;
import java.sql.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static Connection connection;

    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
                 init();


    }

    public static void init() throws FileNotFoundException, SQLException, ClassNotFoundException {

        // Kobler opp mot sqlite database og skriver sqlfilen til database.
        //ConnectionDAO connDao = new ConnectionDAO("oblig.db");
        // connection = connDao.getConnection();

        // System.out.println("test");
        //String fileToRead = "schema.sql";
        // SQLExecutor readSql = new SQLExecutor(fileToRead, connection);

        //Starts store
         Store store = new Store();
         store.init();






        //Stenger tilkobling mot databasen når programmet lukkes
        //connection.close();
    }


}
