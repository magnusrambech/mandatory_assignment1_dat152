package Entities;

import java.text.DecimalFormat;

public class CurrencyConverter {
    String lang;
    Double convertion;

    public CurrencyConverter(String lang) {
        this.lang = lang;
    }

    public Double Convert(Double number){

        switch (lang) {
            case "nb_NO" :
                convertion = 9.78;
                break;
            case "en_US" :
                convertion = 1.16;
                break;
            case "nl_NL" :
                convertion = 1.00;
                break;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(number*convertion));

    }
}
