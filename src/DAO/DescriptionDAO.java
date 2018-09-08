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
      public DescriptionDAO(){

      }

//Integer pno, String langCode, String dText
      public ArrayList<Description> getAllDescriptionsMock(){
            ArrayList<Description> temp = new ArrayList<Description>();
            Description orangeJuiceEnUs = new Description(1,"en_US","OJ - not from concentrate");
            Description orangeJuiceNbNo = new Description(1, "nb_NO", "Appelsinjuice - ikke fra konsentrat");
            Description orangeJuiceNlNl = new Description(1, "nl_NL", "Sinaasappelsap - niet van concentraat");
            Description avocadoNbNo = new Description(2, "nb_NO", "Avokado fra Peru");
            Description avocadoEnUs = new Description(2,"en_US","Avocado from Peru");
            Description avocadoNlNl = new Description(2,"nl_NL","Avocado uit Peru");


            temp.add(orangeJuiceEnUs);
            temp.add(orangeJuiceNbNo);
            temp.add(orangeJuiceNlNl);
            temp.add(avocadoEnUs);
            temp.add(avocadoNbNo);
            temp.add(avocadoNlNl);

            return temp;
      }

      public Description getDescriptionByPnoMock(int pNo, String langCode){
            ArrayList<Description> all = this.getAllDescriptionsMock();
            for(Description d:all){
                  if(d.getPno()==pNo && d.getLangCode().equals(langCode)){
                        return d;
                  }
            }
            return null;
      }


      //SQL
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
                  ResultSet rs = statement.executeQuery("SELECT * FROM description WHERE pno='" + pno + "' AND langCode='" + langCode + "' ");

                  while(rs.next()){
                        desc = new Description();
                        desc.setLangCode(rs.getString("langCode"));
                        desc.setdText(rs.getString("dText"));
                        desc.setPno(rs.getInt("pno"));
                  }



            }catch (SQLException e){
                  e.printStackTrace();
            }


            return desc;
      }

}
