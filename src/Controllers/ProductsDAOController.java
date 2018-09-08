package Controllers;

import DAO.ProductDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entities.Product;
import Main.Main;
public class ProductsDAOController {

    public Connection conn = Main.connection;
    ProductDAO prodDao = new ProductDAO(conn);


    public ArrayList<Product> getAllProducts(){
       return prodDao.getAllProducts();
    }

    public Product getProductByPno(Integer pNo) { return prodDao.getProductByPno(pNo);}
}
