package CustomTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class CustomTag extends SimpleTagSupport {

    String year = "1995"; // Default year

    @Override
        public void doTag() throws JspException, IOException{
        JspWriter out = getJspContext().getOut();
        int yearInt = Integer.parseInt(year);
        out.print("© " +  toRoman(yearInt) + " HiB");
    }

    public void setYear(String year){
        this.year = year;
    }

    private static String toRoman(int number) {
        return String.valueOf(new char[number]).replace('\0', 'I')
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }


}
