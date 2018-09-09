package DAO;

import Entities.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
      Connection conn;

      public ProductDAO(Connection conn){
            this.conn = conn;
      }

      public ProductDAO(){}

      //Mock methods

      public ArrayList<Product> getAllProductsMock(){
            ArrayList<Product> temp = new ArrayList<Product>();
            Product OJ = new Product(1, "Orange Juice", 3, "orange.jpg");
            Product Avac = new Product(2,"Avocado",2,"avocado.jpg");
            temp.add(OJ);
            temp.add(Avac);

            return temp;
      }

      public Product getProductByPnoMock(int pNo){
            ArrayList<Product> all = this.getAllProductsMock();
            for(Product p: all){
                  if(p.getPno() == pNo){
                        return p;
                  }
            }
            return null;
      }



      // SQL methods. Working, but decided to hardcode as sqlite caused nothing but trouble when working collabrative
      public void addProducts(Integer pno, String pName, Integer priceInEuro, String imageFile){
            Product newProduct;
            newProduct = new Product(pno, pName, priceInEuro, imageFile);

            String sql = "INSERT INTO products(pno, pName, priceInEuro, imageFile) VALUES(?,?,?,?)";
            try(

                PreparedStatement pstmt = conn.prepareStatement(sql)
            ){
                  pstmt.setInt(1, newProduct.getPno());
                  pstmt.setString(2, newProduct.getpName());
                  pstmt.setDouble(3, newProduct.getPriceInEuro());
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

      public Product getProductByPno(Integer pNo){
            try{
                  Statement statement =  conn.createStatement();
                  ResultSet rs = statement.executeQuery("SELECT * FROM products WHERE pNo= '" + pNo + "'");

                  while(rs.next()){
                        Product product = new Product();
                        product.setPno(rs.getInt("pno"));
                        product.setpName(rs.getString("pname"));
                        product.setPriceInEuro(rs.getInt("priceInEuro"));
                        product.setImageFile(rs.getString("imageFile"));
                        return product;
                  }

            } catch (SQLException e) {
                  e.printStackTrace();
            }


            return null;
      }
}
