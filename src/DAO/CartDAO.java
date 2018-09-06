package DAO;

import Entities.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {

      Connection conn;

      public CartDAO(Connection conn){
            this.conn =  conn;
      }

      private Cart newCart;


      public void addCart(String langCode, Integer pno){

            newCart = new Cart(langCode,pno);

            String sql = "INSERT INTO cart(langCode, pno)";



            try(
                PreparedStatement pstmt = conn.prepareStatement(sql)
            ) {

                  pstmt.setString(1,newCart.getLangCode());
                  pstmt.setInt(2,newCart.getPno());
            }catch (SQLException e) {
                  System.out.println(e.getMessage());
            }

      }
}
