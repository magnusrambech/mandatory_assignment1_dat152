package DAO;

import Entities.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductsDao {
      Connection conn;

      public ProductsDao(Connection conn){
            this.conn = conn;
      }
      private Products newProduct;

      public Products getNewProduct() {
            return newProduct;
      }

      public void addProducts(Integer pno, String pName, Integer priceInEuro, String imageFile){

            newProduct = new Products(pno, pName, priceInEuro, imageFile);

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
}
