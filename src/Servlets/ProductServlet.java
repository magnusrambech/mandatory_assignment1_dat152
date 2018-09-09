package Servlets;

import Controllers.DescriptionDAOController;
import Controllers.ProductsDAOController;
import Entities.Product;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    public ProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductsDAOController productsDAOController = new ProductsDAOController();
        DescriptionDAOController descriptionDAOController = new DescriptionDAOController();
        ArrayList<Product> products = productsDAOController.getAllProducts();


        Cookie[] cookies = request.getCookies();
        Cookie localeCookie = null;
        boolean foundLocaleCookie = false;
        for (int i = 0; i < cookies.length ; i++) {
            if(cookies[i].getName().equals("locale")){
                foundLocaleCookie = true;
                localeCookie = cookies[i];
            }
        }
        if(localeCookie == null){
           localeCookie = new Cookie("locale", "nb_NO");
        }
        response.addCookie(localeCookie);

        for(Product p : products){
            p.setDesc(descriptionDAOController.getDescriptionByPno(p.getPno(),localeCookie.getValue()));
        }

        request.setAttribute("products",products);
        String url = "/products.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


}
