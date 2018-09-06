package DAO;

import Entities.Description;
import Entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class DescriptionDAO {
      Connection conn;

      public DescriptionDAO(Connection conn){
            this.conn = conn;
      }



      public void addDescription(Integer pno, String langCode, String dText) {
            Description newDescription;
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

      public ArrayList<Description> getAllDescriptions(){
            ArrayList<Description> temp = new ArrayList<Description>();

            try{
                  Statement statement =  conn.createStatement();
                  ResultSet rs = statement.executeQuery("SELECT * FROM description");

                  while(rs.next()){
                        Description currDesc = new Description();
                        currDesc.setPno(rs.getInt("pno"));
                        currDesc.setdText(rs.getString("dText"));
                        currDesc.setLangCode(rs.getString("langCode"));

                        temp.add(currDesc);
                  }

            } catch (SQLException e) {
                  e.printStackTrace();
            }


            return temp;
      }

      public Description getDescriptionByPno(int pno, String langCode){
                  Description desc = new Description();
            try{
                  Statement statement = conn.createStatement();
                  ResultSet rs = statement.executeQuery("SELECT * FROM description WHERE pno=" + pno + " AND langCode=" );

                  while(rs.next()){
                        desc = new Description();
                        desc.setLangCode(rs.getString("langCode"));
                        desc.setdText(rs.getString("dText"));
                        desc.setPno(rs.getInt("pno"));
                        System.out.println(rs.getString("dText"));
                  }



            }catch (SQLException e){
                  e.printStackTrace();
            }


            return desc;
      }

}
