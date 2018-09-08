package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
//urlpatterns betyr at hvis du skriver http://localHost:8080/home så kommer du til denne servlet filen
public class HomeServlet extends HttpServlet {

    /*
    Server kaller denne metoden for å håndtere alle PUT requests
    Det skjer når man henter informasjon fra user input som form, knapp etc.
    akkuratt nå blir bruker sendt hit fra home.jsp når de trykker på submit knappen

    merk at denne klassen fungerer som en helt vanlig java klasse og vi kan kommunisere med- og
    instansiere andre klasser som vi har lagd tidligere
     */
    //
    //
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        //definerer hva type informasjon som skal sendes ut til klient
        response.setContentType("text/html");

        //returnerer en printWriter som kan brukes til å skrive direkte inn til klienten
        PrintWriter out = response.getWriter();

        out.println("<h1>Hello, welcome to my store </h1>");
    }

    //Server kaller denne metoden for å håndtere alle GET requests
    //GET requests er informasjon som kommer via URL.
    //eksempel: myCity.com/about.html?city=Stavanger
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
