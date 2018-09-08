
package Entities;

public class Product {
      private Integer pno;
      private String pName;
      private Integer priceInEuro;
      private  String imageFile;

      public Product(){

      }
      public Product(Integer pno, String pName, Integer priceInEuro, String imageFile) {
            this.pno = pno;
            this.pName = pName;
            this.priceInEuro = priceInEuro;
            this.imageFile = imageFile;
      }


      public Integer getPno() {
            return pno;
      }

      public void setPno(Integer pno) {
            this.pno = pno;
      }

      public String getpName() {
            return pName;
      }

      public void setpName(String pName) {
            this.pName = pName;
      }

      public Integer getPriceInEuro() {
            return priceInEuro;
      }

      public void setPriceInEuro(Integer priceInEuro) {
            this.priceInEuro = priceInEuro;
      }

      public String getImageFile() {
            return imageFile;
      }

      public void setImageFile(String imageFile) {
            this.imageFile = imageFile;
      }
}
