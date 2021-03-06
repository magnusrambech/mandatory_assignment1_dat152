package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

/**
 * Servlet implementation class SetLanguageServlet.
 */
@WebServlet("/SetLanguage")
public class LanguageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LanguageServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String locale = request.getParameter("locale");
        if (locale != null) {
            Config.set(request.getSession(), Config.FMT_LOCALE, locale);

            Cookie localeCookie = new Cookie("locale", locale);
            localeCookie.setMaxAge(30 * 24 * 60 * 60); // One month in seconds,
            response.addCookie(localeCookie);
        }

        String referrer = request.getHeader("referer");
        response.sendRedirect(referrer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}