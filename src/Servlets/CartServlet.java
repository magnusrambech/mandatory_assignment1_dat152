package Servlets;

import Controllers.CartDAOController;
import Controllers.DescriptionDAOController;
import Controllers.ProductsDAOController;
import Entities.CartLine;
import Entities.CurrencyConverter;
import Entities.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    CartDAOController cartDAOController = new CartDAOController();
    ProductsDAOController productsDAOController = new ProductsDAOController();
    DescriptionDAOController descriptionDAOController = new DescriptionDAOController();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action != null){
            if (action.equals("add")) {
                int pNo = Integer.parseInt(request.getParameter("pNo"));
                cartDAOController.addToCart(pNo);

                ArrayList<CartLine> lines = new ArrayList<CartLine>();
                HashMap<Integer,Integer> cart = cartDAOController.getCart();
                for(int key: cart.keySet()){
                    Product prod = productsDAOController.getProductByPno(key);
                    Cookie[] cookies =  request.getCookies();
                    Cookie locale = null;
                    for (int i = 0; i < cookies.length ; i++) {
                        if(cookies[i].getName().equals("locale")){
                            locale  = cookies[i];
                        }
                    }
                    if(locale==null){
                        locale = new Cookie("locale","nb_NO");
                        response.addCookie(locale);
                    }
                    else {
                        prod.setDesc(descriptionDAOController.getDescriptionByPno(prod.getPno(),locale.getValue()));
                    }

                    CurrencyConverter converter = new CurrencyConverter(locale.getValue());
                    prod.setPriceInEuro(converter.Convert(prod.getPriceInEuro()));

                    CartLine line = new CartLine(prod, cart.get(key));
                    lines.add(line);
                }

                String referrer = request.getHeader("referer");
                response.sendRedirect(referrer);

            }
            else if (request.getParameter("action").equals("clear")) {
                cartDAOController.emptyCart();
                String url = "/cart.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        }
        else {
            ArrayList<CartLine> lines = new ArrayList<CartLine>();
            HashMap<Integer,Integer> cart = cartDAOController.getCart();
            for(int key: cart.keySet()){
                Product prod = productsDAOController.getProductByPno(key);
                Cookie[] cookies =  request.getCookies();
                Cookie locale = null;
                for (int i = 0; i < cookies.length ; i++) {
                    if(cookies[i].getName().equals("locale")){
                        locale  = cookies[i];
                    }
                }
                if(locale==null){
                    locale = new Cookie("locale","nb_NO");
                    response.addCookie(locale);
                }
                else {
                    prod.setDesc(descriptionDAOController.getDescriptionByPno(prod.getPno(),locale.getValue()));
                }

                CurrencyConverter converter = new CurrencyConverter(locale.getValue());
                prod.setPriceInEuro(converter.Convert(prod.getPriceInEuro()));

                CartLine line = new CartLine(prod, cart.get(key));
                lines.add(line);
            }

            request.setAttribute("cart",lines);


            String url = "/cart.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
