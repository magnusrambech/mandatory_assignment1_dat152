package DAO;

import Entities.Description;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DescriptionDAO {
      Connection conn;

      public DescriptionDAO(Connection conn){
            this.conn = conn;
      }

      private Description newDescription;

      public Description getNewDescription() {
            return newDescription;
      }

      public void addDescription(Integer pno, String langCode, String dText) {

            newDescription = new Description(pno, langCode, dText);

            String sql = "INSERT INTO description(pno, langCode, dText) VALUES(?,?,?)";



            try (

                 PreparedStatement pstmt = conn.prepareStatement(sql)
            ) {

                  pstmt.setInt(1, newDescription.getPno());
                  pstmt.setString(2, newDescription.getLangCode());
                  pstmt.setString(3, newDescription.getdText());
                  pstmt.executeUpdate();
                  System.out.println("Description lagt til");
            } catch (SQLException e) {
                  System.out.println(e.getMessage());
            }
      }

}
