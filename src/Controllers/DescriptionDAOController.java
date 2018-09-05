package Controllers;

import DAO.DescriptionDAO;
import Entities.Description;
import Main.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DescriptionDAOController {
    public Connection conn  = Main.connection;
    DescriptionDAO descDao = new DescriptionDAO(conn);


    public ArrayList<Description> getAllDescriptions(){
        return descDao.getAllDescriptions();
    }

}
