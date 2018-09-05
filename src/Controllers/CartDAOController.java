package Controllers;

import DAO.CartDAO;
import DAO.DescriptionDAO;
import Entities.Description;
import Main.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CartDAOController {
    public Connection conn = Main.connection;
    CartDAO cartDAO = new CartDAO(conn);

}
