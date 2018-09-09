package CustomTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ShortTextTag extends SimpleTagSupport{
        int maxchars = 100; //default
        String fullText ="";

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String shortText = fullText;

        if(shortText.length() > maxchars){
            shortText = shortText.substring(0, Math.min(shortText.length(), 7));
            shortText += "...";
        }
        out.print(shortText);
    }

    public void setMaxchars(int maxchars) {
        this.maxchars = maxchars;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }
}
