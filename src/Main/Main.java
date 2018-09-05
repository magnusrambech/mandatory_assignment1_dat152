package Main;

import Controllers.DescriptionDAOController;
import Controllers.ProductsDAOController;
import DAO.ConnectionDAO;
import DAO.DescriptionDAO;
import DAO.SQLExecutor;
import Entities.Description;
import Entities.Product;

import java.io.FileNotFoundException;
import java.sql.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static Connection connection;

    public static void main(String[] args) throws FileNotFoundException, SQLException {

        // Kobler opp mot sqlite database og skriver sqlfilen til database.
        ConnectionDAO connDao = new ConnectionDAO("oblig.db");
        connection = connDao.getConnection();
        String fileToRead = "schema.sql";
        SQLExecutor readSql = new SQLExecutor(fileToRead, connection);


        ProductsDAOController prodDaoCont = new ProductsDAOController();
        ArrayList<Product> allProducts = prodDaoCont.getAllProducts();


        DescriptionDAOController descDaoCont = new DescriptionDAOController();
        ArrayList<Description> allDesc = descDaoCont.getAllDescriptions();


        printProducts(allProducts);
        printDescs(allDesc);



        //Stenger tilkobling mot databasen når programmet lukkes
        connection.close();

    }

    private static void printDescs(ArrayList<Description> e) {
            for(Description d: e){
                System.out.println(d.getdText());
            }
    }

    private static void printProducts(ArrayList<Product> e) {
        for(Product p : e){
            System.out.println(p.getpName());
        }
    }
}
