package Servlets;

import Controllers.DescriptionDAOController;
import Controllers.ProductsDAOController;
import Entities.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GetProducts")
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
        String json = new Gson().toJson(products);
        String html = "<table style='border: 1px solid black'>";


        for(Product p : products){
            html += "<tr>";
             html += "<th>" + p.getpName() + "</th>";
             html += "<th>" + p.getPriceInEuro() + "</th>";
             html += "<th>" + descriptionDAOController.getDescriptionByPno(p.getPno(),"nb_NO").getdText() + "</th>" ;
             html += "<th>" + p.getpName() + "</th>";
            html+= "</tr>";
        }
        html += "</table>";


        response.getWriter().write(html);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


}
