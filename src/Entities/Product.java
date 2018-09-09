
package Entities;

public class Product {
      private Integer pno;
      private String pName;
      private Double priceInEuro;
      private  String imageFile;
      private Description desc;

      public Product(){

      }
      public Product(Integer pno, String pName, Double priceInEuro, String imageFile) {
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

      public Double getPriceInEuro() {
            return priceInEuro;
      }

      public void setPriceInEuro(Double priceInEuro) {
            this.priceInEuro = priceInEuro;
      }

      public String getImageFile() {
            return imageFile;
      }

      public void setImageFile(String imageFile) {
            this.imageFile = imageFile;
      }



      public void setDesc(Description desc) {
            this.desc = desc;
        }

        public Description getDesc() {
            return desc;
        }
}
