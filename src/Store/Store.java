package Store;

import Controllers.*;
import Entities.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Store {
    CartDAOController cartDAOController;
    Connection conn;
    ProductsDAOController prodDaoCont;
    DescriptionDAOController descDaoCon;
    Locale enUS = new Locale("en","US");
    Locale nbNO = new Locale("nb","NO");
    Locale nlNL =  new Locale("nl","NL");
    Locale selectedLocale;
    boolean open;
    Scanner reader =  new Scanner(System.in);



    public Store(Connection conn){
        this.conn = conn;

        open = true;
        prodDaoCont = new ProductsDAOController();
        descDaoCon = new DescriptionDAOController();
        cartDAOController = new CartDAOController();
    }


    public void init(){
        while(open){
            //Ask for input
           int choice =  askForInput();


           open=false;
        }

        reader.close();
    }


    private int askForInput(){
        boolean valid = false;
        int choice = 0;
        while(!valid){
            String[] possible = {"1: View products","2: View cart", "3: Change language"};
            System.out.println("Welcome to the store! What would you like to do?");
            listOptions(possible);

            choice = reader.nextInt();
            if(choice <= possible.length && choice >  0){
                valid = true;
            }
        }


        return choice;
    }

    private void listOptions(String[] e){
        for (int i = 0; i < e.length ; i++) {
            System.out.println(e[i]);
        }
    }



    private static void printDescs(ArrayList<Description> e) {
        for(Description d: e){
            System.out.println(d.getdText());
        }
    }

    private static void printProducts(ArrayList<Product> e) {
        for(Product p : e){
            System.out.println(p.getpName());
        }
    }


}
