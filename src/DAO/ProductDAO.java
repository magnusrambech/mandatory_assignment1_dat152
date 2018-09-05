package DAO;

import Entities.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
      Connection conn;

      public ProductDAO(Connection conn){
            this.conn = conn;
      }



      public void addProducts(Integer pno, String pName, Integer priceInEuro, String imageFile){
            Product newProduct;
            newProduct = new Product(pno, pName, priceInEuro, imageFile);

            String sql = "INSERT INTO products(pno, pName, priceInEuro, imageFile) VALUES(?,?,?,?)";
            try(

                PreparedStatement pstmt = conn.prepareStatement(sql)
            ){
                  pstmt.setInt(1, newProduct.getPno());
                  pstmt.setString(2, newProduct.getpName());
                  pstmt.setInt(3, newProduct.getPriceInEuro());
                  pstmt.setString(4, newProduct.getImageFile());
                  pstmt.executeUpdate();
            } catch (SQLException e) {
                  System.out.println(e.getMessage());
            }
      }

      public ArrayList<Product> getAllProducts(){
            ArrayList<Product> temp = new ArrayList<Product>();

            try{
                  Statement statement =  conn.createStatement();
                  ResultSet rs = statement.executeQuery("SELECT * FROM products");

                  while(rs.next()){
                        Product currProd = new Product();
                        currProd.setPno(rs.getInt("pno"));
                        currProd.setpName(rs.getString("pname"));
                        currProd.setPriceInEuro(rs.getInt("priceInEuro"));
                        currProd.setImageFile(rs.getString("imageFile"));

                        temp.add(currProd);
                  }

            } catch (SQLException e) {
                  e.printStackTrace();
            }


            return temp;
      }


}
