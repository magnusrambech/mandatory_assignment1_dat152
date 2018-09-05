
package Entities;

public class Cart {
      private String langCode;
      private Integer pno;

      public Cart(String langCode, Integer pno) {
            this.langCode = langCode;
            this.pno = pno;
      }

      public String getLangCode() {
            return langCode;
      }

      public void setLangCode(String langCode) {
            this.langCode = langCode;
      }

      public Integer getPno() {
            return pno;
      }

      public void setPno(Integer pno) {
            this.pno = pno;
      }
}

