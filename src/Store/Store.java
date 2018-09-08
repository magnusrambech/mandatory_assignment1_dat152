package Store;

import Controllers.*;
import Entities.*;

import java.sql.Connection;
import java.util.*;

public class Store {
    Connection conn;
    ProductsDAOController prodDaoCont;
    DescriptionDAOController descDaoCon;
    Locale[] locales = {new Locale("en","US"), new Locale("nb","NO"),new Locale("nl","NL")};

    Cart cart;
    Locale selectedLocale;
    boolean open;
    Scanner reader =  new Scanner(System.in);



    public Store(Connection conn){
        this.conn = conn;
        selectedLocale = locales[0]; // this should be set based on http header / cookie
        open = true;
        prodDaoCont = new ProductsDAOController();
        descDaoCon = new DescriptionDAOController();
        cart = new Cart();
    }


    public void init(){
        while(open){
            //Ask for input
           int choice =  askForInput();
           if(choice == 1){
               showProducts();
           }
           else if(choice == 2){
               viewCart();
           }
           else if(choice == 3){
               changeLanguage();
           }
            else if (choice == 4){
               viewCart();
           }
           System.out.println("Keep shopping? y/n");
           String keepShopping = reader.nextLine();
            System.out.println(keepShopping + "________________________");
            if(keepShopping.equals("n")){
                open=false;
            }

        }

    }

    private void changeLanguage() {
        boolean valid = false;
        int count = 1;
        int choice = 0;
        while(!valid){
            System.out.println("Availables languages:");
            for(Locale l:locales){
                System.out.println(count + ": " + l.toString());
                count++;
            }

            choice = reader.nextInt();

            if (choice > 0 && choice <= locales.length){
                selectedLocale = locales[choice-1];
                valid = true;
            }
        }
    }

    private void addToCart(Integer pNo){
        cart.addToCart(pNo);
    }

    private void viewCart() {
        HashMap<Integer, Integer> cartMap = cart.getCart();
        System.out.println(cartMap.keySet());
        for (Integer pNo : cartMap.keySet()){
            Product prod = prodDaoCont.getProductByPno(pNo);
            Description desc = descDaoCon.getDescriptionByPno(pNo, selectedLocale.toString());
            System.out.println("name: " + prod.getpName() + " | Description: " + desc.getdText() + " | Price: " + prod.getPriceInEuro() + " | Quantity: " + cartMap.get(pNo) + " | Total Price: " + prod.getPriceInEuro()*cartMap.get(pNo));
        }
    }

    private void showProducts() {
        HashMap<Product, Description> products = new HashMap<Product, Description>();
        ArrayList<Product> allProds = prodDaoCont.getAllProducts();
        for(Product p : allProds){
            products.put(p,descDaoCon.getDescriptionByPno(p.getPno(),selectedLocale.toString()));
        }

        for (Product k:products.keySet()){
            System.out.println(k.getpName() + " : " + products.get(k).getdText() + " | " + k.getPriceInEuro()  );
        }

    }


    private int askForInput(){
        boolean valid = false;
        int choice = 0;
        while(!valid){
            String[] possible = {"1: View products","2: View cart", "3: Change language","4: View cart"};
            System.out.println("Welcome to the store! What would you like to do?");
            listOptions(possible);

            choice = reader.nextInt();
            reader.nextLine();
            if(choice <= possible.length && choice >  0){
                valid = true;
            }
        }


        return choice;
    }

    private void listOptions(String[] e){
        for(int i = 0; i < e.length ; i++) {
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
