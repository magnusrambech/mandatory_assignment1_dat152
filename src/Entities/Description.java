
package Entities;

public class Description {
      private Integer pno;
      private String langCode;
      private String dText;
      private String symbol;


      public Description(){

      }
      public Description(Integer pno, String langCode, String dText, String symbol) {

            this.pno = pno;
            this.langCode = langCode;
            this.dText = dText;
            this.symbol = symbol;
      }

      public Integer getPno() {
            return pno;
      }

      public void setPno(Integer pno) {
            this.pno = pno;
      }

      public String getLangCode() {
            return langCode;
      }

      public void setLangCode(String langCode) {
            this.langCode = langCode;
      }

      public String getdText() {
            return dText;
      }

      public void setdText(String dText) {
            this.dText = dText;
      }

      public String getSymbol() {
            return symbol;
      }

      public void setSymbol(String symbol) {
            this.symbol = symbol;
      }
}
